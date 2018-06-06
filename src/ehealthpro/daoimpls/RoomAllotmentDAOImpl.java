/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.RoomAllotmentDAO;
import ehealthpro.models.AppointmentModel;
import ehealthpro.models.PatientModel;
import ehealthpro.models.RoomAllotmentModel;
import ehealthpro.models.RoomDetailModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author sweng
 */
public class RoomAllotmentDAOImpl implements RoomAllotmentDAO {

    Connection conn = DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;

    @Override
    public ResultSet getAllRoomAllotments() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT ra.`allotment_id` AS 'Allotment ID',rd.`room_no` AS 'Room No',\n" +
            "p.`name` AS 'Patient Name',ra.`allotment_date` AS 'Allotment Date',\n" +
            "ra.`discharge_date` AS 'Discharge Date',ra.`status` AS 'Status',\n" +
            "rc.`name` AS 'Created By',rm.`name` AS 'Modified By' FROM room_allotment ra \n" +
            "INNER JOIN room_details rd ON ra.`room_id` = rd.`room_id`\n" +
            "INNER JOIN appointments ap ON ra.`appointment_id` = ap.`appointment_id`\n" +
            "INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n" +
            "INNER JOIN user_login rc ON ra.`created_by` = rc.`user_id`\n" +
            "INNER JOIN user_login rm ON ra.`modified_by` = rm.`user_id`\n" +
            "WHERE ra.`active`=1 AND p.`active`=1 AND rd.`active`=1 AND rc.`active`=1 \n" +
            "AND rm.`active`=1 AND ap.`active`=1;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addRoomAllotment(RoomAllotmentModel roomAllotmentModel) {
        Integer result = 0;
        try {
            String query = "Insert into room_allotment(room_id,appointment_id,allotment_date,discharge_date,status,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, roomAllotmentModel.getRoomDetailModel().getRoomId());
            preparedStatement.setInt(2, roomAllotmentModel.getAppointmentModel().getAppointmentId());
            preparedStatement.setTimestamp(3, roomAllotmentModel.getAllotmentDate());
            preparedStatement.setTimestamp(4, roomAllotmentModel.getDischargeDate());
            preparedStatement.setString(5, roomAllotmentModel.getStatus());
            preparedStatement.setInt(6, roomAllotmentModel.getCreatedBy());
            preparedStatement.setTimestamp(7, roomAllotmentModel.getCreatedDate());
            preparedStatement.setInt(8, roomAllotmentModel.getModifiedBy());
            preparedStatement.setTimestamp(9, roomAllotmentModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateRoomAllotment(RoomAllotmentModel roomAllotmentModel) {
        Integer result = 0;
        try {
            String query = "update room_allotment set room_id=?,appointment_id=?,allotment_date=?,discharge_date=?,status=?,modified_by =?,modified_date=? where allotment_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, roomAllotmentModel.getRoomDetailModel().getRoomId());
            preparedStatement.setInt(2, roomAllotmentModel.getAppointmentModel().getAppointmentId());
            preparedStatement.setTimestamp(3, roomAllotmentModel.getAllotmentDate());
            preparedStatement.setTimestamp(4, roomAllotmentModel.getDischargeDate());
            preparedStatement.setString(5, roomAllotmentModel.getStatus());
            preparedStatement.setInt(6, roomAllotmentModel.getModifiedBy());
            preparedStatement.setTimestamp(7, roomAllotmentModel.getModifiedDate());
            preparedStatement.setInt(8, roomAllotmentModel.getAllotmentId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteRoomAllotmentById(RoomAllotmentModel roomAllotmentModel) {
        Integer result = 0;
        try {
            String query = "update room_allotment set active=0 , modified_by = ?,modified_date=? where allotment_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, roomAllotmentModel.getModifiedBy());
            preparedStatement.setTimestamp(2, roomAllotmentModel.getModifiedDate());
            preparedStatement.setInt(3, roomAllotmentModel.getAllotmentId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public RoomAllotmentModel getRoomAllotmentById(Integer roomAllotmentId) {
        RoomAllotmentModel roomAllotmentModel = new RoomAllotmentModel();
        try {
            String query = "SELECT rd.`room_no` AS 'Room No',\n" +
            "p.`name` AS 'Patient Name',ra.`appointment_id` as 'Appointment ID',ra.`allotment_date` AS 'Allotment Date',\n" +
            "ra.`discharge_date` AS 'Discharge Date',ra.`status` AS 'Status',\n" +
            "rc.`name` AS 'Created By',rm.`name` AS 'Modified By' FROM room_allotment ra \n" +
            "INNER JOIN room_details rd ON ra.`room_id` = rd.`room_id`\n" +
            "INNER JOIN appointments ap ON ra.`appointment_id` = ap.`appointment_id`\n" +
            "INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n" +
            "INNER JOIN user_login rc ON ra.`created_by` = rc.`user_id`\n" +
            "INNER JOIN user_login rm ON ra.`modified_by` = rm.`user_id`\n" +
            "WHERE ra.`allotment_id` = ? AND ra.`active`=1 AND p.`active`=1 AND rd.`active`=1 AND rc.`active`=1 \n" +
            "AND rm.`active`=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, roomAllotmentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RoomDetailModel roomDetailModel = new RoomDetailModel();
                roomDetailModel.setRoomNo(resultSet.getString("Room No"));
                PatientModel patientModel = new PatientModel();
                patientModel.setName(resultSet.getString("Patient Name"));
                roomAllotmentModel.setStatus(resultSet.getString("Status"));
                roomAllotmentModel.setAllotmentDate(resultSet.getTimestamp("Allotment Date"));
                roomAllotmentModel.setDischargeDate(resultSet.getTimestamp("Discharge Date"));
                AppointmentModel appointmentModel = new AppointmentModel();
                appointmentModel.setPatientModel(patientModel);
                roomAllotmentModel.setAppointmentModel(appointmentModel);
                roomAllotmentModel.setRoomDetailModel(roomDetailModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomAllotmentModel;
    }

}
