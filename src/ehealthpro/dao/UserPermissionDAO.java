/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.UserPermissionModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface UserPermissionDAO {

    public ResultSet getUserPermissions();

    public Integer addUserPermission(UserPermissionModel userPermissionModel);

    public Integer updateUserPermission(UserPermissionModel userPermissionModel);

    public Integer deleteUserPermissionById(UserPermissionModel userPermissionModel);

    public UserPermissionModel getUserPermissionById(Integer userPermissionId);
    
    public UserPermissionModel getUserPermissionByName(String userPermissionName);
    
    public UserPermissionModel getUserPermissionRecord(Integer userPermissionId);

    public ResultSet getAssignedPermissions(String userType);
    
    public ResultSet getUnAssignedPermissions(String userType);
    }
