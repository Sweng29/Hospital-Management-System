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
import ehealthpro.connection.DBConnection;
import ehealthpro.dao.UserTypeDAO;
import ehealthpro.models.UserTypeModel;

/**
 *
 * @author sweng
 */
public class UserTypeDAOImpl implements UserTypeDAO {

    Connection conn = DBConnection.getConnected();

    @Override
    public ResultSet getAllUserTypes() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT u.user_type_id as 'User Type ID',u.user_type as 'User Type',uc.name as 'Created By',um.name as 'Modified By' "
                    + " from user_type u inner join user_login uc"
                    + " On u.created_by = uc.user_id "
                    + " inner join user_login um "
                    + " on u.modified_by = um.user_id where u.active = 1;";
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addUserType(UserTypeModel userTypeModel) {
        Integer result = 0;
        try {
            String query = "INSERT into user_type (user_type,created_by,created_date,modified_by,modified_date) VALUES (?,?,?,?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userTypeModel.getUserType());
            preparedStatement.setInt(2, userTypeModel.getCreatedBy());
            preparedStatement.setTimestamp(3, userTypeModel.getCreatedDate());
            preparedStatement.setInt(4, userTypeModel.getModifiedBy());
            preparedStatement.setTimestamp(5, userTypeModel.getModifiedDate());
            result = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteUserType(UserTypeModel userTypeModel) {
        Integer result = 0;
        try {
            String query = "update user_type set active = 0 ,modified_by = ? ,modified_date=? where user_type_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, userTypeModel.getModifiedBy());
            preparedStatement.setTimestamp(2, userTypeModel.getModifiedDate());
            preparedStatement.setInt(3, userTypeModel.getUserTypeId());
            result = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateUserType(UserTypeModel userTypeModel) {
        Integer result = 0;
        try {
            String query = "update user_type set user_type = ?,modified_by=?,modified_date=? where user_type_id = ? AND active = 1";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userTypeModel.getUserType());
            preparedStatement.setInt(2, userTypeModel.getModifiedBy());
            preparedStatement.setTimestamp(3, userTypeModel.getModifiedDate());
            preparedStatement.setInt(4, userTypeModel.getUserTypeId());
            result = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public UserTypeModel getUserTypeById(Integer userTypeId) {
        UserTypeModel userTypeModel = new UserTypeModel();
        try {
            String query = "SELECT user_type_id AS 'User Type ID' ,user_type AS 'User Type'\n" +
            "FROM user_type WHERE user_type_id = ? AND active = 1;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, userTypeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userTypeModel.setUserTypeId(resultSet.getInt("User Type ID"));
                userTypeModel.setUserType(resultSet.getString("User Type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userTypeModel;
    }

    @Override
    public UserTypeModel getUserTypeByName(String userTypeName) {
        UserTypeModel userTypeModel = new UserTypeModel();
        try {
            String query = "SELECT user_type_id AS 'User Type ID' ,user_type AS 'User Type'\n" +
            "FROM user_type WHERE user_type = ? AND active = 1;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userTypeName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userTypeModel.setUserTypeId(resultSet.getInt("User Type ID"));
                userTypeModel.setUserType(resultSet.getString("User Type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userTypeModel;
    }

}
