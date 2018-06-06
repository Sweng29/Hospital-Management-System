/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.BloodGroupModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface BloodGroupDAO {

    public ResultSet getAllBloodGroups();

    public Integer addBloodGroup(BloodGroupModel bloodGroupModel);

    public Integer updateBloodGroup(BloodGroupModel bloodGroupModel);

    public Integer deleteBloodGroup(BloodGroupModel bloodGroupModel);

    public BloodGroupModel getBloodGroupById(Integer bloodGroupId);
    
    public BloodGroupModel getBloodGroupByName(String groupName);
}
