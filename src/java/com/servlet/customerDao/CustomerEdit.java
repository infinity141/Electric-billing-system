package com.servlet.customerDao;

import com.servlet.registration.Customer;
import controllers.DBcontroller;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerEdit {
    public static int EdtiCustomer(Customer customer) {
        try {
            String INSERT_USER_SQL;
            INSERT_USER_SQL = "UPDATE customer SET "
                    + "fullName = ?, phoneNumber = ?, password = ?, gender = ? WHERE userId = ?";

            int result = 0;
            PreparedStatement preparedStatement = DBcontroller.getCon().prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, customer.fullName);
            preparedStatement.setString(2, customer.phoneNumber);
            preparedStatement.setString(3, customer.password);
            preparedStatement.setString(4, customer.gender);
            preparedStatement.setInt(5, customer.userId);

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

            return result;

            // I created this to test the database and nope it is still not working!
        } catch (SQLException ex) {
            Logger.getLogger(customerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
