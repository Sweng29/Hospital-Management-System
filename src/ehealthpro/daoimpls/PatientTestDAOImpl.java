/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.PatientTestDAO;
import ehealthpro.models.AppointmentModel;
import ehealthpro.models.OperationResultModel;
import ehealthpro.models.PatientModel;
import ehealthpro.models.PatientTestModel;
import ehealthpro.models.TestModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class PatientTestDAOImpl implements PatientTestDAO {

    Connection conn = DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;

    @Override
    public ResultSet getPatientTests() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT pt.patient_test_id as 'Patient Test ID',p.`name` AS 'Patient Name',t.`test` AS 'Test Type',pts.`name` AS 'Appointment By',\n" +
            "pt.`test_date` AS 'Test Date',pt.`result_date` AS 'Result Date',\n" +
            "pt.fees_status as 'Fees Status',pt.`outcome` AS 'Outcome',uc.`name` AS 'Created By',um.`name` AS 'Modified By'\n" +
            "FROM patient_test pt INNER JOIN patients p ON pt.`patient_id` = p.`patient_id`\n" +
            "INNER JOIN tests t ON pt.`test_id` = t.`test_id` \n" +
            "INNER JOIN appointments ap ON pt.`appointment_id` = ap.`appointment_id`\n" +
            "INNER JOIN patients pts ON ap.`patient_id` = pts.`patient_id`\n" +
            "INNER JOIN user_login uc ON pt.`created_by` = uc.`user_id`\n" +
            "INNER JOIN user_login um ON pt.`modified_by` = um.`user_id`\n" +
            "WHERE pt.active = 1 AND p.`active`=1 AND t.`active` =1 AND ap.`active` =1;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addPatientTest(PatientTestModel patientTestModel) {
        Integer result = 0;
        try {
            String query = "Insert into patient_test(patient_id,test_id,appointment_id,test_date,result_date,fees_status,outcome,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, patientTestModel.getAppointmentModel().getPatientModel().getPatientId());
            preparedStatement.setInt(2, patientTestModel.getTestModel().getTestId());
            preparedStatement.setInt(3, patientTestModel.getAppointmentModel().getAppointmentId());
            preparedStatement.setTimestamp(4, patientTestModel.getTestDate());
            preparedStatement.setTimestamp(5, patientTestModel.getResultDate());
            preparedStatement.setString(6, patientTestModel.getFeesStatus());
            preparedStatement.setString(7, patientTestModel.getOutcome());
            preparedStatement.setInt(8, patientTestModel.getCreatedBy());
            preparedStatement.setTimestamp(9, patientTestModel.getCreatedDate());
            preparedStatement.setInt(10, patientTestModel.getModifiedBy());
            preparedStatement.setTimestamp(11, patientTestModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updatePatientTest(PatientTestModel patientTestModel) {
        Integer result = 0;
        try {
            String query = "update patient_test set patient_id=?,test_id=?,appointment_id=?,test_date=?,result_date=?,fees_status=?,outcome = ?,modified_by =?,modified_date=? where patient_test_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, patientTestModel.getAppointmentModel().getPatientModel().getPatientId());
            preparedStatement.setInt(2, patientTestModel.getTestModel().getTestId());
            preparedStatement.setInt(3, patientTestModel.getAppointmentModel().getAppointmentId());
            preparedStatement.setTimestamp(4, patientTestModel.getTestDate());
            preparedStatement.setTimestamp(5, patientTestModel.getResultDate());
            preparedStatement.setString(6, patientTestModel.getFeesStatus());
            preparedStatement.setString(7, patientTestModel.getOutcome());
            preparedStatement.setInt(8, patientTestModel.getModifiedBy());
            preparedStatement.setTimestamp(9, patientTestModel.getModifiedDate());
            preparedStatement.setInt(10, patientTestModel.getPatientTestId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deletePatientTestById(PatientTestModel patientTestModel) {
        Integer result = 0;
        try {
            String query = "update patient_test set active=0 , modified_by = ?,modified_date=? where patient_test_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, patientTestModel.getModifiedBy());
            preparedStatement.setTimestamp(2, patientTestModel.getModifiedDate());
            preparedStatement.setInt(3, patientTestModel.getPatientTestId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public PatientTestModel getPatientTestById(Integer patientTestId) {
        PatientTestModel patientTestModel = new PatientTestModel();
        try {
            String query = "SELECT pt.`patient_id` AS 'Patient ID',pt.`test_id` AS 'Test ID',pt.`appointment_id` AS 'Appointment ID',pt.patient_test_id as 'Patient Test ID',"
            + "p.`name` AS 'Patient Name',t.`test` AS 'Test Type',pts.`name` AS 'Appointment By',\n" +
            "pt.`test_date` AS 'Test Date',pt.`result_date` AS 'Result Date',\n" +
            "pt.fees_status as 'Fees Status',pt.`outcome` AS 'Outcome',uc.`name` AS 'Created By',um.`name` AS 'Modified By'\n" +
            "FROM patient_test pt INNER JOIN patients p ON pt.`patient_id` = p.`patient_id`\n" +
            "INNER JOIN tests t ON pt.`test_id` = t.`test_id` \n" +
            "INNER JOIN appointments ap ON pt.`appointment_id` = ap.`appointment_id`\n" +
            "INNER JOIN patients pts ON ap.`patient_id` = pts.`patient_id`\n" +
            "INNER JOIN user_login uc ON pt.`created_by` = uc.`user_id`\n" +
            "INNER JOIN user_login um ON pt.`modified_by` = um.`user_id`\n" +
            "WHERE pt.patient_test_id =? AND pt.active = 1 AND p.`active`=1 AND t.`active` =1 AND ap.`active` =1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, patientTestId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                patientTestModel.setPatientTestId(resultSet.getInt("Patient Test ID"));
                patientTestModel.setFeesStatus(resultSet.getString("Fees Status"));
                PatientModel patientModel = new PatientModel();
                patientModel.setName(resultSet.getString("Patient Name"));
                patientModel.setPatientId(resultSet.getInt("Patient ID"));
                AppointmentModel appointmentModel = new AppointmentModel();
                appointmentModel.setAppointmentId(resultSet.getInt("Appointment ID"));
                PatientModel patientModelForAppointment = new PatientModel();
                patientModelForAppointment.setName(resultSet.getString("Appointment By"));
                appointmentModel.setPatientModel(patientModelForAppointment);
                patientTestModel.setOutcome(resultSet.getString("Outcome"));
                patientTestModel.setAppointmentModel(appointmentModel);
                patientTestModel.setPatientModel(patientModel);
                TestModel testModel = new TestModel();
                testModel.setTest(resultSet.getString("Test Type"));
                testModel.setTestId(resultSet.getInt("Test ID"));
                patientTestModel.setTestModel(testModel);
                patientTestModel.setTestDate(resultSet.getTimestamp("Test Date"));
                patientTestModel.setResultDate(resultSet.getTimestamp("Result Date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientTestModel;
    }

}
