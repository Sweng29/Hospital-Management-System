/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.ScreenViewModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface ScreenViewDAO {

    public ResultSet getScreenViews();

    public Integer addScreenView(ScreenViewModel screenViewModel);

    public Integer updateScreenView(ScreenViewModel screenViewModel);

    public Integer deleteScreenViewById(ScreenViewModel screenViewModel);

    public ScreenViewModel getScreenViewById(Integer bloodGroupId);
    
    public ScreenViewModel getScreenViewByName(String screenViewName);
}
