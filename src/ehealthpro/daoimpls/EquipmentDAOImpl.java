/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.EquipmentDAO;
import ehealthpro.models.EquipmentModel;
import ehealthpro.models.EquipmentTypeModel;
import ehealthpro.models.ManufacturerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 *
 * @author sweng
 */
public class EquipmentDAOImpl implements EquipmentDAO{

    Connection conn=DBConnection.getConnected();
    PreparedStatement preparedStatement;
    @Override
    public ResultSet getAllEquipment() {
        ResultSet resultSet = null;
        try{
            String query="Select e.equipment_id as 'Equipment ID', e.name as 'Equipment Name',"
                   + " eq.name as 'Equipment Type',m.name as 'Manufacturer' , e.purchase_date as 'Purchase Date',"
                    + " e.warranty as 'Warranty' ,e.quaintity as 'Quaintity' ,"
                    + "uc.name as 'Created By',um.name as 'Modified By'"
                   + " from equipment e Inner join user_login uc "
                   + " On e.created_by = uc.user_id "
                   + " Inner join user_login um "
                   + " On e.modified_by = um.user_id "
                    + " inner join equipment_type eq on e.equipment_type_id = eq.equipment_type_id "
                    + " inner join manufacturers m On e.manufacturer_id = m.manufacturer_id where e.active=1";
           preparedStatement=conn.prepareStatement(query);
           resultSet=preparedStatement.executeQuery();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addEquipment(EquipmentModel equipmentModel) {
    Integer result=0;
       try{
           String query="Insert into equipment (equipment_type_id,manufacturer_id,name,purchase_date,warranty,quaintity,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,?,?,?,?);";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setInt(1, equipmentModel.getEquipmentTypeModel().getEquipmentTypeId());
           preparedStatement.setInt(2, equipmentModel.getManufacturerModel().getManufacturerId());
           preparedStatement.setString(3, equipmentModel.getName());
           preparedStatement.setTimestamp(4, equipmentModel.getPurchaseDate());
           preparedStatement.setString(5, equipmentModel.getWarranty());
           preparedStatement.setInt(6, equipmentModel.getQuaintity());
           preparedStatement.setInt(7, equipmentModel.getCreatedBy());
           preparedStatement.setTimestamp(8, equipmentModel.getCreatedDate());
           preparedStatement.setInt(9, equipmentModel.getModifiedBy());
           preparedStatement.setTimestamp(10, equipmentModel.getModifiedDate());
           result=preparedStatement.executeUpdate();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return result;
    }

    @Override
    public Integer updateEquipment(EquipmentModel equipmentModel) {
     Integer result=0;
         try{
             String query="update equipment set equipment_type_id=? ,manufacturer_id=?,name=?,purchase_date=?,warranty=?,quaintity=?,modified_by =?,modified_date=? where equipment_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setInt(1,equipmentModel.getEquipmentTypeModel().getEquipmentTypeId());
             preparedStatement.setInt(2,equipmentModel.getManufacturerModel().getManufacturerId());
             preparedStatement.setString(3, equipmentModel.getName());
             preparedStatement.setTimestamp(4, equipmentModel.getPurchaseDate());
             preparedStatement.setString(5, equipmentModel.getWarranty());
             preparedStatement.setInt(6, equipmentModel.getQuaintity());
             preparedStatement.setInt(7, equipmentModel.getModifiedBy());
             preparedStatement.setTimestamp(8,equipmentModel.getModifiedDate());
             preparedStatement.setInt(9,equipmentModel.getEquipmentId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result;
    }

    @Override
    public Integer deleteEquipment(EquipmentModel equipmentModel) {
    Integer result=0;
         try{
             String query="update equipment set active=0 ,modified_by =?,modified_date=? where equipment_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setInt(1, equipmentModel.getModifiedBy());
             preparedStatement.setTimestamp(2, equipmentModel.getModifiedDate());
             preparedStatement.setInt(3, equipmentModel.getEquipmentId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result;
    }

    @Override
    public EquipmentModel getEquipmentById(Integer equipmentId) {
        EquipmentModel equipmentModel= new EquipmentModel();
       try{
           String query = "SELECT e.`equipment_id`,e.`name`,e.quaintity,e.`purchase_date`,e.`warranty`,m.`name` AS 'Manufacturer',eq.`name` AS 'Equipment Type' \n" +
"FROM equipment e INNER JOIN equipment_type eq ON e.equipment_type_id = eq.equipment_type_id\n" +
"INNER JOIN manufacturers m ON  e.manufacturer_id = m.manufacturer_id WHERE e.equipment_id = ? AND e.active = 1";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setInt(1, equipmentId);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               EquipmentTypeModel equipmentTypeModel = new EquipmentTypeModel();
               ManufacturerModel manufacturerModel = new ManufacturerModel();
               equipmentModel.setEquipmentId(resultSet.getInt("equipment_id"));
               equipmentTypeModel.setName(resultSet.getString("Equipment Type"));
               equipmentModel.setEquipmentTypeModel(equipmentTypeModel);
               manufacturerModel.setName(resultSet.getString("Manufacturer"));
               equipmentModel.setManufacturerModel(manufacturerModel);
               equipmentModel.setName(resultSet.getString("name"));
               equipmentModel.setPurchaseDate(resultSet.getTimestamp("purchase_date"));
               equipmentModel.setQuaintity(resultSet.getInt("quaintity"));
               equipmentModel.setWarranty(resultSet.getString("warranty"));
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }    
       return equipmentModel;
    }
    
}
