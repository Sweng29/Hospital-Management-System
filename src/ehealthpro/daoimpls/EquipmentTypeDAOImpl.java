/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.EquipmentTypeDAO;
import ehealthpro.models.EquipmentTypeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class EquipmentTypeDAOImpl implements EquipmentTypeDAO{
    Connection conn=DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;
    
    @Override
    public ResultSet getAllEquipmentType() {
       ResultSet resultSet=null;
       try{
           String query="Select e.equipment_type_id as 'Equipment Type ID',e.name as 'Equipment Type',"
                   + " ec.name as 'Created By',em.name as 'Modified By' "
                   + " from equipment_type e inner join user_login ec On e.created_by = ec.user_id "
                   + " inner join user_login em On e.modified_by = em.user_id where e.active=1";
           preparedStatement=conn.prepareStatement(query);
           resultSet=preparedStatement.executeQuery();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return resultSet; 
    }

    @Override
    public Integer addEquipmentType(EquipmentTypeModel equipmentTypeModel) {
       Integer result=0;
       try{
           String query="Insert into equipment_type(name,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?);";
           preparedStatement=conn.prepareStatement(query);
           preparedStatement.setString(1, equipmentTypeModel.getName());
           preparedStatement.setInt(2, equipmentTypeModel.getCreatedBy());
           preparedStatement.setTimestamp(3,equipmentTypeModel.getCreatedDate());
           preparedStatement.setInt(4, equipmentTypeModel.getModifiedBy());
           preparedStatement.setTimestamp(5,equipmentTypeModel.getModifiedDate());
           result=preparedStatement.executeUpdate();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return result;
    }

    @Override
    public Integer updateEquipmentType(EquipmentTypeModel equipmentTypeModel) {
        Integer result=0;
         try{
             String query="update equipment_type set name=?,modified_by =?,modified_date=? where equipment_type_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setString(1,equipmentTypeModel.getName());
             preparedStatement.setInt(2, equipmentTypeModel.getModifiedBy());
             preparedStatement.setTimestamp(3,equipmentTypeModel.getModifiedDate());
             preparedStatement.setInt(4, equipmentTypeModel.getEquipmentTypeId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result; 
    }

    @Override
    public Integer deleteEquipmentTypeById(EquipmentTypeModel equipmentTypeModel) {
        Integer result=0;
         try{
             String query="update equipment_type set active=0 , modified_by = ?,modified_date=? where equipment_type_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setInt(1,equipmentTypeModel.getModifiedBy());
             preparedStatement.setTimestamp(2,equipmentTypeModel.getModifiedDate());
             preparedStatement.setInt(3,equipmentTypeModel.getEquipmentTypeId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result;
    }

    @Override
    public EquipmentTypeModel getEquipmentTypeById(Integer equipmentTypeId) {
       EquipmentTypeModel equipmentTypeModel= new EquipmentTypeModel();
       try{
           String query = "SELECT * FROM equipment_type where equipment_type_id =? AND active = 1";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setInt(1, equipmentTypeId);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               equipmentTypeModel.setEquipmentTypeId(resultSet.getInt("equipment_type_id"));
               equipmentTypeModel.setName(resultSet.getString("name"));
               equipmentTypeModel.setCreatedBy(resultSet.getInt("created_by"));
               equipmentTypeModel.setCreatedDate(resultSet.getTimestamp("created_date"));
               equipmentTypeModel.setModifiedBy(resultSet.getInt("modified_by"));
               equipmentTypeModel.setModifiedDate(resultSet.getTimestamp("modified_date"));
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return equipmentTypeModel;
    }

    @Override
    public EquipmentTypeModel getEquipmentTypeByName(String equipmentType) {
    EquipmentTypeModel equipmentTypeModel= new EquipmentTypeModel();
       try{
           String query = "SELECT * FROM equipment_type where name =? AND active = 1";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setString(1, equipmentType);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               equipmentTypeModel.setEquipmentTypeId(resultSet.getInt("equipment_type_id"));
               equipmentTypeModel.setName(resultSet.getString("name"));
               equipmentTypeModel.setCreatedBy(resultSet.getInt("created_by"));
               equipmentTypeModel.setCreatedDate(resultSet.getTimestamp("created_date"));
               equipmentTypeModel.setModifiedBy(resultSet.getInt("modified_by"));
               equipmentTypeModel.setModifiedDate(resultSet.getTimestamp("modified_date"));
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return equipmentTypeModel;    
    }
    
}
