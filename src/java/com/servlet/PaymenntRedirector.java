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

public class PaymenntRedirector extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) req.getSession().getAttribute("user");
        int historyIdRed = Integer.parseInt(req.getParameter("historyIdRed"));
        if (customer != null) {
            try {
                PreparedStatement preparedStatementBill = DBcontroller.getCon().prepareStatement("SELECT * FROM history where historyId = ?");
                preparedStatementBill.setInt(1, historyIdRed);
                ResultSet rsBill = preparedStatementBill.executeQuery();
                rsBill.next();
                req.setAttribute("resultBill", rsBill);
                RequestDispatcher view = req.getRequestDispatcher("creditCard.jsp");
                view.forward(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(PayBill.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
