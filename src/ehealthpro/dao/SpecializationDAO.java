/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.ShiftingModel;
import ehealthpro.models.SpecializationModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface SpecializationDAO {
    public ResultSet getAllSpecializations();
    public Integer addSpecialization(SpecializationModel specializationModel);
    public Integer updateSpecialization(SpecializationModel specializationModel);
    public Integer deleteSpecialization(SpecializationModel specializationModel);
    public SpecializationModel getSpecializationById(Integer specializationId);
    public SpecializationModel getSpecializationByName(String specializationName);
}
