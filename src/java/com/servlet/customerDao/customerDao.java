package com.servlet.customerDao;

import controllers.DBcontroller;
import com.servlet.registration.Customer;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class customerDao {

    public int registerCustomer(Customer customer) throws ClassNotFoundException {
        try {
            String INSERT_USER_SQL;
            INSERT_USER_SQL = "INSERT INTO customer"
                    + "(userId, fullName, address, email, phoneNumber, password, gender, role) VALUES"
                    + "(NULL,?,?,?,?,?,?,?);";

            int result = 0;
            PreparedStatement preparedStatement = DBcontroller.getCon().prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, customer.fullName);
            preparedStatement.setString(2, customer.address);
            preparedStatement.setString(3, customer.email);
            preparedStatement.setString(4, customer.phoneNumber);
            preparedStatement.setString(5, customer.password);
            preparedStatement.setString(6, customer.gender);
            preparedStatement.setString(7, customer.role);

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

            return result;

        } catch (SQLException ex) {
            Logger.getLogger(customerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
