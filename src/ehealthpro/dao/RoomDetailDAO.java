/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.RoomDetailModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface RoomDetailDAO {

    public ResultSet getAllRoomDetails();

    public Integer addRoomDetail(RoomDetailModel roomDetailModel);

    public Integer updateRoomDetail(RoomDetailModel roomDetailModel);

    public Integer deleteRoomDetailById(RoomDetailModel roomDetailModel);

    public RoomDetailModel getRoomDetailById(Integer roomDetailId);

    public RoomDetailModel getRoomDetailByName(String roomDetailName);
}
