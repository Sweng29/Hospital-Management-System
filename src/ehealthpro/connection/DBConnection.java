/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sweng
 */
public class DBConnection {
    static Connection conn = null;
    public static Connection getConnected()
    {
        try{
            if(conn==null)
            {
               Class.forName("com.mysql.jdbc.Driver");
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root",""); 
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
