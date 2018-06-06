/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.ManufacturerDAO;
import ehealthpro.models.ManufacturerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class ManufacturerDAOImpl implements ManufacturerDAO{

    Connection conn=DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;
    
    @Override
    public ResultSet getAllManufacturer() {
       ResultSet resultSet=null;
       try{
           String query="Select m.manufacturer_id as 'Manufacturer ID',m.name as 'Manufacturer',mc.name as 'Created By',"
                   + " mm.name as 'Modified By' from manufacturers m "
                   + " inner join user_login mc On m.created_by = mc.user_id "
                   + " inner join user_login mm On m.modified_by = mm.user_id where m.active=1";
           preparedStatement=conn.prepareStatement(query);
           resultSet=preparedStatement.executeQuery();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return resultSet;
    }

    @Override
    public Integer addManufacturer(ManufacturerModel manufacturerModel) {
      Integer result=0;
       try{
           String query="Insert into manufacturers(name,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?);";
           preparedStatement=conn.prepareStatement(query);
           preparedStatement.setString(1, manufacturerModel.getName());
           preparedStatement.setInt(2, manufacturerModel.getCreatedBy());
           preparedStatement.setTimestamp(3, manufacturerModel.getCreatedDate());
           preparedStatement.setInt(4, manufacturerModel.getModifiedBy());
           preparedStatement.setTimestamp(5, manufacturerModel.getModifiedDate());
           result=preparedStatement.executeUpdate();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return result;
    }

    @Override
    public Integer updateManufacturer(ManufacturerModel manufacturerModel) {
        Integer result=0;
         try{
             String query="update manufacturers set name=?,modified_by =?,modified_date=? where manufacturer_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setString(1,manufacturerModel.getName());
             preparedStatement.setInt(2, manufacturerModel.getModifiedBy());
             preparedStatement.setTimestamp(3, manufacturerModel.getModifiedDate());
             preparedStatement.setInt(4, manufacturerModel.getManufacturerId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result;
    }

    @Override
    public Integer deleteManufacturerById(ManufacturerModel manufacturerModel) {
        Integer result=0;
         try{
             String query="update manufacturers set active=0 , modified_by = ?,modified_date=? where manufacturer_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setInt(1,manufacturerModel.getModifiedBy());
             preparedStatement.setTimestamp(2, manufacturerModel.getModifiedDate());
             preparedStatement.setInt(3,manufacturerModel.getManufacturerId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result;
    }

    @Override
    public ManufacturerModel getManufacturerById(Integer manufacturerId) {
       ManufacturerModel manufacturerModel = new ManufacturerModel();
       try{
           String query = "SELECT * FROM manufacturers where manufacturer_id =? AND active = 1";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setInt(1, manufacturerId);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               manufacturerModel.setManufacturerId(resultSet.getInt("manufacturer_id"));
               manufacturerModel.setName(resultSet.getString("name"));
               manufacturerModel.setCreatedBy(resultSet.getInt("created_by"));
               manufacturerModel.setModifiedBy(resultSet.getInt("modified_by"));
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return manufacturerModel;
    }

    @Override
    public ManufacturerModel getManufacturerByName(String manufacturerName) {
       ManufacturerModel manufacturerModel = new ManufacturerModel();
       try{
           String query = "SELECT * FROM manufacturers where name =? AND active = 1";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setString(1, manufacturerName);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               manufacturerModel.setManufacturerId(resultSet.getInt("manufacturer_id"));
               manufacturerModel.setName(resultSet.getString("name"));
               manufacturerModel.setCreatedBy(resultSet.getInt("created_by"));
               manufacturerModel.setModifiedBy(resultSet.getInt("modified_by"));
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return manufacturerModel;
    }
    
}
