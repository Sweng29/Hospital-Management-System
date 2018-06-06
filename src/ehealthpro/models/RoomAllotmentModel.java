/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.models;

import java.sql.Timestamp;

/**
 *
 * @author sweng
 */
public class RoomAllotmentModel extends Model {

    private Integer allotmentId;
    private Timestamp allotmentDate;
    private Timestamp dischargeDate;
    private String status;
    private RoomDetailModel roomDetailModel;
    private AppointmentModel appointmentModel;

    public RoomDetailModel getRoomDetailModel() {
        return roomDetailModel;
    }

    public void setRoomDetailModel(RoomDetailModel roomDetailModel) {
        this.roomDetailModel = roomDetailModel;
    }

    public AppointmentModel getAppointmentModel() {
        return appointmentModel;
    }

    public void setAppointmentModel(AppointmentModel appointmentModel) {
        this.appointmentModel = appointmentModel;
    }

    public Integer getAllotmentId() {
        return allotmentId;
    }

    public void setAllotmentId(Integer allotmentId) {
        this.allotmentId = allotmentId;
    }

    public Timestamp getAllotmentDate() {
        return allotmentDate;
    }

    public void setAllotmentDate(Timestamp allotmentDate) {
        this.allotmentDate = allotmentDate;
    }

    public Timestamp getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Timestamp dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
