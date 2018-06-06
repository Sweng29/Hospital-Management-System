/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import java.sql.ResultSet;
import java.util.List;
import ehealthpro.models.UserTypeModel;

/**
 *
 * @author sweng
 */
public interface UserTypeDAO {

    public ResultSet getAllUserTypes();

    public Integer addUserType(UserTypeModel userTypeModel);

    public Integer deleteUserType(UserTypeModel userTypeModel);

    public Integer updateUserType(UserTypeModel userTypeModel);

    public UserTypeModel getUserTypeById(Integer userTypeId);
    
    public UserTypeModel getUserTypeByName(String userTypeName);
}
