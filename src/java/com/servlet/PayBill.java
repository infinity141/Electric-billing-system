package com.servlet;

import com.servlet.registration.Customer;
import controllers.DBcontroller;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayBill extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) req.getSession().getAttribute("user");
        if (customer != null) {
            try {
                int userPay = Integer.parseInt(req.getParameter("id"));
                PreparedStatement preparedStatementAll = DBcontroller.getCon().prepareStatement("UPDATE history SET status = \"paid\" WHERE historyId = ?");
                preparedStatementAll.setInt(1, userPay);
                preparedStatementAll.executeUpdate();
                resp.sendRedirect("viewBill");
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
    
    
}
