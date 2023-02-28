package com.servlet.registration;

import java.sql.ResultSet;
import java.sql.SQLException;


public class History {
    public int historyId;
    public int userId;
    public int unit;
    public int charge;
    public String date;
    public String status;
    
    // Collect data from database with the rs parameter and saves the inforations here!
    public History(ResultSet rs) throws SQLException {
        this.historyId = rs.getInt("historyId");
        this.userId = rs.getInt("userId");
        this.unit = rs.getInt("unit");
        this.charge = rs.getInt("charge");
        this.date = rs.getString("date");
        this.status = rs.getString("status");
    }

    // Empty History constructor!
    public History() {

    }
}
