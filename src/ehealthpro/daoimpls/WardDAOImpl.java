/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.WardDAO;
import ehealthpro.models.WardModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class WardDAOImpl implements WardDAO {

    Connection conn = DBConnection.getConnected();
    Statement statement;
    PreparedStatement preparedStatement;

    @Override
    public ResultSet getAllWards() {
        ResultSet resultSet = null;
        try {
            String query = "Select w.ward_id as 'Ward ID',w.name as 'Ward Name',wc.name as 'Created By' ,w.created_date as 'Created Date'"
                    + " , wm.name as 'Modified By' ,w.modified_date as 'Modified Date' from ward w"
                    + " Inner join user_login wc On w.created_by = wc.user_id "
                    + " Inner join user_login wm On w.modified_by = wm.user_id where w.active=1";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addWard(WardModel wardModel) {
        Integer result = 0;
        try {
            String query = "Insert into ward(name,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, wardModel.getName());
            preparedStatement.setInt(2, wardModel.getCreatedBy());
            preparedStatement.setTimestamp(3, wardModel.getCreatedDate());
            preparedStatement.setInt(4, wardModel.getModifiedBy());
            preparedStatement.setTimestamp(5, wardModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteWard(WardModel wardModel) {

        Integer result = 0;
        try {
            String query = "update ward set active=0 , modified_by = ? where ward_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, wardModel.getModifiedBy());
            preparedStatement.setInt(2, wardModel.getWardId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public Integer updateWard(WardModel wardModel) {
        Integer result = 0;
        try {
            String query = "update ward set name=?,modified_by =?,modified_date=? where ward_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, wardModel.getName());
            preparedStatement.setInt(2, wardModel.getModifiedBy());
            preparedStatement.setTimestamp(3, wardModel.getModifiedDate());
            preparedStatement.setInt(4, wardModel.getWardId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public WardModel getWardById(Integer wardId) {
        WardModel wardModel = new WardModel();
        try {
            String query = "SELECT * FROM ward where ward_id =? AND active = 1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, wardId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                wardModel.setWardId(resultSet.getInt("ward_id"));
                wardModel.setName(resultSet.getString("name"));
                wardModel.setCreatedBy(resultSet.getInt("created_by"));
                wardModel.setModifiedBy(resultSet.getInt("modified_by"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wardModel;
    }

    @Override
    public WardModel getWardByName(String wardName) {
        WardModel wardModel = new WardModel();
        try {
            String query = "SELECT * FROM ward where name =? AND active = 1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, wardName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                wardModel.setWardId(resultSet.getInt("ward_id"));
                wardModel.setName(resultSet.getString("name"));
                wardModel.setCreatedBy(resultSet.getInt("created_by"));
                wardModel.setModifiedBy(resultSet.getInt("modified_by"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wardModel;
    }

}
