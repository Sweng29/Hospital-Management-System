/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.OperationResultDAO;
import ehealthpro.models.AppointmentModel;
import ehealthpro.models.ManufacturerModel;
import ehealthpro.models.OperationModel;
import ehealthpro.models.OperationResultModel;
import ehealthpro.models.PatientModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class OperationResultDAOImpl implements OperationResultDAO {

    Connection conn = DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;

    @Override
    public ResultSet getOperationResults() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT op.`operation_result_id` AS 'Operation Result ID',p.`name` AS 'Patient Name',o.`type` AS 'Operation',\n" +
            "op.`result` AS 'Result',op.`status` AS 'Status',op.fees_status as 'Fees Status',op.`operation_date` AS 'Operation Date',uc.`name` AS 'Created By',\n" +
            "um.`name` AS 'Modified By' FROM operation_result op\n" +
            "INNER JOIN operation o ON op.`operation_id` = o.`operation_id`\n" +
            "INNER JOIN appointments ap ON op.`appointment_id` = ap.`appointment_id`\n" +
            "INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n" +
            "INNER JOIN user_login uc ON op.`created_by` = uc.`user_id`\n" +
            "INNER JOIN user_login um ON op.`modified_by` = um.`user_id` AND op.`active`=1;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addOperationResult(OperationResultModel operationResultModel) {
        Integer result = 0;
        try {
            String query = "Insert into operation_result(appointment_id,operation_id,result,operation_date,status,fees_status,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, operationResultModel.getAppointmentModel().getAppointmentId());
            preparedStatement.setInt(2, operationResultModel.getOperationModel().getOperationId());
            preparedStatement.setString(3, operationResultModel.getResult());
            preparedStatement.setTimestamp(4, operationResultModel.getOperationDate());
            preparedStatement.setString(5, operationResultModel.getStatus());
            preparedStatement.setString(6, operationResultModel.getFeesStatus());
            preparedStatement.setInt(7, operationResultModel.getCreatedBy());
            preparedStatement.setTimestamp(8, operationResultModel.getCreatedDate());
            preparedStatement.setInt(9, operationResultModel.getModifiedBy());
            preparedStatement.setTimestamp(10, operationResultModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateOperationResult(OperationResultModel operationResultModel) {
        Integer result = 0;
        try {
            String query = "update operation_result set appointment_id =?,operation_id =?,result=?,operation_date=?,status = ?,fees_status=?,modified_by =?,modified_date=? where operation_result_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, operationResultModel.getAppointmentModel().getAppointmentId());
            preparedStatement.setInt(2, operationResultModel.getOperationModel().getOperationId());
            preparedStatement.setString(3, operationResultModel.getResult());
            preparedStatement.setTimestamp(4, operationResultModel.getOperationDate());
            preparedStatement.setString(5, operationResultModel.getStatus());
            preparedStatement.setString(6, operationResultModel.getFeesStatus());
            preparedStatement.setInt(7, operationResultModel.getModifiedBy());
            preparedStatement.setTimestamp(8, operationResultModel.getModifiedDate());
            preparedStatement.setInt(9, operationResultModel.getOperationResultId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteOperationResultById(OperationResultModel operationResultModel) {
        Integer result = 0;
        try {
            String query = "update operation_result set active=0 , modified_by = ?,modified_date=? where operation_result_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, operationResultModel.getModifiedBy());
            preparedStatement.setTimestamp(2, operationResultModel.getModifiedDate());
            preparedStatement.setInt(3, operationResultModel.getOperationResultId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public OperationResultModel getOperationResultById(Integer operationResultId) {
        OperationResultModel operationResultModel = new OperationResultModel();
        try {
            String query = "SELECT op.`operation_result_id` AS 'Operation Result ID',op.`appointment_id` as 'Appointment ID',p.`name` AS 'Patient Name',o.`type` AS 'Operation Type',\n" +
            "op.`result` AS 'Result',op.`status` AS 'Status',op.fees_status as 'Fees Status',op.`operation_date` AS 'Operation Date',uc.`name` AS 'Created By',\n" +
            "um.`name` AS 'Modified By' FROM operation_result op\n" +
            "INNER JOIN operation o ON op.`operation_id` = o.`operation_id`\n" +
            "INNER JOIN appointments ap ON op.`appointment_id` = ap.`appointment_id`\n" +
            "INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n" +
            "INNER JOIN user_login uc ON op.`created_by` = uc.`user_id`\n" +
            "INNER JOIN user_login um ON op.`modified_by` = um.`user_id` where op.operation_result_id=? AND op.`active`=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, operationResultId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                operationResultModel.setOperationResultId(resultSet.getInt("Operation Result ID"));
                operationResultModel.setResult(resultSet.getString("Result"));
                operationResultModel.setStatus(resultSet.getString("Status"));
                operationResultModel.setFeesStatus(resultSet.getString("Fees Status"));
                operationResultModel.setOperationDate(resultSet.getTimestamp("Operation Date"));
                AppointmentModel appointmentModel = new AppointmentModel();
                appointmentModel.setAppointmentId(resultSet.getInt("Appointment ID"));
                PatientModel patientModel = new PatientModel();
                patientModel.setName(resultSet.getString("Patient Name"));
                OperationModel operationModel = new OperationModel();
                operationModel.setType(resultSet.getString("Operation Type"));
                appointmentModel.setPatientModel(patientModel);
                operationResultModel.setAppointmentModel(appointmentModel);
                operationResultModel.setOperationModel(operationModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operationResultModel;
    }
}
