/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.EquipmentTypeModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface EquipmentTypeDAO {
    public ResultSet getAllEquipmentType();
    public Integer addEquipmentType(EquipmentTypeModel equipmentTypeModel);
    public Integer updateEquipmentType(EquipmentTypeModel equipmentTypeModel);
    public Integer deleteEquipmentTypeById(EquipmentTypeModel equipmentTypeModel);
    public EquipmentTypeModel getEquipmentTypeById(Integer equipmentTypeId);
    public EquipmentTypeModel getEquipmentTypeByName(String equipmentType);
}
