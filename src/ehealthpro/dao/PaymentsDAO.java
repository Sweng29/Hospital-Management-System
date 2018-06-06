/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface PaymentsDAO {
    public ResultSet getRoomChargesForAllPatients();
    public ResultSet getOperationChargesForAllPatients();
    public ResultSet getTestChargesForAllPatients();
    public ResultSet getDoctorFeesRecord();
    public ResultSet getPatientRecordByAppointmentId(Integer appointmentId);
    public ResultSet getPatientOperationRecordByAppointmentId(Integer appointmentId);
    public ResultSet getPatientRoomRecordByAppointmentId(Integer appointmentId);
    public ResultSet getPatientTestByAppointmentId(Integer appointmentId);
    public ResultSet getDoctorFeesByAppointmentId(Integer appointmentId);
    public ResultSet getGrandTotalRecord();
}
