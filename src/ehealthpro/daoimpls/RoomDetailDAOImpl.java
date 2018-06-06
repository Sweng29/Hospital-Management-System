/*\\
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.RoomDetailDAO;
import ehealthpro.models.RoomDetailModel;
import ehealthpro.models.RoomTypeModel;
import ehealthpro.models.WardModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class RoomDetailDAOImpl implements RoomDetailDAO {

    Connection conn = DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;

    @Override
    public ResultSet getAllRoomDetails() {
        ResultSet resultSet = null;
        try {
            String query = "Select r.room_id as 'Room ID' ,r.room_no as 'Room Number',rt.type as 'Room Type', "
                    + " w.name as 'Ward Name' ,u.name as 'Created By',m.name as 'Modified By' from room_details r inner join room_type rt"
                    + " on r.room_type_id = rt.room_type_id "
                    + "inner join ward w on r.ward_id = w.ward_id "
                    + "inner join user_login u on r.created_by = u.user_id "
                    + "inner join user_login m on r.modified_by= m.user_id where r.active = 1";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addRoomDetail(RoomDetailModel roomDetailModel) {
        Integer result = 0;
        try {
            String query = "Insert into room_details(room_type_id,ward_id,room_no,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, roomDetailModel.getRoomTypeModel().getRoomTypeId());
            preparedStatement.setInt(2, roomDetailModel.getWardModel().getWardId());
            preparedStatement.setString(3, roomDetailModel.getRoomNo());
            preparedStatement.setInt(4, roomDetailModel.getCreatedBy());
            preparedStatement.setTimestamp(5, roomDetailModel.getCreatedDate());
            preparedStatement.setInt(6, roomDetailModel.getModifiedBy());
            preparedStatement.setTimestamp(7, roomDetailModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateRoomDetail(RoomDetailModel roomDetailModel) {
        Integer result = 0;
        try {
            String query = "update room_details set room_type_id =?,ward_id = ?,room_no =?,modified_by =?,modified_date =? where room_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, roomDetailModel.getRoomTypeModel().getRoomTypeId());
            preparedStatement.setInt(2, roomDetailModel.getWardModel().getWardId());
            preparedStatement.setString(3, roomDetailModel.getRoomNo());
            preparedStatement.setInt(4, roomDetailModel.getModifiedBy());
            preparedStatement.setTimestamp(5, roomDetailModel.getModifiedDate());
            preparedStatement.setInt(6, roomDetailModel.getRoomId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteRoomDetailById(RoomDetailModel roomDetailModel) {
        Integer result = 0;
        try {
            String query = "update room_details set active=0 , modified_by = ? where room_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, roomDetailModel.getModifiedBy());
            preparedStatement.setInt(2, roomDetailModel.getRoomId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public RoomDetailModel getRoomDetailById(Integer roomDetailId) {
        RoomDetailModel roomDetailModel = new RoomDetailModel();
        try {
            String query = "SELECT r.`room_id`,r.`room_no`,rt.`room_type_id`,rt.`type`,r.`ward_id`,w.`name`,rt.`charges` FROM room_details r \n"
                    + "INNER JOIN room_type rt ON r.room_type_id = rt.room_type_id INNER JOIN ward w \n"
                    + "ON r.ward_id = w.ward_id WHERE r.room_id =? AND r.active = 1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, roomDetailId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                WardModel wardModel = new WardModel();
                RoomTypeModel roomTypeModel = new RoomTypeModel();
                roomDetailModel.setRoomId(resultSet.getInt("room_id"));
                roomDetailModel.setRoomNo(resultSet.getString("room_no"));
                roomTypeModel.setCharges(resultSet.getInt("charges"));
                roomTypeModel.setRoomTypeId(resultSet.getInt("room_type_id"));
                roomTypeModel.setType(resultSet.getString("type"));
                wardModel.setWardId(resultSet.getInt("ward_id"));
                wardModel.setName(resultSet.getString("name"));
                roomDetailModel.setRoomTypeModel(roomTypeModel);
                roomDetailModel.setWardModel(wardModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomDetailModel;
    }

    @Override
    public RoomDetailModel getRoomDetailByName(String roomDetailName) {
        RoomDetailModel roomDetailModel = new RoomDetailModel();
        try {
            String query = "SELECT * FROM room_details r inner join room_type rt "
                    + " on r.room_type_id = rt.room_type_id inner join ward w "
                    + "on r.ward_id = w.ward_id where r.room_no =? AND r.active = 1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, roomDetailName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                WardModel wardModel = new WardModel();
                RoomTypeModel roomTypeModel = new RoomTypeModel();
                roomDetailModel.setRoomId(resultSet.getInt("room_id"));
                roomDetailModel.setRoomNo(resultSet.getString("room_no"));
                roomTypeModel.setCharges(resultSet.getInt("charges"));
                roomTypeModel.setRoomTypeId(resultSet.getInt("room_type_id"));
                roomTypeModel.setType(resultSet.getString("type"));
                wardModel.setWardId(resultSet.getInt("ward_id"));
                wardModel.setName(resultSet.getString("name"));
                roomDetailModel.setCreatedBy(resultSet.getInt("created_by"));
                roomDetailModel.setModifiedBy(resultSet.getInt("modified_by"));
                roomDetailModel.setRoomTypeModel(roomTypeModel);
                roomDetailModel.setWardModel(wardModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomDetailModel;
    }
}
