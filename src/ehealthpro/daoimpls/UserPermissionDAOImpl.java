/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.UserPermissionDAO;
import ehealthpro.models.PermissionModel;
import ehealthpro.models.UserPermissionModel;
import ehealthpro.models.UserTypeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class UserPermissionDAOImpl implements UserPermissionDAO{

    
    Connection conn = DBConnection.getConnected();
    Statement statement = null;
    PreparedStatement preparedStatement;

    
    @Override
    public ResultSet getUserPermissions() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT up.`user_permission_id` AS 'User Permission ID',\n" +
            "ut.`user_type` AS 'User Type',p.`permission` AS 'Permission',\n" +
            "upc.`name` AS 'Created By',upm.`name` AS 'Modified By'\n" +
            "FROM user_permissions up \n" +
            "INNER JOIN user_type ut ON up.`user_type_id` = ut.`user_type_id`\n" +
            "INNER JOIN permissions p ON up.`permission_id` = p.`permission_id`\n" +
            "INNER JOIN user_login upc ON  up.`created_by` = upc.`user_id`\n" +
            "INNER JOIN user_login upm ON up.`modified_by` = upm.`user_id`\n" +
            "WHERE up.`active`=1 AND ut.`active` = 1 AND p.`active`=1\n" +
            "AND upc.`active`=1 AND upm.`active` = 1;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;    
    }

    @Override
    public Integer addUserPermission(UserPermissionModel userPermissionModel) {
        Integer result = 0;
        try {
            String query = "Insert into user_permissions(user_type_id,permission_id,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, userPermissionModel.getUserTypeModel().getUserTypeId());
            preparedStatement.setInt(2, userPermissionModel.getPermissionModel().getPermissionId());
            preparedStatement.setInt(3, userPermissionModel.getCreatedBy());
            preparedStatement.setTimestamp(4, userPermissionModel.getCreatedDate());
            preparedStatement.setInt(5, userPermissionModel.getModifiedBy());
            preparedStatement.setTimestamp(6, userPermissionModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateUserPermission(UserPermissionModel userPermissionModel) {
        Integer result = 0;
        try {
            String query = "update user_permissions set user_type_id =? ,permission_id =? , modified_by =?,modified_date=? where user_permission_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, userPermissionModel.getUserTypeModel().getUserTypeId());
            preparedStatement.setInt(2, userPermissionModel.getPermissionModel().getPermissionId());
            preparedStatement.setInt(3, userPermissionModel.getModifiedBy());
            preparedStatement.setTimestamp(4, userPermissionModel.getModifiedDate());
            preparedStatement.setInt(5, userPermissionModel.getUserPermissionId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteUserPermissionById(UserPermissionModel userPermissionModel) {
        Integer result = 0;
        try {
            String query = "delete from user_permissions WHERE permission_id=? AND user_type_id=? AND active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, userPermissionModel.getPermissionModel().getPermissionId());
            preparedStatement.setInt(2, userPermissionModel.getUserTypeModel().getUserTypeId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public UserPermissionModel getUserPermissionById(Integer userPermissionId) {
        UserPermissionModel userPermissionModel = new UserPermissionModel();
        try {
            String query = "SELECT up.`user_permission_id` AS 'User Permission ID',\n" +
            "ut.`user_type` AS 'User Type',p.`permission` AS 'Permission',\n" +
            "upc.`name` AS 'Created By',upm.`name` AS 'Modified By'\n" +
            "FROM user_permissions up \n" +
            "INNER JOIN user_type ut ON up.`user_type_id` = ut.`user_type_id`\n" +
            "INNER JOIN permissions p ON up.`permssion_id` = p.`permission_id`\n" +
            "INNER JOIN user_login upc ON  up.`created_by` = upc.`user_id`\n" +
            "INNER JOIN user_login upm ON up.`modified_by` = upm.`user_id`\n" +
            "WHERE up.user_permission_id = ? AND up.`active`=1 AND ut.`active` = 1 AND p.`active`=1\n" +
            "AND upc.`active`=1 AND upm.`active` = 1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, userPermissionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userPermissionModel.setUserPermissionId(resultSet.getInt("User Permission ID"));
                UserTypeModel userTypeModel = new UserTypeModel();
                userTypeModel.setUserType(resultSet.getString("User Type"));
                userPermissionModel.setUserTypeModel(userTypeModel);
                PermissionModel permissionModel = new PermissionModel();
                permissionModel.setPermission(resultSet.getString("Permission"));
                userPermissionModel.setPermissionModel(permissionModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userPermissionModel;
    }

    @Override
    public UserPermissionModel getUserPermissionByName(String userPermissionName) {
        UserPermissionModel userPermissionModel = new UserPermissionModel();
        try {
            String query = "SELECT up.`user_permission_id` AS 'User Permission ID',\n" +
            "ut.`user_type` AS 'User Type',p.`permission` AS 'Permission',\n" +
            "upc.`name` AS 'Created By',upm.`name` AS 'Modified By'\n" +
            "FROM user_permissions up \n" +
            "INNER JOIN user_type ut ON up.`user_type_id` = ut.`user_type_id`\n" +
            "INNER JOIN permissions p ON up.`permssion_id` = p.`permission_id`\n" +
            "INNER JOIN user_login upc ON  up.`created_by` = upc.`user_id`\n" +
            "INNER JOIN user_login upm ON up.`modified_by` = upm.`user_id`\n" +
            "WHERE p.permission = ? AND up.`active`=1 AND ut.`active` = 1 AND p.`active`=1\n" +
            "AND upc.`active`=1 AND upm.`active` = 1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userPermissionName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userPermissionModel.setUserPermissionId(resultSet.getInt("User Permission ID"));
                UserTypeModel userTypeModel = new UserTypeModel();
                userTypeModel.setUserType(resultSet.getString("User Type"));
                userPermissionModel.setUserTypeModel(userTypeModel);
                PermissionModel permissionModel = new PermissionModel();
                permissionModel.setPermission(resultSet.getString("Permission"));
                userPermissionModel.setPermissionModel(permissionModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userPermissionModel;
    }

    @Override
    public UserPermissionModel getUserPermissionRecord(Integer userPermissionId) {
        UserPermissionModel userPermissionModel = new UserPermissionModel();
        try {
            String query = "SELECT * from user_permissions where user_permission_id = ? and active =1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, userPermissionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userPermissionModel.setUserPermissionId(resultSet.getInt("user_permission_id"));
                UserTypeModel userTypeModel = new UserTypeModel();
                userTypeModel.setUserTypeId(resultSet.getInt("user_type_id"));
                userPermissionModel.setUserTypeModel(userTypeModel);
                PermissionModel permissionModel = new PermissionModel();
                permissionModel.setPermissionId(resultSet.getInt("permission_id"));
                userPermissionModel.setPermissionModel(permissionModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userPermissionModel;        
    }

    @Override
    public ResultSet getAssignedPermissions(String userType) {
      ResultSet resultSet = null;
        try {
            String query = "SELECT p.`permission` as 'Permission' FROM user_permissions up\n" +
            "INNER JOIN permissions p ON up.`permission_id` = p.`permission_id`\n" +
            "INNER JOIN user_type ut ON up.`user_type_id` = ut.`user_type_id`\n" +
            "WHERE ut.`user_type`=? AND up.active =1 AND p.`active`=1 AND ut.`active`=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userType);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;  
    }

    @Override
    public ResultSet getUnAssignedPermissions(String userType) {
      ResultSet resultSet = null;
        try {
            String query = "SELECT permission FROM permissions \n" +
            "WHERE permission_id NOT IN (\n" +
            "SELECT up.`permission_id` FROM user_permissions up\n" +
            "INNER JOIN user_type ut ON up.`user_type_id`=ut.`user_type_id`\n" +
            "INNER JOIN permissions p ON up.`permission_id` = p.`permission_id` WHERE ut.`user_type`=? AND \n" +
            "up.`active`=1 AND p.`active`=1 AND ut.`active`=1) and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userType);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;  
    }
    
}
