package com.servlet.customerDao;

import com.servlet.registration.History;
import controllers.DBcontroller;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CreateBill {
    
    public int CreatingBill(History history) throws ClassNotFoundException {
        try {
            String INSERT_USER_SQL;
            INSERT_USER_SQL = "INSERT INTO history"
                    + "(historyId, userId, unit, charge, date, status) VALUES"
                    + "(NULL,?,?,?,?,?);";

            int result = 0;
            PreparedStatement preparedStatement = DBcontroller.getCon().prepareStatement(INSERT_USER_SQL);
            preparedStatement.setInt(1, history.userId);
            preparedStatement.setInt(2, history.unit);
            preparedStatement.setInt(3, history.charge);
            preparedStatement.setString(4, history.date);
            preparedStatement.setString(5, history.status);

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

            return result;
            
        } catch (SQLException ex) {
            Logger.getLogger(customerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
