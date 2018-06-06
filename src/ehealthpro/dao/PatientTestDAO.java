/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.PatientTestModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface PatientTestDAO {
    public ResultSet getPatientTests();
    public Integer addPatientTest(PatientTestModel patientTestModel);
    public Integer updatePatientTest(PatientTestModel patientTestModel);
    public Integer deletePatientTestById(PatientTestModel patientTestModel);
    public PatientTestModel getPatientTestById(Integer patientTestId);

}
