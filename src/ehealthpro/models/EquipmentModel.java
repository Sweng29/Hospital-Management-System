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
public class EquipmentModel extends Model {

    private Integer equipmentId;
    private String name;
    private Timestamp purchaseDate;
    private String warranty;
    private Integer quaintity;
    private EquipmentTypeModel equipmentTypeModel;
    private ManufacturerModel manufacturerModel;

    public EquipmentTypeModel getEquipmentTypeModel() {
        return equipmentTypeModel;
    }

    public void setEquipmentTypeModel(EquipmentTypeModel equipmentTypeModel) {
        this.equipmentTypeModel = equipmentTypeModel;
    }

    public ManufacturerModel getManufacturerModel() {
        return manufacturerModel;
    }

    public void setManufacturerModel(ManufacturerModel manufacturerModel) {
        this.manufacturerModel = manufacturerModel;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public Integer getQuaintity() {
        return quaintity;
    }

    public void setQuaintity(Integer quaintity) {
        this.quaintity = quaintity;
    }

}
