/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.RoomTypeDAO;
import ehealthpro.models.RoomTypeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class RoomTypeDAOImpl implements RoomTypeDAO {

    Connection conn = DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;

    @Override
    public ResultSet getAllRoomTypes() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT  rt.`room_type_id` AS 'Room Type ID',rt.`type` AS 'Room Type',\n" +
            "rt.`charges` AS 'Charges',rtc.name AS 'Created By',rtm.`name` AS 'Modified By'\n" +
            "FROM room_type rt INNER JOIN user_login rtc ON rt.`created_by` = rtc.`user_id`\n" +
            "INNER JOIN user_login rtm ON rt.`modified_by` = rtm.`user_id`\n" +
            "WHERE rt.`active`=1 AND rtc.`active`=1 AND rtm.`active`=1;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addRoomType(RoomTypeModel roomTypeModel) {
        Integer result = 0;
        try {
            String query = "Insert into room_type(type,charges,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, roomTypeModel.getType());
            preparedStatement.setInt(2, roomTypeModel.getCharges());
            preparedStatement.setInt(3, roomTypeModel.getCreatedBy());
            preparedStatement.setTimestamp(4, roomTypeModel.getCreatedDate());
            preparedStatement.setInt(5, roomTypeModel.getModifiedBy());
            preparedStatement.setTimestamp(6, roomTypeModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateRoomType(RoomTypeModel roomTypeModel) {
        Integer result = 0;
        try {
            String query = "update room_type set type =?,charges =?, modified_by =?,modified_date=? where room_type_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, roomTypeModel.getType());
            preparedStatement.setInt(2, roomTypeModel.getCharges());
            preparedStatement.setInt(3, roomTypeModel.getModifiedBy());
            preparedStatement.setTimestamp(4, roomTypeModel.getModifiedDate());
            preparedStatement.setInt(5, roomTypeModel.getRoomTypeId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteRoomTypeById(RoomTypeModel roomTypeModel) {
        Integer result = 0;
        try {
            String query = "update room_type set active=0 , modified_by = ?,modified_date=? where room_type_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, roomTypeModel.getModifiedBy());
            preparedStatement.setTimestamp(2, roomTypeModel.getModifiedDate());
            preparedStatement.setInt(3, roomTypeModel.getRoomTypeId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public RoomTypeModel getRoomTypeById(Integer roomTypeId) {
        RoomTypeModel roomTypeModel = new RoomTypeModel();
        try {
            String query = "SELECT  rt.`room_type_id` AS 'Room Type ID',rt.`type` AS 'Room Type',\n" +
            "rt.`charges` AS 'Charges',rtc.name AS 'Created By',rtm.`name` AS 'Modified By'\n" +
            "FROM room_type rt INNER JOIN user_login rtc ON rt.`created_by` = rtc.`user_id`\n" +
            "INNER JOIN user_login rtm ON rt.`modified_by` = rtm.`user_id`\n" +
            "WHERE rt.room_type_id =? AND rt.`active`=1 AND rtc.`active`=1 AND rtm.`active`=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, roomTypeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                roomTypeModel.setRoomTypeId(resultSet.getInt("Room Type ID"));
                roomTypeModel.setCharges(resultSet.getInt("Charges"));
                roomTypeModel.setType(resultSet.getString("Room Type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomTypeModel;
    }

    @Override
    public RoomTypeModel getRoomTypeByName(String name) {
        RoomTypeModel roomTypeModel = new RoomTypeModel();
        try {
            String query = "SELECT  rt.`room_type_id` AS 'Room Type ID',rt.`type` AS 'Room Type',\n" +
            "rt.`charges` AS 'Charges',rtc.name AS 'Created By',rtm.`name` AS 'Modified By'\n" +
            "FROM room_type rt INNER JOIN user_login rtc ON rt.`created_by` = rtc.`user_id`\n" +
            "INNER JOIN user_login rtm ON rt.`modified_by` = rtm.`user_id`\n" +
            "WHERE rt.type=? AND rt.`active`=1 AND rtc.`active`=1 AND rtm.`active`=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                roomTypeModel.setRoomTypeId(resultSet.getInt("Room Type ID"));
                roomTypeModel.setCharges(resultSet.getInt("Charges"));
                roomTypeModel.setType(resultSet.getString("Room Type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomTypeModel;
    }

}
