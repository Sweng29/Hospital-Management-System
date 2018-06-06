/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.EmployeeTypeModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface EmployeeTypeDAO {
    public ResultSet getAllEmployeeTypes();
    public Integer addEmployeeType(EmployeeTypeModel employeeTypeModel);
    public Integer updateEmployeeType(EmployeeTypeModel employeeTypeModel);
    public Integer deleteEmployeeType(EmployeeTypeModel employeeTypeModel);
    public EmployeeTypeModel getEmployeeTypeById(Integer employeeTypeId);
    public EmployeeTypeModel getEmployeeTypeByName(String name);
}
