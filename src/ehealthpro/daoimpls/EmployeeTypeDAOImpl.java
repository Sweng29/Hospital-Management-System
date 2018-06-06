/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.EmployeeTypeDAO;
import ehealthpro.models.EmployeeTypeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author sweng
 */
public class EmployeeTypeDAOImpl implements EmployeeTypeDAO {
    Connection conn=DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;
    @Override
    public ResultSet getAllEmployeeTypes() {
       ResultSet resultSet=null;
       try{
           String query="Select e.employee_type_id as 'Employee Type ID', e.name as 'Employee Name',"
                   + " uc.name as 'Created By',um.name as 'Modified By'"
                   + " from employees_type e Inner join user_login uc "
                   + " On e.created_by = uc.user_id "
                   + " Inner join user_login um "
                   + " On e.modified_by = um.user_id where e.active=1";
           preparedStatement=conn.prepareStatement(query);
           resultSet=preparedStatement.executeQuery();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return resultSet;
    }

    @Override
    public Integer addEmployeeType(EmployeeTypeModel employeeTypeModel) {
       Integer result=0;
       try{
           String query="Insert into employees_type(name,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?);";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setString(1, employeeTypeModel.getEmployeeType());
           preparedStatement.setInt(2, 1);
           preparedStatement.setTimestamp(3, employeeTypeModel.getCreatedDate());
           preparedStatement.setInt(4, 1);
           preparedStatement.setTimestamp(5, employeeTypeModel.getModifiedDate());
           result=preparedStatement.executeUpdate();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return result;
    }

    @Override
    public Integer updateEmployeeType(EmployeeTypeModel employeeTypeModel) {
         Integer result=0;
         try{
             String query="update employees_type set name=?,modified_by =?,modified_date=? where employee_type_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setString(1,employeeTypeModel.getEmployeeType());
             preparedStatement.setInt(2,2);
             Timestamp currentTime = new Timestamp(System.currentTimeMillis());
             preparedStatement.setTimestamp(3,currentTime);
             preparedStatement.setInt(4,employeeTypeModel.getEmployeeTypeId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result; 
    }

    @Override
    public Integer deleteEmployeeType(EmployeeTypeModel employeeTypeModel) {
        Integer result=0;
         try{
             String query="update employees_type set active=0 ,modified_by =?,modified_date=? where employee_type_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setInt(1, 2);
             Timestamp currentTime = new Timestamp(System.currentTimeMillis());
             preparedStatement.setTimestamp(2, currentTime);
             preparedStatement.setInt(3, employeeTypeModel.getEmployeeTypeId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result; 
    }

    @Override
    public EmployeeTypeModel getEmployeeTypeById(Integer employeeTypeId) {
       EmployeeTypeModel employeeTypeModel= new EmployeeTypeModel();
       try{
           String query = "SELECT * FROM employees_type where employee_type_id =? AND active = 1";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setInt(1, employeeTypeId);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               employeeTypeModel.setEmployeeTypeId(resultSet.getInt("employee_type_id"));
               employeeTypeModel.setEmployeeType(resultSet.getString("name"));
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }    
       return employeeTypeModel;
    }

    @Override
    public EmployeeTypeModel getEmployeeTypeByName(String name) {
       EmployeeTypeModel employeeTypeModel= new EmployeeTypeModel();
       try{
           String query = "SELECT * FROM employees_type where name =? AND active = 1";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setString(1, name);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               employeeTypeModel.setEmployeeTypeId(resultSet.getInt("employee_type_id"));
               employeeTypeModel.setEmployeeType(resultSet.getString("name"));
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }    
       return employeeTypeModel;
    }
    
}
