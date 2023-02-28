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

public class ViewBill extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) req.getSession().getAttribute("user");
        if (customer != null) {
            try {
                PreparedStatement preparedStatementBill = DBcontroller.getCon().prepareStatement("SELECT * FROM history, customer where history.status = \"unpaid\" and customer.userId = ? and history.userId = customer.userId");
                preparedStatementBill.setInt(1, customer.userId);
                ResultSet rsBill = preparedStatementBill.executeQuery();
                req.setAttribute("resultBill", rsBill);
                RequestDispatcher view = req.getRequestDispatcher("pay.jsp");
                view.forward(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) req.getSession().getAttribute("user");
        if (customer != null) {
            try {
                PreparedStatement preparedStatementBill = DBcontroller.getCon().prepareStatement("SELECT * FROM history, customer where history.status = \"unpaid\" and customer.userId = ? and history.userId = customer.userId");
                preparedStatementBill.setInt(1, customer.userId);
                ResultSet rsBill = preparedStatementBill.executeQuery();
                req.setAttribute("resultBill", rsBill);
                RequestDispatcher view = req.getRequestDispatcher("pay.jsp");
                view.forward(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

}
