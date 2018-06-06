/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.dao;

import ehealthpro.models.TestModel;
import java.sql.ResultSet;

/**
 *
 * @author sweng
 */
public interface TestDAO {

    public ResultSet getAllTests();

    public Integer addTest(TestModel testModel);

    public Integer updateTest(TestModel testModel);

    public Integer deleteTest(TestModel testModel);

    public TestModel getTestById(Integer testId);
    
    public TestModel getTestByName(String testName);
}
