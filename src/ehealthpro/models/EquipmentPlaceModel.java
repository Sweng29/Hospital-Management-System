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
public class EquipmentPlaceModel extends Model{
   
    private Integer equipmentPlacedDepartmentId;
    private String departmentName;

    public Integer getEquipmentPlacedDepartmentId() {
        return equipmentPlacedDepartmentId;
    }

    public void setEquipmentPlacedDepartmentId(Integer equipmentPlacedDepartmentId) {
        this.equipmentPlacedDepartmentId = equipmentPlacedDepartmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
}
