package com.servlet.registration;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {

    public int userId;
    public String fullName;
    public String address;
    public String email;
    public String phoneNumber;
    public String password;
    public String gender;
    public boolean approved;
    public String role;

    // Collect data from database with the rs parameter and saves the inforations here!
    public Customer(ResultSet rs) throws SQLException {
        this.userId = rs.getInt("userId");
        this.fullName = rs.getString("fullName");
        this.address = rs.getString("address");
        this.email = rs.getString("email");
        this.phoneNumber = rs.getString("phoneNumber");
        this.password = rs.getString("password");
        this.gender = rs.getString("gender");
        this.approved = rs.getBoolean("approved");
        this.role = rs.getString("role");
    }

    // Empty customer constructor!
    public Customer() {

    }
;

}
