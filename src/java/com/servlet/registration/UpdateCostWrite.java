/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet.registration;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lensa.A.G
 */
public class UpdateCostWrite {
    public int greaterThan3;
    public int between23;
    public int between12;
    public int lessThan1;
    
    // Collect data from database with the rs parameter and saves the inforations here!
    public UpdateCostWrite(ResultSet rs) throws SQLException {
        this.greaterThan3 = rs.getInt("grt3");
        this.between23 = rs.getInt("btw23");
        this.between12 = rs.getInt("btw12");
        this.lessThan1 = rs.getInt("less1");
    }

    // Empty customer constructor!
    public UpdateCostWrite() {

    }
}
