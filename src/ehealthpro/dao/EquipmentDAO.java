/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.EquipmentModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface EquipmentDAO {
    public ResultSet getAllEquipment();
    public Integer addEquipment(EquipmentModel equipmentModel);
    public Integer updateEquipment(EquipmentModel equipmentModel);
    public Integer deleteEquipment(EquipmentModel equipmentModel);
    public EquipmentModel getEquipmentById(Integer equipmentId);
}
