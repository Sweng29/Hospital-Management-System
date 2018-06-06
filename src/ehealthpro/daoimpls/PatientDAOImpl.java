/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.PatientDAO;
import ehealthpro.models.BloodGroupModel;
import ehealthpro.models.PatientModel;
import ehealthpro.models.PatientTestModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class PatientDAOImpl implements PatientDAO {

    Connection conn = DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;

    @Override
    public ResultSet getAllPatients() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT p.`patient_id` AS 'Patient ID',p.`name` AS 'Name',p.`f_name` AS 'Father Name',\n" +
            "p.`gender` AS 'Gender',b.groups AS 'Blood Group',p.`contact` AS 'Contact',p.`address` AS 'Address',\n" +
            "pc.name AS 'Created By',pm.name AS 'Modified By'\n" +
            "FROM patients p INNER JOIN blood_groups b ON p.`blood_id` = b.`blood_id`\n" +
            "INNER JOIN user_login pc ON p.`created_by` = pc.`user_id` \n" +
            "INNER JOIN user_login pm ON p.`modified_by` = pm.`user_id` WHERE p.active = 1;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addPatient(PatientModel patientModel) {
        Integer result = 0;
        try {
            String query = "Insert into patients(blood_id,name,f_name,gender,contact,address,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, patientModel.getBloodGroupModel().getBloodGroupId());
            preparedStatement.setString(2, patientModel.getName());
            preparedStatement.setString(3, patientModel.getFatherName());
            preparedStatement.setString(4, patientModel.getGender());
            preparedStatement.setString(5, patientModel.getContact());
            preparedStatement.setString(6, patientModel.getAddress());
            preparedStatement.setInt(7, patientModel.getCreatedBy());
            preparedStatement.setTimestamp(8, patientModel.getCreatedDate());
            preparedStatement.setInt(9, patientModel.getModifiedBy());
            preparedStatement.setTimestamp(10, patientModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updatePatient(PatientModel patientModel) {
        Integer result = 0;
        try {
            String query = "update patients set blood_id=?,name=?,f_name = ?,gender=?,contact=?,address =?,modified_by =?,modified_date=? where patient_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, patientModel.getBloodGroupModel().getBloodGroupId());
            preparedStatement.setString(2, patientModel.getName());
            preparedStatement.setString(3, patientModel.getFatherName());
            preparedStatement.setString(4, patientModel.getGender());
            preparedStatement.setString(5, patientModel.getContact());
            preparedStatement.setString(6, patientModel.getAddress());
            preparedStatement.setInt(7, patientModel.getModifiedBy());
            preparedStatement.setTimestamp(8, patientModel.getModifiedDate());
            preparedStatement.setInt(9, patientModel.getPatientId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deletePatientById(PatientModel patientModel) {
        Integer result = 0;
        try {
            String query = "update patients set active=0 , modified_by = ?,modified_date=? where patient_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, patientModel.getModifiedBy());
            preparedStatement.setTimestamp(2, patientModel.getModifiedDate());
            preparedStatement.setInt(3, patientModel.getPatientId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public PatientModel getPatientById(Integer patientId) {
        PatientModel patientModel = new PatientModel();
        try {
            String query = "SELECT p.`patient_id` AS 'Patient ID',p.`name` AS 'Name',p.`f_name` AS 'Father Name',\n" +
            "p.`gender` AS 'Gender',b.groups AS 'Blood Group',p.`contact` AS 'Contact',p.`address` AS 'Address',\n" +
            "pc.name AS 'Created By',pm.name AS 'Modified By'\n" +
            "FROM patients p INNER JOIN blood_groups b ON p.`blood_id` = b.`blood_id`\n" +
            "INNER JOIN user_login pc ON p.`created_by` = pc.`user_id` \n" +
            "INNER JOIN user_login pm ON p.`modified_by` = pm.`user_id` WHERE p.`patient_id` = ? AND p.active = 1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, patientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                patientModel.setPatientId(resultSet.getInt("Patient ID"));
                patientModel.setName(resultSet.getString("Name"));
                BloodGroupModel bloodGroupModel = new BloodGroupModel();
                bloodGroupModel.setBloodGroup(resultSet.getString("Blood Group"));
                patientModel.setBloodGroupModel(bloodGroupModel);
                patientModel.setGender(resultSet.getString("Gender"));
                patientModel.setFatherName(resultSet.getString("Father Name"));
                patientModel.setAddress(resultSet.getString("Address"));
                patientModel.setContact(resultSet.getString("contact"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientModel;
    }

    @Override
    public PatientModel getPatientByName(String patientName) {
        PatientModel patientModel = new PatientModel();
        try {
            String query = "SELECT * FROM patients where name =? AND active = 1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, patientName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                patientModel.setPatientId(resultSet.getInt("patient_id"));
                patientModel.setName(resultSet.getString("name"));
                patientModel.setFatherName(resultSet.getString("f_name"));
                patientModel.setAddress(resultSet.getString("address"));
                patientModel.setContact(resultSet.getString("contact"));
                patientModel.setCreatedBy(resultSet.getInt("created_by"));
                patientModel.setModifiedBy(resultSet.getInt("modified_by"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientModel;
    }

}
