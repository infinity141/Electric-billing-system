package com.servlet.customerDao;

import com.servlet.registration.UpdateCostWrite;
import controllers.DBcontroller;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteUpdateCost {
    public int WriteUpdate(UpdateCostWrite updateCost) {
    try {
            String UPDATE_COST_SQL;
            UPDATE_COST_SQL = "UPDATE updatecost SET "
                    + "grt3 = ?, btw23 = ?, btw12 = ?, less1 = ?";

            int result = 0;
            PreparedStatement preparedStatement = DBcontroller.getCon().prepareStatement(UPDATE_COST_SQL);
            preparedStatement.setInt(1, updateCost.greaterThan3);
            preparedStatement.setInt(2, updateCost.between23);
            preparedStatement.setInt(3, updateCost.between12);
            preparedStatement.setInt(4, updateCost.lessThan1);

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