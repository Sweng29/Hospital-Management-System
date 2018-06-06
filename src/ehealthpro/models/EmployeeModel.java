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
public class EmployeeModel extends Model {

    private Integer employeeId;
    private String gender;
    private String name;
    private String address;
    private String contact;
    private String cnic;
    private Timestamp dateOfBirth;
    private Integer salary;
    private Integer fees;
    private BloodGroupModel bloodGroupModel;
    private EmployeeTypeModel employeeTypeModel;

    public BloodGroupModel getBloodGroupModel() {
        return bloodGroupModel;
    }

    public void setBloodGroupModel(BloodGroupModel bloodGroupModel) {
        this.bloodGroupModel = bloodGroupModel;
    }

    public EmployeeTypeModel getEmployeeTypeModel() {
        return employeeTypeModel;
    }

    public void setEmployeeTypeModel(EmployeeTypeModel employeeTypeModel) {
        this.employeeTypeModel = employeeTypeModel;
    }

    public ShiftingModel getShiftModel() {
        return shiftModel;
    }

    public void setShiftModel(ShiftingModel shiftModel) {
        this.shiftModel = shiftModel;
    }

    public SpecializationModel getSpecializationModel() {
        return specializationModel;
    }

    public void setSpecializationModel(SpecializationModel specializationModel) {
        this.specializationModel = specializationModel;
    }
    private ShiftingModel shiftModel;
    private SpecializationModel specializationModel;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

}
