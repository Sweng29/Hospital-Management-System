/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.AppointmentDAO;
import ehealthpro.models.AppointmentModel;
import ehealthpro.models.BloodGroupModel;
import ehealthpro.models.EmployeeModel;
import ehealthpro.models.EmployeeTypeModel;
import ehealthpro.models.PatientModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class AppointmentDAOImpl implements AppointmentDAO{
    
    Connection conn=DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;
    
    @Override
    public ResultSet getAllAppointments() {
      ResultSet resultSet=null;
       try{
           String query="SELECT ap.`appointment_id` AS 'Appointment ID',p.`name` AS 'Patient Name',e.`name` AS 'Doctor Name',ap.`appointment_date` AS 'Appointment Date',\n" +
            "ap.`symtoms` AS 'Symtoms',ap.`fees_status` AS 'Fees Status',pc.`name` AS 'Created By',pm.`name` AS 'Modified By' FROM appointments ap\n" +
            "INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n" +
            "INNER JOIN employees e ON ap.`employee_id` = e.`employee_id`\n" +
            "INNER JOIN user_login pc ON p.`created_by` = pc.`user_id` \n" +
            "INNER JOIN user_login pm ON p.`modified_by` = pm.`user_id` WHERE ap.active = 1;";
           preparedStatement=conn.prepareStatement(query);
           resultSet=preparedStatement.executeQuery();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return resultSet;  
    }

    @Override
    public Integer addAppointment(AppointmentModel appointmentModel) {
        Integer result=0;
       try{
           String query="Insert into appointments(employee_id,patient_id,appointment_date,symtoms,fees_status,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,?,?,?);";
           preparedStatement=conn.prepareStatement(query);
           preparedStatement.setInt(1, appointmentModel.getEmployeeModel().getEmployeeId());
           preparedStatement.setInt(2, appointmentModel.getPatientModel().getPatientId());
           preparedStatement.setTimestamp(3, appointmentModel.getAppointmentdate());
           preparedStatement.setString(4, appointmentModel.getSymtoms());
           preparedStatement.setString(5, appointmentModel.getFeesStatus());
           preparedStatement.setInt(6, appointmentModel.getCreatedBy());
           preparedStatement.setTimestamp(7, appointmentModel.getCreatedDate());
           preparedStatement.setInt(8, appointmentModel.getModifiedBy());
           preparedStatement.setTimestamp(9, appointmentModel.getModifiedDate());
           result=preparedStatement.executeUpdate();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return result;
    }

    @Override
    public Integer updateAppointment(AppointmentModel appointmentModel) {
        Integer result=0;
         try{
             String query="update appointments set employee_id=?,patient_id =?,appointment_date=?, symtoms=?,fees_status=? ,modified_by = ?,modified_date=? where appointment_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setInt(1, appointmentModel.getEmployeeModel().getEmployeeId());
             preparedStatement.setInt(2, appointmentModel.getPatientModel().getPatientId());
             preparedStatement.setTimestamp(3, appointmentModel.getAppointmentdate());
             preparedStatement.setString(4, appointmentModel.getSymtoms());
             preparedStatement.setString(5, appointmentModel.getFeesStatus());
             preparedStatement.setInt(6, appointmentModel.getModifiedBy());
             preparedStatement.setTimestamp(7, appointmentModel.getModifiedDate());
             preparedStatement.setInt(8, appointmentModel.getAppointmentId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result; 
    }

    @Override
    public Integer deleteAppointmentById(AppointmentModel appointmentModel) {
        Integer result=0;
         try{
             String query="update appointments set active=0 , modified_by =?,modified_date=? where appointment_id=? and active=1;";
             preparedStatement= conn.prepareStatement(query);
             preparedStatement.setInt(1,appointmentModel.getModifiedBy());
             preparedStatement.setTimestamp(2, appointmentModel.getModifiedDate());
             preparedStatement.setInt(3,appointmentModel.getAppointmentId());
             result=preparedStatement.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
        return result;
    }

    @Override
    public AppointmentModel getAppointmentById(Integer appointmentId) {
       AppointmentModel appointmentModel= new AppointmentModel();
       try{
           String query = "SELECT ap.`appointment_id` AS 'Appointment ID',ap.`patient_id` AS 'Patient ID',ap.`employee_id` AS 'Doctor ID',p.`name` AS 'Patient Name',e.`name` AS 'Doctor Name',ap.`appointment_date` AS 'Appointment Date',\n" +
"ap.`symtoms` AS 'Symtoms',ap.`fees_status` AS 'Fees Status',pc.`name` AS 'Created By',pm.`name` AS 'Modified By' FROM appointments ap\n" +
"INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n" +
"INNER JOIN employees e ON ap.`employee_id` = e.`employee_id`\n" +
"INNER JOIN user_login pc ON p.`created_by` = pc.`user_id` \n" +
"INNER JOIN user_login pm ON p.`modified_by` = pm.`user_id` WHERE ap.appointment_id = ? AND ap.active = 1;";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setInt(1, appointmentId);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               appointmentModel.setAppointmentId(resultSet.getInt("Appointment ID"));
               appointmentModel.setSymtoms(resultSet.getString("Symtoms"));
               appointmentModel.setAppointmentdate(resultSet.getTimestamp("Appointment Date"));
               EmployeeModel employeeModel = new EmployeeModel();
               employeeModel.setName(resultSet.getString("Doctor Name"));
               employeeModel.setEmployeeId(resultSet.getInt("Doctor ID"));
               appointmentModel.setFeesStatus(resultSet.getString("Fees Status"));
               PatientModel patientModel = new PatientModel();
               patientModel.setName(resultSet.getString("Patient Name"));
               patientModel.setPatientId(resultSet.getInt("Patient ID"));
               appointmentModel.setPatientModel(patientModel);
               appointmentModel.setEmployeeModel(employeeModel);
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return appointmentModel;

    }    

    @Override
    public AppointmentModel getAppointmentByName(String appointmentName) {
       AppointmentModel appointmentModel= new AppointmentModel();
       try{
           String query = "SELECT ap.`appointment_id` AS 'Appointment ID',p.`name` AS 'Patient Name',e.`name` AS 'Doctor Name',ap.`appointment_date` AS 'Appointment Date',\n" +
            "ap.`symtoms` AS 'Symtoms',ap.`fees_status` AS 'Fees Status',pc.`name` AS 'Created By',pm.`name` AS 'Modified By' FROM appointments ap\n" +
            "INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n" +
            "INNER JOIN employees e ON ap.`employee_id` = e.`employee_id`\n" +
            "INNER JOIN user_login pc ON p.`created_by` = pc.`user_id` \n" +
            "INNER JOIN user_login pm ON p.`modified_by` = pm.`user_id` WHERE p.name = ? AND ap.active = 1;";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setString(1, appointmentName);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               appointmentModel.setAppointmentId(resultSet.getInt("Appointment ID"));
               System.out.println(appointmentModel.getAppointmentId());
               appointmentModel.setSymtoms(resultSet.getString("Symtoms"));
               appointmentModel.setAppointmentdate(resultSet.getTimestamp("Appointment Date"));
               EmployeeModel employeeModel = new EmployeeModel();
               employeeModel.setName(resultSet.getString("Doctor Name"));
               appointmentModel.setFeesStatus(resultSet.getString("Fees Status"));
               PatientModel patientModel = new PatientModel();
               patientModel.setName(resultSet.getString("Patient Name"));
               appointmentModel.setPatientModel(patientModel);
               appointmentModel.setEmployeeModel(employeeModel);
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return appointmentModel;    
    }

    @Override
    public ResultSet getAppointmentByPatientId(Integer patientId) {
       ResultSet resultSet = null;
       try{
           String query = "SELECT ap.`appointment_id` AS 'Appointment ID',p.`name` AS 'Patient Name',e.`name` AS 'Doctor Name',ap.`appointment_date` AS 'Appointment Date',\n" +
            "ap.`symtoms` AS 'Symtoms',ap.`fees_status` AS 'Fees Status',pc.`name` AS 'Created By',pm.`name` AS 'Modified By' FROM appointments ap\n" +
            "INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n" +
            "INNER JOIN employees e ON ap.`employee_id` = e.`employee_id`\n" +
            "INNER JOIN user_login pc ON p.`created_by` = pc.`user_id` \n" +
            "INNER JOIN user_login pm ON p.`modified_by` = pm.`user_id` WHERE p.patient_id = ? AND ap.active = 1;";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setInt(1, patientId);
           resultSet = preparedStatement.executeQuery();
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return resultSet;
    }

    @Override
    public PatientModel getPatientModelByAppointmentId(Integer appointmentId) {
       PatientModel patientModel= new PatientModel();
       try{
           String query = "SELECT p.`patient_id` AS 'Patient ID',p.`name` AS 'Patient Name',p.`f_name` AS 'Father Name',\n" +
            "p.`gender` AS 'Gender',b.groups AS 'Blood Group',p.`contact` AS 'Contact',p.`address` AS 'Address',\n" +
            "pc.name AS 'Created By',pm.name AS 'Modified By'\n" +
            "FROM appointments ap INNER JOIN patients p ON ap.`patient_id` = p.`patient_id`\n" +
            "INNER JOIN blood_groups b ON p.`blood_id` = b.`blood_id`\n" +
            "INNER JOIN user_login pc ON p.`created_by` = pc.`user_id` \n" +
            "INNER JOIN user_login pm ON p.`modified_by` = pm.`user_id` WHERE ap.`appointment_id`=? AND p.active = 1\n" +
            "AND b.`active`=1 AND pc.`active`=1 AND pm.`active`=1 AND ap.`active`=1;";
           preparedStatement = conn.prepareStatement(query);
           preparedStatement.setInt(1, appointmentId);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next())
           {
               patientModel.setPatientId(resultSet.getInt("Patient ID"));
               patientModel.setName(resultSet.getString("Patient Name"));
               patientModel.setFatherName(resultSet.getString("Father Name"));
               patientModel.setGender(resultSet.getString("Gender"));
               patientModel.setContact(resultSet.getString("Contact"));
               patientModel.setAddress(resultSet.getString("Address"));
               BloodGroupModel bloodGroupModel = new BloodGroupModel();
               bloodGroupModel.setBloodGroup(resultSet.getString("Blood Group"));
               patientModel.setBloodGroupModel(bloodGroupModel);
               
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return patientModel;
    }
}
