/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.BloodGroupDAO;
import ehealthpro.models.BloodGroupModel;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author sweng
 */
public class BloodGroupDAOImpl implements BloodGroupDAO {

    Connection conn = DBConnection.getConnected();

    @Override
    public ResultSet getAllBloodGroups() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT b.blood_id as 'Blood ID',b.groups as 'Blood Group',c.name as 'Created By',"
                    + " m.name as 'Modified By' from blood_groups b "
                    + " inner join user_login c On b.created_by = c.user_id "
                    + " inner join user_login m on b.modified_by = m.user_id where b.active = 1";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addBloodGroup(BloodGroupModel bloodGroupModel) {
        Integer result = 0;
        try {
            String query = "INSERT into blood_groups(groups,created_by,created_date,modified_by,modified_date) values (?,?,?,?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, bloodGroupModel.getBloodGroup());
            preparedStatement.setInt(2, 2); 
            preparedStatement.setTimestamp(3, bloodGroupModel.getCreatedDate());
            preparedStatement.setInt(4, 2);
            preparedStatement.setTimestamp(5, bloodGroupModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateBloodGroup(BloodGroupModel bloodGroupModel) {
        Integer result = 0;
        try {
            String query = "update blood_groups set groups = ?,modified_by =?,modified_date =? where blood_id =? AND active = 1";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, bloodGroupModel.getBloodGroup());
            preparedStatement.setInt(2, bloodGroupModel.getModifiedBy());
            preparedStatement.setTimestamp(3, bloodGroupModel.getModifiedDate());
            preparedStatement.setInt(4, bloodGroupModel.getBloodGroupId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
               e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteBloodGroup(BloodGroupModel bloodGroupModel) {
        Integer result = 0;
        try {
            String query = "update blood_groups set active=0,modified_by =?,modified_date =? where blood_id =?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, bloodGroupModel.getModifiedBy());
            preparedStatement.setTimestamp(2, bloodGroupModel.getModifiedDate());
            preparedStatement.setInt(3, bloodGroupModel.getBloodGroupId());
            result = preparedStatement.executeUpdate();
            
        } catch (Exception e) {
               e.printStackTrace();
        }
        return result;
    }

    @Override
    public BloodGroupModel getBloodGroupById(Integer bloodGroupId) {
        BloodGroupModel bloodGroupModel = new BloodGroupModel();
        try{
            String query = "SELECT * FROM blood_groups where blood_id = ? AND active = 1";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, bloodGroupId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                bloodGroupModel.setBloodGroupId(resultSet.getInt("blood_id"));
                bloodGroupModel.setBloodGroup(resultSet.getString("groups"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return bloodGroupModel;
    }

    @Override
    public BloodGroupModel getBloodGroupByName(String groupName) {
        BloodGroupModel bloodGroupModel = new BloodGroupModel();
        try{
            String query = "SELECT * FROM blood_groups where groups = ? AND active = 1";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, groupName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                bloodGroupModel.setBloodGroupId(resultSet.getInt("blood_id"));
                bloodGroupModel.setBloodGroup(resultSet.getString("groups"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return bloodGroupModel;
    
    }

}
