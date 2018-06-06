/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.ScreenViewDAO;
import ehealthpro.models.ScreenViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class ScreenViewDAOImpl implements ScreenViewDAO {

    Connection conn = DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;

    @Override
    public ResultSet getScreenViews() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT s.screen_id AS 'Screen ID',s.`name` AS 'Screen View',sc.`name` AS 'Created By',\n" +
            "sm.`name` AS 'Modified By' FROM screen_view s INNER JOIN user_login sc ON s.`created_by` = sc.`user_id`\n" +
            "INNER JOIN user_login sm ON s.`modified_by` =  sm.user_id WHERE s.`active`=1\n" +
            "AND sm.active = 1 AND sc.`active` = 1;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addScreenView(ScreenViewModel screenViewModel) {
        Integer result = 0;
        try {
            String query = "Insert into screen_view(name,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, screenViewModel.getName());
            preparedStatement.setInt(2, screenViewModel.getCreatedBy());
            preparedStatement.setTimestamp(3, screenViewModel.getCreatedDate());
            preparedStatement.setInt(4, screenViewModel.getCreatedBy());
            preparedStatement.setTimestamp(5, screenViewModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateScreenView(ScreenViewModel screenViewModel) {
        Integer result = 0;
        try {
            String query = "update screen_view set name =?, modified_by =?,modified_date=? where screen_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, screenViewModel.getName());
            preparedStatement.setInt(2, screenViewModel.getModifiedBy());
            preparedStatement.setTimestamp(3, screenViewModel.getModifiedDate());
            preparedStatement.setInt(4, screenViewModel.getScreenId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteScreenViewById(ScreenViewModel screenViewModel) {
        Integer result = 0;
        try {
            String query = "update screen_view set active=0 , modified_by = ?,modified_date=? where screen_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, screenViewModel.getModifiedBy());
            preparedStatement.setTimestamp(2, screenViewModel.getModifiedDate());
            preparedStatement.setInt(3, screenViewModel.getScreenId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ScreenViewModel getScreenViewById(Integer screenViewId) {
        ScreenViewModel screenViewModel = new ScreenViewModel();
        try {
            String query = "SELECT s.screen_id AS 'Screen ID',s.`name` AS 'Screen View',sc.`name` AS 'Created By',\n" +
            "sm.`name` AS 'Modified By' FROM screen_view s INNER JOIN user_login sc ON s.`created_by` = sc.`user_id`\n" +
            "INNER JOIN user_login sm ON s.`modified_by` =  sm.user_id WHERE s.screen_id =? AND s.`active`=1\n" +
            "AND sm.active = 1 AND sc.`active` = 1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, screenViewId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                screenViewModel.setScreenId(resultSet.getInt("Screen Id"));
                screenViewModel.setName(resultSet.getString("Screen View"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenViewModel;
    }

    @Override
    public ScreenViewModel getScreenViewByName(String screenViewName) {
        ScreenViewModel screenViewModel = new ScreenViewModel();
        try {
            String query = "SELECT s.screen_id AS 'Screen ID',s.`name` AS 'Screen View',sc.`name` AS 'Created By',\n" +
            "sm.`name` AS 'Modified By' FROM screen_view s INNER JOIN user_login sc ON s.`created_by` = sc.`user_id`\n" +
            "INNER JOIN user_login sm ON s.`modified_by` =  sm.user_id WHERE s.name =? AND s.`active`=1\n" +
            "AND sm.active = 1 AND sc.`active` = 1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, screenViewName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                screenViewModel.setScreenId(resultSet.getInt("Screen ID"));
                screenViewModel.setName(resultSet.getString("Screen View"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenViewModel;
    }
}
