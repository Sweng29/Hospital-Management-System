/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.PaymentsDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author sweng
 */
public class PaymentsDAOImpl implements PaymentsDAO {

    Connection conn = DBConnection.getConnected();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public ResultSet getRoomChargesForAllPatients() {
        try {
            String query = "SELECT ap.`appointment_id` AS 'Appointment ID',p.`name` AS 'Patient Name',rt.`type` AS 'Room Type',\n"
                    + "rt.`charges` AS 'Room Charges' FROM  appointments ap\n"
                    + "INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n"
                    + "INNER JOIN room_allotment ra ON ap.`appointment_id` = ra.`appointment_id`\n"
                    + "LEFT JOIN room_details rd ON ra.`room_id` = rd.`room_id`\n"
                    + "INNER JOIN room_type rt ON rd.`room_type_id` = rt.`room_type_id`\n"
                    + "WHERE ap.`active`=1 AND ra.`status`='Living' AND p.`active`=1 AND rd.`active`=1 AND ra.`active`=1 AND rt.`active`=1\n"
                    + "GROUP BY ap.`appointment_id`;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public ResultSet getOperationChargesForAllPatients() {
        try {
            String query = "SELECT ap.`appointment_id` AS 'Appointment ID',p.`name` AS 'Patient Name',\n"
                    + "SUM(op.`charges`) AS 'Total Operation Charges' FROM appointments ap \n"
                    + "INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n"
                    + "INNER JOIN operation_result opr ON ap.`appointment_id` = opr.`appointment_id`\n"
                    + "LEFT JOIN operation op ON opr.`operation_id` = op.`operation_id`\n"
                    + "WHERE ap.`active`=1 AND p.`active`=1 AND op.`active`=1 AND opr.`active`=1\n"
                    + "GROUP BY ap.`appointment_id`;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public ResultSet getTestChargesForAllPatients() {
        try {
            String query = "SELECT ap.`appointment_id` AS 'Appointment ID',p.`name` AS 'Patient Name',\n"
                    + "SUM(t.`charges`) AS 'Total Test Charges' FROM appointments ap\n"
                    + "INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n"
                    + "INNER JOIN patient_test pt ON ap.`appointment_id` = pt.`appointment_id`\n"
                    + "LEFT JOIN tests t ON pt.`test_id` = t.`test_id`\n"
                    + "WHERE ap.`active`=1 AND p.`active` = 1 AND pt.`active`=1 AND t.`active`=1\n"
                    + "GROUP BY ap.`appointment_id` ;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public ResultSet getDoctorFeesRecord() {
        try {
            String query = "SELECT ap.`appointment_id` AS 'Appointment ID',p.`name` AS 'Patient Name',\n"
                    + "emp.`name` AS 'Doctor Name',SUM(emp.`fees`) AS 'Doctor Fees'  FROM appointments ap\n"
                    + "INNER JOIN employees emp ON ap.`employee_id` = emp.`employee_id`\n"
                    + "INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n"
                    + "WHERE ap.`active`=1 AND p.`active` = 1 AND emp.`active`=1\n"
                    + "GROUP BY ap.appointment_id;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public ResultSet getPatientRecordByAppointmentId(Integer appointmentId) {
        try {
            String query = "";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, appointmentId);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public ResultSet getPatientOperationRecordByAppointmentId(Integer appointmentId) {
        try {
            String query = "SELECT @counter := @counter + 1 AS 'ID',opr.`operation_id` AS 'Operation ID',\n"
                    + "op.`type` AS 'Operation Type',opr.`operation_date` AS 'Operation Date',\n"
                    + "opr.`result` AS 'Operation Result',op.`charges` AS 'Operation Charges',opr.`fees_status` AS 'Fees Status' FROM appointments ap \n"
                    + "INNER JOIN operation_result opr ON ap.`appointment_id` = opr.`appointment_id`\n"
                    + "INNER JOIN operation op ON opr.`operation_id` = op.`operation_id`\n"
                    + "INNER JOIN patients p ON ap.patient_id = p.patient_id , (SELECT @counter := 0) r \n"
                    + "WHERE ap.`appointment_id` = ? AND opr.`fees_status`='Unpaid' AND p.`active`=1 AND opr.`active`=1 AND op.`active`=1 AND ap.`active`=1"
                    + " ORDER BY op.`type` ;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, appointmentId);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public ResultSet getPatientRoomRecordByAppointmentId(Integer appointmentId) {
        try {
            String query = "SELECT @counter := @counter + 1 AS 'ID',rd.`room_id` AS 'Room ID',p.`name` AS 'Patient Name',rt.`type` AS 'Room Type',\n"
                    + "ra.`allotment_date` AS 'Allotment Date',ra.`discharge_date` AS 'Discharge Date',\n"
                    + "ra.`status` AS 'Status',rt.`charges` AS 'Room Charges',DATEDIFF(ra.`discharge_date`,ra.`allotment_date`) AS 'Total Days' FROM room_allotment ra \n"
                    + "INNER JOIN room_details rd ON ra.`room_id` = rd.`room_id`\n"
                    + "INNER JOIN room_type rt ON rd.`room_type_id` = rt.`room_type_id`\n"
                    + "INNER JOIN appointments ap ON ap.`appointment_id` = ra.`appointment_id`\n"
                    + "INNER JOIN patients p ON p.`patient_id` = ap.`patient_id` , (SELECT @counter := 0) r \n"
                    + "WHERE ra.`appointment_id` = ? AND ra.`status` = 'Unpaid' AND rd.`active`=1 AND p.`active`=1 AND \n"
                    + "rt.`active`=1 AND ra.`active`=1 AND  ap.`active` = 1 ORDER BY rd.`room_id` ; ";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, appointmentId);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public ResultSet getPatientTestByAppointmentId(Integer appointmentId) {
        try {
            String query = "SELECT @counter := @counter + 1 AS 'ID',t.`test_id` AS 'Test ID',t.`test` AS 'Test Type',\n"
                    + "pt.`test_date` AS 'Test Date',pt.`result_date` AS 'Result Date',\n"
                    + "pt.`outcome` AS 'Outcome',t.`charges` AS 'Test Charges',\n"
                    + "pt.`fees_status` AS 'Fees Status' FROM patient_test pt\n"
                    + "INNER JOIN tests t ON pt.`test_id` = t.`test_id`\n"
                    + "INNER JOIN appointments ap ON ap.`appointment_id` = pt.`appointment_id`\n"
                    + "INNER JOIN patients p ON pt.`patient_id` = p.`patient_id` , (SELECT @counter := 0) r \n"
                    + "WHERE ap.`appointment_id` = ? AND pt.`fees_status`='Unpaid' AND t.`active`=1 AND p.`active`=1 AND pt.`active`=1 AND ap.`active`=1\n"
                    + "ORDER BY t.`test_id`";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, appointmentId);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public ResultSet getDoctorFeesByAppointmentId(Integer appointmentId) {
        try {
            String query = "SELECT  @counter := @counter + 1 AS 'ID',ap.`appointment_id` AS 'Appointment ID',ap.`appointment_date` AS 'Appointment Date',\n"
                    + "p.`name` AS 'Patient Name',ap.`fees_status` as 'Fees Status',p.`gender` AS 'Gender',p.`contact` AS 'Contact',p.`address` AS 'Address',\n"
                    + "ap.`symtoms` AS 'Symtoms',emp.`name` AS 'Doctor Name' ,emp.`fees` AS 'Doctor Fees' FROM appointments ap\n"
                    + "INNER JOIN employees emp ON ap.`employee_id` = emp.`employee_id`\n"
                    + "INNER JOIN patients p ON ap.`patient_id` = p.`patient_id` ,(SELECT @counter := 0) r \n"
                    + "WHERE ap.`appointment_id` = ? AND ap.`active` = 1 AND emp.`active`=1 AND p.`active`=1 "
                    + " ORDER BY ap.`appointment_id`;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, appointmentId);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public ResultSet getGrandTotalRecord() {
        try {
            String query = "SELECT ap.`appointment_id` AS 'Appointment ID',p.`name` AS 'Patient Name',emp.`name` AS 'Doctor Name',\n"
                    + "emp.`fees` AS 'Doctor Fees',ap.`appointment_date` AS 'Appointment Date',\n"
                    + "p.`contact` AS 'Contact',IF(getOperationCharges(ap.`appointment_id`) IS NULL,0,getOperationCharges(ap.`appointment_id`)) AS 'Operation Charges',\n"
                    + "IF(getTestTotalCharges(ap.`appointment_id`) IS NULL,0,getTestTotalCharges(ap.`appointment_id`)) AS 'Test Charges',\n"
                    + "IF(getTotalRoomCharges(ap.`appointment_id`) IS NULL,0,getTotalRoomCharges(ap.`appointment_id`)) AS 'Room Charges',\n"
                    + "IF(ap.`fees_status`='Paid',0,emp.`fees`) AS 'Doctor Fees Charges',\n"
                    + "grandTotal(ap.`appointment_id`) AS 'Grand Total'\n"
                    + "FROM appointments ap\n"
                    + "LEFT JOIN patients p ON ap.`patient_id` = p.`patient_id`\n"
                    + "LEFT JOIN operation_result opr ON ap.`appointment_id` = opr.`appointment_id`\n"
                    + "LEFT JOIN operation op ON opr.`operation_id` = op.`operation_id`\n"
                    + "LEFT JOIN patient_test pt ON ap.`appointment_id` = pt.`appointment_id`\n"
                    + "LEFT JOIN tests t ON pt.`test_id` = t.`test_id`\n"
                    + "LEFT JOIN room_allotment ra ON ap.`appointment_id` = ra.`appointment_id`\n"
                    + "LEFT JOIN room_details rd ON ra.`room_id` = rd.`room_id`\n"
                    + "LEFT JOIN room_type rt ON rd.`room_type_id` = rt.`room_type_id`\n"
                    + "LEFT JOIN employees emp ON ap.`employee_id` = emp.`employee_id`\n"
                    + "WHERE ap.`active` = 1\n"
                    + "GROUP BY ap.`appointment_id`;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
