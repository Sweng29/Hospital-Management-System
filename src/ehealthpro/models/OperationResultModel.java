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
public class OperationResultModel extends Model {

    private Integer operationResultId;
    private String result;
    private Timestamp operationDate;
    private String status;
    private String feesStatus;
    private AppointmentModel appointmentModel;
    private OperationModel operationModel;

    public String getFeesStatus() {
        return feesStatus;
    }

    public void setFeesStatus(String feesStatus) {
        this.feesStatus = feesStatus;
    }

    public AppointmentModel getAppointmentModel() {
        return appointmentModel;
    }

    public void setAppointmentModel(AppointmentModel appointmentModel) {
        this.appointmentModel = appointmentModel;
    }

    public OperationModel getOperationModel() {
        return operationModel;
    }

    public void setOperationModel(OperationModel operationModel) {
        this.operationModel = operationModel;
    }

    public Integer getOperationResultId() {
        return operationResultId;
    }

    public void setOperationResultId(Integer operationResultId) {
        this.operationResultId = operationResultId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Timestamp getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Timestamp operationDate) {
        this.operationDate = operationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
