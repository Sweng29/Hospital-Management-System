/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.RoomTypeModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface RoomTypeDAO {

    public ResultSet getAllRoomTypes();

    public Integer addRoomType(RoomTypeModel roomTypeModel);

    public Integer updateRoomType(RoomTypeModel roomTypeModel);

    public Integer deleteRoomTypeById(RoomTypeModel roomTypeModel);

    public RoomTypeModel getRoomTypeById(Integer roomTypeId);
    
    public RoomTypeModel getRoomTypeByName(String name);

}
