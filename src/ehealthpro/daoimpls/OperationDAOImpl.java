/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.OperationDAO;
import ehealthpro.models.OperationModel;
import ehealthpro.models.OperationResultModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class OperationDAOImpl implements OperationDAO{

    Connection conn=DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;
    
    @Override
    public ResultSet getAllOperations() {
        ResultSet resultSet=null;
       try{
           String query="SELECT o.`operation_id` AS 'Operation ID',o.`type` AS 'Operation Type',o.`charges` AS 'Charges',\n" +
            "uc.`name` AS 'Created By',um.`name` AS 'Modified By'\n" +
            "FROM operation o INNER JOIN user_login uc ON o.`created_by` = uc.`user_id`\n" +
            "INNER JOIN user_login um ON o.`modified_by` = um.`user_id` AND o.`active` = 1;";
           preparedStatement=conn.prepareStatement(query);
           resultSet=preparedStatement.executeQuery();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return resultSet;
    }

    @Override
    public Integer addOperation(OperationModel operationModel) {
       Integer result=0;
       try{
           String query="Insert into operation(type,charges,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?);";
           preparedStatement=conn.prepareStatement(query);
           preparedStatement.setString(1,operationModel.getType());
           preparedStatement.setString(2, operationModel.getCharges());
           preparedStatement.setInt(3, operationModel.getCreatedBy());
           preparedStatement.setTimestamp(4, operationModel.getCreatedDate());
           preparedStatement.setInt(5, operationModel.getModifiedBy());
           preparedStatement.setTimestamp(6, operationModel.getModifiedDate());
           result=preparedStatement.executeUpdate();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return result;
    }

    @Override
    public Integer updateOperation(OperationModel operationModel) {
        Integer result=0;
         try{
             String query="update operation set type=?,charges = ?,modified_by =?,modified_date=? where operation_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setString(1,operationModel.getType());
             preparedStatement.setString(2, operationModel.getCharges());
             preparedStatement.setInt(3, operationModel.getModifiedBy());
             preparedStatement.setTimestamp(4, operationModel.getModifiedDate());
             preparedStatement.setInt(5, operationModel.getOperationId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result;
    }

    @Override
    public Integer deleteOperationById(OperationModel operationModel) {
        Integer result=0;
         try{
             String query="update operation set active=0 , modified_by = ?,modified_date=? where operation_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setInt(1,operationModel.getModifiedBy());
             preparedStatement.setTimestamp(2, operationModel.getModifiedDate());
             preparedStatement.setInt(3,operationModel.getOperationId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result;
    }

    @Override
    public OperationModel getOperationById(Integer operationId) {
        OperationModel operationModel = new OperationModel();
       try{
           String query = "SELECT * FROM operation where operation_id =? AND active = 1";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setInt(1,operationId);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               operationModel.setOperationId(resultSet.getInt("operation_id"));
               operationModel.setType(resultSet.getString("type"));
               operationModel.setCharges(resultSet.getString("charges"));
               operationModel.setCreatedBy(resultSet.getInt("created_by"));
               operationModel.setCreatedDate(resultSet.getTimestamp("created_date"));
               operationModel.setModifiedBy(resultSet.getInt("modified_by"));
               operationModel.setModifiedDate(resultSet.getTimestamp("modified_date"));
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return operationModel;
    }

    @Override
    public OperationModel getOperationByName(String operationName) {
        OperationModel operationModel = new OperationModel();
       try{
           String query = "SELECT * FROM operation where type =? AND active = 1";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setString(1,operationName);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               operationModel.setOperationId(resultSet.getInt("operation_id"));
               operationModel.setType(resultSet.getString("type"));
               operationModel.setCharges(resultSet.getString("charges"));
               operationModel.setCreatedBy(resultSet.getInt("created_by"));
               operationModel.setCreatedDate(resultSet.getTimestamp("created_date"));
               operationModel.setModifiedBy(resultSet.getInt("modified_by"));
               operationModel.setModifiedDate(resultSet.getTimestamp("modified_date"));
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return operationModel;
    }
}
