package controllers;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBcontroller {
    
    private static Connection con;
    
    public static Connection getCon() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (con == null) {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Garmadon@141");
        }
        return con;
    }
    
}
