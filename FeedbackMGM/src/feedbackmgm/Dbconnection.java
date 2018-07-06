/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedbackmgm;
import java.sql.*;
import javax.swing.*;


/**
 *
 * @author shiv
 */
public class Dbconnection {
    Connection conn=null;
    PreparedStatement ps=null;
    public Connection getconnection() throws SQLException
    {
    try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin123");
        
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,e);
    }
    return conn;
}
}
