/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.ShiftingModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface ShiftingDAO {
    public ResultSet getAllShifting();
    public Integer addShifting(ShiftingModel shiftingModel);
    public Integer updateShifting(ShiftingModel shiftingModel);
    public Integer deleteShifting(ShiftingModel shiftingModel);
    public ShiftingModel getShiftingById(Integer shiftId);
    public ShiftingModel getShiftingByName(String shiftingName);
}
