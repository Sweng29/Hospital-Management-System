/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.EquipmentPlaceDAO;
import ehealthpro.models.EquipmentPlaceModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class EquipmentPlaceDAOImpl implements EquipmentPlaceDAO{
    Connection conn=DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;
    
    @Override
    public ResultSet getAllEquipmentPlace() {
       ResultSet resultSet=null;
       try{
           String query="Select * from equipment_place where active=1";
           preparedStatement=conn.prepareStatement(query);
           resultSet=preparedStatement.executeQuery();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return resultSet; 
    }

    @Override
    public Integer addEquipmentPlace(EquipmentPlaceModel equipmentPlaceModel) {
        Integer result=0;
       try{
           String query="Insert into equipment_place(dept_name,created_by,modified_by) values(?,?,?);";
           preparedStatement.setString(1, equipmentPlaceModel.getDepartmentName());
           preparedStatement.setInt(2, equipmentPlaceModel.getCreatedBy());
           preparedStatement.setInt(3, equipmentPlaceModel.getModifiedBy());
           preparedStatement=conn.prepareStatement(query);
           result=preparedStatement.executeUpdate();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return result;
    }

    @Override
    public Integer updateEquipmentPlace(EquipmentPlaceModel equipmentPlaceModel) {
       Integer result=0;
         try{
             String query="update equipment_place set dept_name=?,modified_by =? where equipment_place_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setString(1,equipmentPlaceModel.getDepartmentName());
             preparedStatement.setInt(2, equipmentPlaceModel.getModifiedBy());
             preparedStatement.setInt(3, equipmentPlaceModel.getEquipmentPlacedDepartmentId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result; 
    }

    @Override
    public Integer deleteEquipmentPlaceById(EquipmentPlaceModel equipmentPlaceModel) {
        Integer result=0;
         try{
             String query="update equipment_place set active=0,modified_by where equipment_place_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setInt(1,equipmentPlaceModel.getModifiedBy());
             preparedStatement.setInt(2,equipmentPlaceModel.getEquipmentPlacedDepartmentId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result;
    }

    @Override
    public EquipmentPlaceModel getEquipmentPlaceById(Integer equipmentPlaceId) {
        EquipmentPlaceModel equipmentPlaceModel= new EquipmentPlaceModel();
       try{
           String query = "SELECT * FROM equipment_place where equipment_place_id =? AND active = 1";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setInt(1, equipmentPlaceId);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               equipmentPlaceModel.setEquipmentPlacedDepartmentId(resultSet.getInt("equipment_place_id"));
               equipmentPlaceModel.setDepartmentName(resultSet.getString("dept_name"));
               equipmentPlaceModel.setCreatedBy(resultSet.getInt("created_by"));
               equipmentPlaceModel.setModifiedBy(resultSet.getInt("modified_by"));
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return equipmentPlaceModel;
    }
    
}
