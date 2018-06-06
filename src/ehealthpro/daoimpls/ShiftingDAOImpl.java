/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.ShiftingDAO;
import ehealthpro.models.ShiftingModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author sweng
 */
public class ShiftingDAOImpl implements ShiftingDAO {

    Connection conn = DBConnection.getConnected();
    Statement statement = null;
    PreparedStatement preparedStatement;
    String query;

    @Override
    public ResultSet getAllShifting() {
        ResultSet resultSet = null;
        try {
            query = "SELECT s.shift_id as 'Shift ID',s.shift as 'Shif Name',s.timing_from as 'Starts From',s.timing_to as 'Ends At',"
                    + " uc.name as 'Created By',s.created_date as 'Created Date',um.name as 'Modified By' , s.modified_date as 'Modified Date' FROM shiftings s"
                    + " Inner join user_login uc On s.created_by = uc.user_id "
                    + " Inner join user_login um On s.modified_by = um.user_id where s.active = 1;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addShifting(ShiftingModel shiftingModel) {
        Integer result = 0;
        // DATE values are still remaining.
        try {
            query = "INSERT into shiftings (shift,timing_from,timing_to,created_by,created_date,modified_by,modified_date) values (?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, shiftingModel.getShift());
            preparedStatement.setString(2, shiftingModel.getShiftingFrom());
            preparedStatement.setString(3, shiftingModel.getShiftingTo());
            preparedStatement.setInt(4, 1);
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            preparedStatement.setTimestamp(5, currentTime);
            preparedStatement.setInt(6, 1);
            preparedStatement.setTimestamp(7, currentTime);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateShifting(ShiftingModel shiftingModel) {
        Integer result = 0;
        try {
            query = "update shiftings set shift = ? , timing_from=? ,timing_to=?,modified_by=?,modified_date =? where shift_id = ? AND active = 1 ";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, shiftingModel.getShift());
            preparedStatement.setString(2, shiftingModel.getShiftingFrom());
            preparedStatement.setString(3, shiftingModel.getShiftingTo());
            Timestamp currentDate = new Timestamp(System.currentTimeMillis());
            preparedStatement.setInt(4, 2);
            preparedStatement.setTimestamp(5, currentDate);
            System.out.println(shiftingModel.getShiftId());
            preparedStatement.setInt(6, shiftingModel.getShiftId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteShifting(ShiftingModel shiftingModel) {
        Integer result = 0;
        try {
            query = "update shiftings set active = 0 ,modified_by =?,modified_date=? where shift_id = ? AND active = 1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,2);
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            preparedStatement.setTimestamp(2, currentTime);
            preparedStatement.setInt(3, shiftingModel.getShiftId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ShiftingModel getShiftingById(Integer shiftId) {
        ShiftingModel shiftingModel = new ShiftingModel();
        try {
            query = "SELECT * FROM shiftings where shift_id = ? AND active = 1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, shiftId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                shiftingModel.setShiftId(resultSet.getInt("shift_id"));
                shiftingModel.setShift(resultSet.getString("shift"));
                shiftingModel.setShiftingFrom(resultSet.getString("timing_from"));
                shiftingModel.setShiftingTo(resultSet.getString("timing_to"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shiftingModel;
    }

    @Override
    public ShiftingModel getShiftingByName(String shiftingName) {
    
    ShiftingModel shiftingModel = new ShiftingModel();
        try {
            query = "SELECT * FROM shiftings where shift = ? AND active = 1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, shiftingName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                shiftingModel.setShiftId(resultSet.getInt("shift_id"));
                shiftingModel.setShift(resultSet.getString("shift"));
                shiftingModel.setShiftingFrom(resultSet.getString("timing_from"));
                shiftingModel.setShiftingTo(resultSet.getString("timing_to"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shiftingModel;}

}
