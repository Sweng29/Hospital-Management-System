/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.models;

/**
 *
 * @author sweng
 */
public class ShiftingModel extends Model{
    private Integer shiftId;
    private String shift;
    private String shiftingFrom;
    private String shiftingTo;

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getShiftingFrom() {
        return shiftingFrom;
    }

    public void setShiftingFrom(String shiftingFrom) {
        this.shiftingFrom = shiftingFrom;
    }

    public String getShiftingTo() {
        return shiftingTo;
    }

    public void setShiftingTo(String shiftingTo) {
        this.shiftingTo = shiftingTo;
    }
    
    
}
