/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.EmployeeTypeModel;
import ehealthpro.models.EmployeeModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface EmployeeDAO {
    
    public ResultSet getAllEmployees();
    public Integer addEmployee(EmployeeModel employeesModel);
    public Integer updateEmployee(EmployeeModel employeesModel);
    public Integer deleteEmployeeById(EmployeeModel employeeModel);
    public EmployeeModel getEmployeeById(Integer employeeId);
    public EmployeeModel getEmployeeByName(String employeeName);
    public ResultSet getAllDoctorEmployees();
}
