/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.AppointmentModel;
import ehealthpro.models.EquipmentPlaceModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface EquipmentPlaceDAO {
    public ResultSet getAllEquipmentPlace();
    public Integer addEquipmentPlace(EquipmentPlaceModel equipmentPlaceModel);
    public Integer updateEquipmentPlace(EquipmentPlaceModel equipmentPlaceModel);
    public Integer deleteEquipmentPlaceById(EquipmentPlaceModel equipmentPlaceModel);
    public EquipmentPlaceModel getEquipmentPlaceById(Integer equipmentPlaceId);
}
