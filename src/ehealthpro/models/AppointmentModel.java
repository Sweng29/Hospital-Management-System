/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.models;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author sweng
 */
public class AppointmentModel extends Model {

    private Integer appointmentId;
    private EmployeeModel employeeModel;
    private PatientModel patientModel;
    private Timestamp appointmentdate;
    private String feesStatus;

    public String getFeesStatus() {
        return feesStatus;
    }

    public void setFeesStatus(String feesStatus) {
        this.feesStatus = feesStatus;
    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }

    public PatientModel getPatientModel() {
        return patientModel;
    }

    public void setPatientModel(PatientModel patientModel) {
        this.patientModel = patientModel;
    }
    private String symtoms;
    //private FeesStatusModel feesStatus;

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Timestamp getAppointmentdate() {
        return appointmentdate;
    }

    public void setAppointmentdate(Timestamp appointmentdate) {
        this.appointmentdate = appointmentdate;
    }

    public String getSymtoms() {
        return symtoms;
    }

    public void setSymtoms(String symtoms) {
        this.symtoms = symtoms;
    }

}
