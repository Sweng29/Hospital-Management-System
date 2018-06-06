/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.UserLoginModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface UserLoginDAO {
    
    public ResultSet getAllUsers();

    public Integer addUser(UserLoginModel userLoginModel);

    public Integer updateUser(UserLoginModel userLoginModel);

    public Integer deleteUserById(UserLoginModel userLoginModel);

    public UserLoginModel getUserById(Integer userId);
    
    public UserLoginModel getUserLoggedIn(UserLoginModel userLoginModel);
    
    public boolean checkUserNameUniqueness(String name);
}
