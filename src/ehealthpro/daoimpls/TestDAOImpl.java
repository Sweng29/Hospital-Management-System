/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.daoimpls;

import ehealthpro.connection.DBConnection;
import ehealthpro.dao.TestDAO;
import ehealthpro.models.TestModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sweng
 */
public class TestDAOImpl implements TestDAO {

    Connection conn = DBConnection.getConnected();
    Statement statement = null;
    PreparedStatement preparedStatement;

    @Override
    public ResultSet getAllTests() {
        ResultSet resultSet = null;
        try {
            String query = "Select t.test_id as 'Test ID',t.test as 'Test Name',t.charges "
                    + " as 'Charges',t.duration as 'Duration in Days',tc.name as 'Created By' "
                    + " , tm.name as 'Modified By' from tests t "
                    + " Inner join user_login tc "
                    + " on t.created_by = tc.user_id "
                    + " Inner join user_login tm "
                    + " on t.modified_by = tm.user_id where t.active=1";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Integer addTest(TestModel testModel) {
        Integer result = 0;
        try {
            String query = "Insert into tests(test,charges,duration,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, testModel.getTest());
            preparedStatement.setInt(2, testModel.getCharges());
            preparedStatement.setInt(3, testModel.getDuration());
            preparedStatement.setInt(4, testModel.getCreatedBy());
            preparedStatement.setTimestamp(5, testModel.getCreatedDate());
            preparedStatement.setInt(6, testModel.getModifiedBy());
            preparedStatement.setTimestamp(7, testModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer updateTest(TestModel testModel) {
        Integer result = 0;
        try {
            String query = "update tests set test =?, charges =?,duration=?,modified_by =?,modified_date=? where test_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, testModel.getTest());
            preparedStatement.setInt(2, testModel.getCharges());
            preparedStatement.setInt(3, testModel.getDuration());
            preparedStatement.setInt(4, testModel.getModifiedBy());
            preparedStatement.setTimestamp(5, testModel.getModifiedDate());
            preparedStatement.setInt(6, testModel.getTestId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteTest(TestModel testModel) {
        Integer result = 0;
        try {
            String query = "update tests set active=0 , modified_by = ? where test_id=? and active=1;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, testModel.getModifiedBy());
            preparedStatement.setInt(2, testModel.getTestId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public TestModel getTestById(Integer testId) {
        TestModel testModel = new TestModel();
        try {
            String query = "SELECT * FROM tests where test_id =? AND active = 1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, testId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                testModel.setTestId(resultSet.getInt("test_id"));
                testModel.setTest(resultSet.getString("test"));
                testModel.setCharges(resultSet.getInt("charges"));
                testModel.setDuration(resultSet.getInt("duration"));
                testModel.setCreatedBy(resultSet.getInt("created_by"));
                testModel.setModifiedBy(resultSet.getInt("modified_by"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testModel;
    }

    @Override
    public TestModel getTestByName(String testName) {
        TestModel testModel = new TestModel();
        try {
            String query = "SELECT * FROM tests where test =? AND active = 1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, testName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                testModel.setTestId(resultSet.getInt("test_id"));
                testModel.setTest(resultSet.getString("test"));
                testModel.setCharges(resultSet.getInt("charges"));
                testModel.setDuration(resultSet.getInt("duration"));
                testModel.setCreatedBy(resultSet.getInt("created_by"));
                testModel.setModifiedBy(resultSet.getInt("modified_by"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testModel;
    }
}
