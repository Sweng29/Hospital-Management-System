/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.models;

/**
 *
 * @author sweng
 */
public class PermissionModel extends Model{
    private Integer permissionId;
    private String permission;
    private ScreenViewModel screenViewModel;

    public ScreenViewModel getScreenViewModel() {
        return screenViewModel;
    }

    public void setScreenViewModel(ScreenViewModel screenViewModel) {
        this.screenViewModel = screenViewModel;
    }
    
    
    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
