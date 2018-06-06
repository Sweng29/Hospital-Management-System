/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.UserLoginDAO;
import ehealthpro.models.EmployeeModel;
import ehealthpro.models.UserLoginModel;
import ehealthpro.models.UserTypeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class UserLoginDAOImpl implements UserLoginDAO{

    
    Connection conn = DBConnection.getConnected();
    Statement statement = null;
    PreparedStatement preparedStatement;

    
    @Override
    public ResultSet getAllUsers() {
         ResultSet resultSet = null;
        try {
            String query = "SELECT u.`user_id` AS 'User ID',u.`name` AS 'User Name',u.`password` AS 'Password',\n" +
            "e.`name` AS 'Employee Name',ut.`user_type` AS 'User Type'\n" +
            "FROM user_login u INNER JOIN employees e ON u.`employee_id` = e.`employee_id`\n" +
            "INNER JOIN user_type ut ON u.`user_type_id` = ut.`user_type_id`\n" +
            "WHERE u.`active`=1 AND ut.`active`=1 AND e.`active`=1;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addUser(UserLoginModel userLoginModel) {
        Integer result = 0;
        try {
            String query = "Insert into user_login(name,password,employee_id,user_type_id,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userLoginModel.getName());
            preparedStatement.setString(2, userLoginModel.getPassword());
            preparedStatement.setInt(3, userLoginModel.getEmployeeModel().getEmployeeId());
            preparedStatement.setInt(4, userLoginModel.getUserTypeModel().getUserTypeId());
            preparedStatement.setInt(5, userLoginModel.getCreatedBy());
            preparedStatement.setTimestamp(6, userLoginModel.getCreatedDate());
            preparedStatement.setInt(7, userLoginModel.getModifiedBy());
            preparedStatement.setTimestamp(8, userLoginModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateUser(UserLoginModel userLoginModel) {
        Integer result = 0;
        try {
            String query = "update user_login set name =?,password=?,employee_id=?,user_type_id=?,modified_by =?,modified_date=? where user_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userLoginModel.getName());
            preparedStatement.setString(2, userLoginModel.getPassword());
            preparedStatement.setInt(3, userLoginModel.getEmployeeModel().getEmployeeId());
            preparedStatement.setInt(4, userLoginModel.getUserTypeModel().getUserTypeId());
            preparedStatement.setInt(5, userLoginModel.getModifiedBy());
            preparedStatement.setTimestamp(6, userLoginModel.getModifiedDate());
            preparedStatement.setInt(7, userLoginModel.getUserId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteUserById(UserLoginModel userLoginModel) {
        Integer result = 0;
        try {
            String query = "update user_login set active=0 , modified_by = ?,modified_date=? where user_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, userLoginModel.getModifiedBy());
            preparedStatement.setTimestamp(2, userLoginModel.getModifiedDate());
            preparedStatement.setInt(3, userLoginModel.getUserId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public UserLoginModel getUserById(Integer userId) {
        UserLoginModel userLoginModel = new UserLoginModel();
        try {
            
            String query = "SELECT u.`user_id` AS 'User ID',u.`name` AS 'User Name',u.`password` AS 'Password',\n" +
            "e.`name` AS 'Employee Name',ut.`user_type` AS 'User Type'\n" +
            "FROM user_login u INNER JOIN employees e ON u.`employee_id` = e.`employee_id`\n" +
            "INNER JOIN user_type ut ON u.`user_type_id` = ut.`user_type_id`\n" +
            "WHERE u.`user_id`=? AND u.`active`=1 AND ut.`active`=1 AND e.`active`=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userLoginModel.setUserId(resultSet.getInt("User ID"));
                userLoginModel.setName(resultSet.getString("User Name"));
                userLoginModel.setPassword(resultSet.getString("Password"));
                EmployeeModel employeeModel = new EmployeeModel();
                employeeModel.setName(resultSet.getString("Employee Name"));
                userLoginModel.setEmployeeModel(employeeModel);
                UserTypeModel userTypeModel = new UserTypeModel();
                userTypeModel.setUserType(resultSet.getString("User Type"));
                userLoginModel.setUserTypeModel(userTypeModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLoginModel;
    }

    @Override
    public UserLoginModel getUserLoggedIn(UserLoginModel userLoginModel) {
        UserLoginModel loginModel = null;
        try {
            String query = "SELECT u.`user_id` AS 'User ID',u.`name` AS 'User Name',u.`password` AS 'Password',\n" +
            "e.`name` AS 'Employee Name',ut.`user_type` AS 'User Type'\n" +
            "FROM user_login u INNER JOIN employees e ON u.`employee_id` = e.`employee_id`\n" +
            "INNER JOIN user_type ut ON u.`user_type_id` = ut.`user_type_id`\n" +
            "WHERE u.`name` =? AND u.`password`=? AND u.`active`=1 AND ut.`active`=1 AND e.`active`=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userLoginModel.getName());
            preparedStatement.setString(2, userLoginModel.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                loginModel = new UserLoginModel();
                loginModel.setUserId(resultSet.getInt("User ID"));
                loginModel.setName(resultSet.getString("User Name"));
                loginModel.setPassword(resultSet.getString("Password"));
                EmployeeModel employeeModel = new EmployeeModel();
                employeeModel.setName(resultSet.getString("Employee Name"));
                loginModel.setEmployeeModel(employeeModel);
                UserTypeModel userTypeModel = new UserTypeModel();
                userTypeModel.setUserType(resultSet.getString("User Type"));
                loginModel.setUserTypeModel(userTypeModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginModel;        
    }    

    @Override
    public boolean checkUserNameUniqueness(String name) {
        boolean check = false;
        try {
            String query = "SELECT `name` AS 'User Name' from user_login where name=? and active = 1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
