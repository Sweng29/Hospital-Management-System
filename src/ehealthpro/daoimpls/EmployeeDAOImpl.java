/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.models.EmployeeTypeModel;
import ehealthpro.models.EmployeeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import ehealthpro.dao.EmployeeDAO;
import ehealthpro.models.BloodGroupModel;
import ehealthpro.models.ShiftingModel;
import ehealthpro.models.SpecializationModel;

/**
 *
 * @author sweng
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    Connection conn = DBConnection.getConnected();
    PreparedStatement preparedStatement;
    Statement statement;

    @Override
    public ResultSet getAllEmployees() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT em.employee_id as 'Employee ID',em.name AS 'Name',em.cnic AS 'CNIC NO',em.date_of_birth AS 'Date of birth',em.gender AS 'Gender' "
                    + " ,b.groups AS 'Blood Group', e.name AS 'Employee Type',s.shift AS 'Shiftings',sp.name AS 'Specialization' ,\n"
                    + " em.address AS 'Address' , em.contact AS 'Contact' ,\n"
                    + " em.salary AS 'Salary' , em.fees AS 'Fees',ec.name AS 'Created By' , "
                    + " emo.name AS 'Modified By' FROM employees em \n"
                    + " INNER JOIN blood_groups b ON em.`blood_id` = b.`blood_id` \n"
                    + " INNER JOIN employees_type e ON em.`employee_type_id` = e.`employee_type_id`\n"
                    + " INNER JOIN shiftings s ON em.`shift_id` = s.`shift_id`\n"
                    + " INNER JOIN specializations sp ON em.`specialization_id` = sp.`specialization_id`\n"
                    + " INNER JOIN user_login ec ON em.`created_by` = ec.`user_id`\n"
                    + " INNER JOIN user_login emo ON em.`modified_by` = emo.`user_id`\n"
                    + " WHERE em.`active`=1";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addEmployee(EmployeeModel employeesModel) {
        Integer result = 0;
        // Date values are still remaining.
        try {
            String query = "Insert into employees(blood_id,employee_type_id,shift_id,specialization_id,"
                    + " name,gender,address,contact,cnic,date_of_birth,"
                    + "salary,fees,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, employeesModel.getBloodGroupModel().getBloodGroupId());
            preparedStatement.setInt(2, employeesModel.getEmployeeTypeModel().getEmployeeTypeId());
            preparedStatement.setInt(3, employeesModel.getShiftModel().getShiftId());
            preparedStatement.setInt(4, employeesModel.getSpecializationModel().getSpecializationId());
            preparedStatement.setString(5, employeesModel.getName());
            preparedStatement.setString(6, employeesModel.getGender());
            preparedStatement.setString(7, employeesModel.getAddress());
            preparedStatement.setString(8, employeesModel.getContact());
            preparedStatement.setString(9, employeesModel.getCnic());
            preparedStatement.setTimestamp(10, employeesModel.getDateOfBirth());
            preparedStatement.setInt(11, employeesModel.getSalary());
            preparedStatement.setInt(12, employeesModel.getFees());
            preparedStatement.setInt(13, employeesModel.getCreatedBy());
            preparedStatement.setTimestamp(14, employeesModel.getCreatedDate());
            preparedStatement.setInt(15, employeesModel.getModifiedBy());
            preparedStatement.setTimestamp(16, employeesModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateEmployee(EmployeeModel employeesModel) {
        Integer result = 0; 
        try {
            String query = "update employees set blood_id=?,employee_type_id=?,shift_id=?,specialization_id=?, name=? , gender = ?,address =?,contact =?,cnic =?,date_of_birth=?, "
                    + " salary =?,fees =?,modified_by =?,modified_date=? where employee_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, employeesModel.getBloodGroupModel().getBloodGroupId());
            preparedStatement.setInt(2, employeesModel.getEmployeeTypeModel().getEmployeeTypeId());
            preparedStatement.setInt(3, employeesModel.getShiftModel().getShiftId());
            preparedStatement.setInt(4, employeesModel.getSpecializationModel().getSpecializationId());
            preparedStatement.setString(5, employeesModel.getName());
            preparedStatement.setString(6, employeesModel.getGender());
            preparedStatement.setString(7, employeesModel.getAddress());
            preparedStatement.setString(8, employeesModel.getContact());
            preparedStatement.setString(9, employeesModel.getCnic());
            preparedStatement.setTimestamp(10, employeesModel.getDateOfBirth());
            preparedStatement.setInt(11, employeesModel.getSalary());
            preparedStatement.setInt(12, employeesModel.getFees());
            preparedStatement.setInt(13, employeesModel.getModifiedBy());
            preparedStatement.setTimestamp(14, employeesModel.getModifiedDate());
            preparedStatement.setInt(15, employeesModel.getEmployeeId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteEmployeeById(EmployeeModel employeeModel) {
        Integer result = 0;
        try {
            String query = "update employees set active=0 , modified_by =?,modified_date=? where employee_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, employeeModel.getModifiedBy());
            preparedStatement.setTimestamp(2, employeeModel.getModifiedDate());
            preparedStatement.setInt(3, employeeModel.getEmployeeId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public EmployeeModel getEmployeeById(Integer employeeId) {
        EmployeeModel employeeModel = new EmployeeModel();
        try {
            String query = "SELECT em.employee_id as 'Employee ID',em.name AS 'Name',em.cnic AS 'CNIC NO',em.date_of_birth AS 'Date of birth',em.gender AS 'Gender' "
                    + " ,b.groups AS 'Blood Group', e.name AS 'Employee Type',s.shift AS 'Shiftings',sp.name AS 'Specialization' ,\n"
                    + " em.address AS 'Address' , em.contact AS 'Contact' ,\n"
                    + " em.salary AS 'Salary' , em.fees AS 'Fees',ec.name AS 'Created By' , "
                    + " emo.name AS 'Modified By' FROM employees em \n"
                    + " INNER JOIN blood_groups b ON em.`blood_id` = b.`blood_id` \n"
                    + " INNER JOIN employees_type e ON em.`employee_type_id` = e.`employee_type_id`\n"
                    + " INNER JOIN shiftings s ON em.`shift_id` = s.`shift_id`\n"
                    + " INNER JOIN specializations sp ON em.`specialization_id` = sp.`specialization_id`\n"
                    + " INNER JOIN user_login ec ON em.`created_by` = ec.`user_id`\n"
                    + " INNER JOIN user_login emo ON em.`modified_by` = emo.`user_id`\n"
                    + " WHERE em.employee_id = ? AND  em.`active`=1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeeModel.setEmployeeId(resultSet.getInt("Employee ID"));
                employeeModel.setName(resultSet.getString("Name"));
                employeeModel.setAddress(resultSet.getString("address"));
                employeeModel.setContact(resultSet.getString("contact"));
                employeeModel.setCnic(resultSet.getString("CNIC NO"));
                employeeModel.setSalary(resultSet.getInt("salary"));
                employeeModel.setFees(resultSet.getInt("fees"));
                employeeModel.setGender(resultSet.getString("Gender"));
                employeeModel.setDateOfBirth(resultSet.getTimestamp("Date of birth"));
                //employeeModel.setCreatedBy(resultSet.getString("Created By"));
                //employeeModel.setModifiedBy(resultSet.getInt("Modified By"));
                BloodGroupModel bloodGroupModel = new BloodGroupModel();
                EmployeeTypeModel employeeTypeModel = new EmployeeTypeModel();
                employeeTypeModel.setEmployeeType(resultSet.getString("Employee Type"));
                bloodGroupModel.setBloodGroup(resultSet.getString("Blood Group"));
                employeeModel.setBloodGroupModel(bloodGroupModel);
                employeeModel.setEmployeeTypeModel(employeeTypeModel);
                ShiftingModel shiftingModel = new ShiftingModel();
                shiftingModel.setShift(resultSet.getString("Shiftings"));
                SpecializationModel specializationModel = new SpecializationModel();
                specializationModel.setName(resultSet.getString("Specialization"));
                employeeModel.setShiftModel(shiftingModel);
                employeeModel.setSpecializationModel(specializationModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeModel;
    }

    @Override
    public EmployeeModel getEmployeeByName(String employeeName) {
        EmployeeModel employeeModel = new EmployeeModel();
        try {
            String query = "SELECT em.employee_id as 'Employee ID',em.name AS 'Name',em.cnic AS 'CNIC NO',em.date_of_birth AS 'Date of birth',em.gender AS 'Gender' "
                    + " ,b.groups AS 'Blood Group', e.name AS 'Employee Type',s.shift AS 'Shiftings',sp.name AS 'Specialization' ,\n"
                    + " em.address AS 'Address' , em.contact AS 'Contact' ,\n"
                    + " em.salary AS 'Salary' , em.fees AS 'Fees',ec.name AS 'Created By' , "
                    + " emo.name AS 'Modified By' FROM employees em \n"
                    + " INNER JOIN blood_groups b ON em.`blood_id` = b.`blood_id` \n"
                    + " INNER JOIN employees_type e ON em.`employee_type_id` = e.`employee_type_id`\n"
                    + " INNER JOIN shiftings s ON em.`shift_id` = s.`shift_id`\n"
                    + " INNER JOIN specializations sp ON em.`specialization_id` = sp.`specialization_id`\n"
                    + " INNER JOIN user_login ec ON em.`created_by` = ec.`user_id`\n"
                    + " INNER JOIN user_login emo ON em.`modified_by` = emo.`user_id`\n"
                    + " WHERE em.name = ? AND  em.`active`=1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, employeeName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeeModel.setEmployeeId(resultSet.getInt("Employee ID"));
                employeeModel.setName(resultSet.getString("Name"));
                employeeModel.setAddress(resultSet.getString("address"));
                employeeModel.setContact(resultSet.getString("contact"));
                employeeModel.setCnic(resultSet.getString("CNIC NO"));
                employeeModel.setSalary(resultSet.getInt("salary"));
                employeeModel.setFees(resultSet.getInt("fees"));
                employeeModel.setGender(resultSet.getString("Gender"));
                employeeModel.setDateOfBirth(resultSet.getTimestamp("Date of birth"));
                //employeeModel.setCreatedBy(resultSet.getString("Created By"));
                //employeeModel.setModifiedBy(resultSet.getInt("Modified By"));
                BloodGroupModel bloodGroupModel = new BloodGroupModel();
                EmployeeTypeModel employeeTypeModel = new EmployeeTypeModel();
                employeeTypeModel.setEmployeeType(resultSet.getString("Employee Type"));
                bloodGroupModel.setBloodGroup(resultSet.getString("Blood Group"));
                employeeModel.setBloodGroupModel(bloodGroupModel);
                employeeModel.setEmployeeTypeModel(employeeTypeModel);
                ShiftingModel shiftingModel = new ShiftingModel();
                shiftingModel.setShift(resultSet.getString("Shiftings"));
                SpecializationModel specializationModel = new SpecializationModel();
                specializationModel.setName(resultSet.getString("Specialization"));
                employeeModel.setShiftModel(shiftingModel);
                employeeModel.setSpecializationModel(specializationModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeModel;
    }

    @Override
    public ResultSet getAllDoctorEmployees() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT em.employee_id AS 'Employee ID',em.name AS 'Name',\n" +
            "em.cnic AS 'CNIC NO',em.date_of_birth AS 'Date of birth',em.gender AS 'Gender' ,\n" +
            "b.groups AS 'Blood Group', e.name AS 'Employee Type',s.shift AS 'Shiftings',sp.name AS 'Specialization' ,\n" +
            " em.address AS 'Address' , em.contact AS 'Contact' ,\n" +
            " em.fees AS 'Fees',ec.name AS 'Created By' , \n" +
            " emo.name AS 'Modified By' FROM employees em\n" +
            "  INNER JOIN blood_groups b ON em.`blood_id` = b.`blood_id`\n" +
            "  INNER JOIN employees_type e ON em.`employee_type_id` = e.`employee_type_id`\n" +
            "  INNER JOIN shiftings s ON em.`shift_id` = s.`shift_id`\n" +
            "  INNER JOIN specializations sp ON em.`specialization_id` = sp.`specialization_id`\n" +
            "  INNER JOIN user_login ec ON em.`created_by` = ec.`user_id`\n" +
            "  INNER JOIN user_login emo ON em.`modified_by` = emo.`user_id`\n" +
            "  INNER JOIN employees_type emp ON emp.`employee_type_id` = em.`employee_type_id`\n" +
            "  WHERE emp.`name`='Doctor' AND  em.`active`=1;\n" +
            "            ";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
