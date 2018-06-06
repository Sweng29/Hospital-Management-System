/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.AppointmentModel;
import ehealthpro.models.PatientModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface AppointmentDAO {

    public ResultSet getAllAppointments();

    public Integer addAppointment(AppointmentModel appointmentModel);

    public Integer updateAppointment(AppointmentModel appointmentModel);

    public Integer deleteAppointmentById(AppointmentModel appointmentModel);

    public AppointmentModel getAppointmentById(Integer appointmentId);
    
    public AppointmentModel getAppointmentByName(String appointmentName);
    
    public ResultSet getAppointmentByPatientId(Integer patientId);
    
    public PatientModel getPatientModelByAppointmentId(Integer appointmentId);

}
