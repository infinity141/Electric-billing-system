package com.servlet;

import com.servlet.registration.Customer;
import controllers.DBcontroller;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) req.getSession().getAttribute("user");
        if (customer != null) {
            try {
                int userDeleteId = Integer.parseInt(req.getParameter("id"));
                PreparedStatement preparedStatementAll = DBcontroller.getCon().prepareStatement("DELETE FROM customer WHERE userId = ?");
                PreparedStatement preparedStatementUserDataHandler = DBcontroller.getCon().prepareStatement("DELETE FROM history WHERE userId = ?");
                preparedStatementAll.setInt(1, userDeleteId);
                preparedStatementUserDataHandler.setInt(1, userDeleteId);
                preparedStatementAll.executeUpdate();
                preparedStatementUserDataHandler.executeUpdate();
                resp.sendRedirect("viewUser");
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
