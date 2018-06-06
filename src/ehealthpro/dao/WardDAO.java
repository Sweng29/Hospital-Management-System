/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.WardModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface WardDAO {
    
    public ResultSet getAllWards();

    public Integer addWard(WardModel wardModel);

    public Integer deleteWard(WardModel wardModel);

    public Integer updateWard(WardModel wardModel);

    public WardModel getWardById(Integer wardId);
    
    public WardModel getWardByName(String wardName);
}
