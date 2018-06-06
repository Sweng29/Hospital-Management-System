/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.RoomAllotmentModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface RoomAllotmentDAO {

    public ResultSet getAllRoomAllotments();

    public Integer addRoomAllotment(RoomAllotmentModel roomAllotmentModel);

    public Integer updateRoomAllotment(RoomAllotmentModel roomAllotmentModel);

    public Integer deleteRoomAllotmentById(RoomAllotmentModel roomAllotmentModel);

    public RoomAllotmentModel getRoomAllotmentById(Integer roomAllotmentId);

}
