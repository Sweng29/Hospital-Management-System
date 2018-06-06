/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import java.sql.ResultSet;
import ehealthpro.models.PermissionModel;


/**
 *
 * @author sweng
 */
public interface PermissionDAO {    
    public ResultSet getAllPermissions();
    public Integer addPermission(PermissionModel permissionModel);
    public Integer deletePermissionById(PermissionModel permissionModel);
    public Integer updatePermission(PermissionModel permissionModel);
    public PermissionModel getPermissionById(Integer permissionId);
    public PermissionModel getPermissionByName(String permissionName);
}
