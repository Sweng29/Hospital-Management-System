/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.SpecializationDAO;
import ehealthpro.models.ShiftingModel;
import ehealthpro.models.SpecializationModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author sweng
 */
public class SpecializationDAOImpl implements SpecializationDAO {

    Connection conn = DBConnection.getConnected();
    Statement statement = null;
    PreparedStatement preparedStatement;
    String query;
    Timestamp currentDate = new Timestamp(System.currentTimeMillis());
    @Override
    public ResultSet getAllSpecializations() {
        ResultSet resultSet = null;
        try {
            query = "SELECT s.specialization_id as 'Specialization ID',s.name as 'Specialization',sc.created_by"
                    + " as 'Created By',s.created_date as 'Created Date',sm.name as 'Modified By'"
                    + " ,sm.modified_date as 'Modified Date' FROM specializations s "
                    + " Inner join user_login sc On s.created_by = sc.user_id "
                    + " Inner Join user_login sm On s.modified_by = sm.user_id where s.active = 1;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addSpecialization(SpecializationModel specializationModel) {
        Integer result = 0;
        // DATE values are still remaining.
        try {
            query = "INSERT into specializations (name,created_by,created_date,modified_by,modified_date) values (?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, specializationModel.getName());
            preparedStatement.setInt(2, 1);
            preparedStatement.setTimestamp(3, currentDate);
            preparedStatement.setInt(4, 1);
            preparedStatement.setTimestamp(5,currentDate);
            //preparedStatement.setInt(2, specializationModel.getCreatedBy());
            //preparedStatement.setInt(5, specializationModel.getModifiedBy());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateSpecialization(SpecializationModel specializationModel) {
        Integer result = 0;
        try {
            
            query = "update specializations set name = ?,modified_by=?,modified_date=? where specialization_id = ? AND active = 1 ";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, specializationModel.getName());
            preparedStatement.setInt(2, 2);
            preparedStatement.setTimestamp(3, currentDate);
            preparedStatement.setInt(4, specializationModel.getSpecializationId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteSpecialization(SpecializationModel specializationModel) {
        Integer result = 0;
        try {
            query = "update specializations set active = 0 ,modified_by = ?,modified_date=? where specialization_id = ? AND active = 1 ";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, 2);
            preparedStatement.setTimestamp(2, currentDate);
            preparedStatement.setInt(3, specializationModel.getSpecializationId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public SpecializationModel getSpecializationById(Integer specializationId) {
        SpecializationModel specializationModel = new SpecializationModel();
        try {
            query = "SELECT * FROM specializations where specialization_id = ? AND active = 1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, specializationId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                specializationModel.setSpecializationId(resultSet.getInt("specialization_id"));
                specializationModel.setName(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return specializationModel;
    }

    @Override
    public SpecializationModel getSpecializationByName(String specializationName) {
        SpecializationModel specializationModel = new SpecializationModel();
        try {
            query = "SELECT * FROM specializations where name = ? AND active = 1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, specializationName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                specializationModel.setSpecializationId(resultSet.getInt("specialization_id"));
                specializationModel.setName(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return specializationModel;
    }

}
