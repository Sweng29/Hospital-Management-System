/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.OperationResultModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface OperationResultDAO {
    public ResultSet getOperationResults();
    public Integer addOperationResult(OperationResultModel operationResultModel);
    public Integer updateOperationResult(OperationResultModel operationResultModel);
    public Integer deleteOperationResultById(OperationResultModel operationResultModel);
    public OperationResultModel getOperationResultById(Integer operationResultId);
}
