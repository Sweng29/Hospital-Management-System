/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.ManufacturerModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface ManufacturerDAO {
    public ResultSet getAllManufacturer();
    public Integer addManufacturer(ManufacturerModel manufacturerModel);
    public Integer updateManufacturer(ManufacturerModel manufacturerModel);
    public Integer deleteManufacturerById(ManufacturerModel manufacturerModel);
    public ManufacturerModel getManufacturerById(Integer manufacturerId);
    public ManufacturerModel getManufacturerByName(String manufacturerName);

}
