/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import ehealthpro.dao.PermissionDAO;
import ehealthpro.models.PermissionModel;
import ehealthpro.connection.DBConnection;
import ehealthpro.models.ScreenViewModel;

/**
 *
 * @author sweng
 */
public class PermissionDAOImpl implements PermissionDAO{
    
    Connection conn = DBConnection.getConnected();
    
    @Override
    public ResultSet getAllPermissions() {
        ResultSet resultSet = null;
        try{
            String query = "SELECT p.`permission_id` AS 'Permission ID',sv.`name` AS 'Screen View',\n" +
            "p.`permission` AS 'Permissions',uc.`name` AS 'Created By',\n" +
            "um.`name` AS 'Modified By'  FROM permissions p \n" +
            "INNER JOIN screen_view sv ON p.`screen_id` = sv.`screen_id`\n" +
            "INNER JOIN user_login uc ON p.`created_by` = uc.`user_id`\n" +
            "INNER JOIN user_login um ON p.`modified_by` = um.`user_id`\n" +
            "WHERE p.`active` = 1 AND sv.`active`=1 AND uc.`active`=1 AND um.`active`=1;";
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return resultSet;    
    }

    @Override
    public Integer addPermission(PermissionModel permissionModel) {
        Integer result = 0;
        try{
            String query = "INSERT into permissions (screen_id,permission,created_by,created_date,modified_by,modified_date) VALUES (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, permissionModel.getScreenViewModel().getScreenId());
            preparedStatement.setString(2, permissionModel.getPermission());
            preparedStatement.setInt(3, permissionModel.getCreatedBy());
            preparedStatement.setTimestamp(4, permissionModel.getCreatedDate());
            preparedStatement.setInt(5, permissionModel.getModifiedBy());
            preparedStatement.setTimestamp(6, permissionModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
                    
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deletePermissionById(PermissionModel permissionModel) {
    Integer result = 0;
        try{
            String query = "update permissions set active = 0 ,modified_by = ?,modified_date=?  where permission_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,permissionModel.getModifiedBy());
            preparedStatement.setTimestamp(2, permissionModel.getModifiedDate());
            preparedStatement.setInt(3,permissionModel.getPermissionId());
            result = preparedStatement.executeUpdate();
                    
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updatePermission(PermissionModel permissionModel) {
        Integer result = 0;
        try{
            String query = "update permissions set screen_id=?,permission = ?,modified_by=?,modified_date=? where permission_id = ? AND active = 1";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, permissionModel.getScreenViewModel().getScreenId());
            preparedStatement.setString(2, permissionModel.getPermission());
            preparedStatement.setInt(3, permissionModel.getModifiedBy());
            preparedStatement.setTimestamp(4, permissionModel.getModifiedDate());
            preparedStatement.setInt(5, permissionModel.getPermissionId());
            result = preparedStatement.executeUpdate();
                    
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public PermissionModel getPermissionById(Integer permissionId) {
       PermissionModel permissionModel = new PermissionModel();
        try{
            String query = "SELECT p.`permission_id` AS 'Permission ID',sv.`name` AS 'Screen View',\n" +
            "p.`permission` AS 'Permissions',uc.`name` AS 'Created By',\n" +
            "um.`name` AS 'Modified By'  FROM permissions p \n" +
            "INNER JOIN screen_view sv ON p.`screen_id` = sv.`screen_id`\n" +
            "INNER JOIN user_login uc ON p.`created_by` = uc.`user_id`\n" +
            "INNER JOIN user_login um ON p.`modified_by` = um.`user_id`\n" +
            "WHERE p.`permission_id` = ? AND p.`active` = 1 AND sv.`active`=1 AND uc.`active`=1 AND um.`active`=1;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, permissionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
               permissionModel.setPermissionId(resultSet.getInt("Permission ID"));
               ScreenViewModel screenViewModel = new ScreenViewModel();
               screenViewModel.setName(resultSet.getString("Screen View"));
               permissionModel.setScreenViewModel(screenViewModel);
               permissionModel.setPermission(resultSet.getString("Permissions"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return permissionModel; 
    }

    @Override
    public PermissionModel getPermissionByName(String permissionName) {
       PermissionModel permissionModel = new PermissionModel();
        try{
            String query = "SELECT p.`permission_id` AS 'Permission ID',sv.`name` AS 'Screen View',\n" +
            "p.`permission` AS 'Permissions',uc.`name` AS 'Created By',\n" +
            "um.`name` AS 'Modified By'  FROM permissions p \n" +
            "INNER JOIN screen_view sv ON p.`screen_id` = sv.`screen_id`\n" +
            "INNER JOIN user_login uc ON p.`created_by` = uc.`user_id`\n" +
            "INNER JOIN user_login um ON p.`modified_by` = um.`user_id`\n" +
            "WHERE p.`permission` = ? AND p.`active` = 1 AND sv.`active`=1 AND uc.`active`=1 AND um.`active`=1;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, permissionName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
               permissionModel.setPermissionId(resultSet.getInt("Permission ID"));
               ScreenViewModel screenViewModel = new ScreenViewModel();
               screenViewModel.setName(resultSet.getString("Screen View"));
               permissionModel.setScreenViewModel(screenViewModel);
               permissionModel.setPermission(resultSet.getString("Permissions"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return permissionModel; 
    }
}
