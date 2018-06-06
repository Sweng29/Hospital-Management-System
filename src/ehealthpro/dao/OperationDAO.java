/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.OperationModel;
import ehealthpro.models.OperationResultModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface OperationDAO {

    public ResultSet getAllOperations();

    public Integer addOperation(OperationModel operationModel);

    public Integer updateOperation(OperationModel operationModel);

    public Integer deleteOperationById(OperationModel operationModel);

    public OperationModel getOperationById(Integer operationId);
    
    public OperationModel getOperationByName(String operationName);

}
