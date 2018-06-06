/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.PatientModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface PatientDAO {
    public ResultSet getAllPatients();
    public Integer addPatient(PatientModel patientModel);
    public Integer updatePatient(PatientModel patientModel);
    public Integer deletePatientById(PatientModel patientModel);
    public PatientModel getPatientById(Integer patientId);
    public PatientModel getPatientByName(String patientName);
}
