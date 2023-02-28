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

public class AdminProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) req.getSession().getAttribute("user");
        if (customer != null) {
            RequestDispatcher view = req.getRequestDispatcher("adminProfile.jsp");
            view.forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) req.getSession().getAttribute("user");
        if (customer != null) {
            RequestDispatcher view = req.getRequestDispatcher("adminProfile.jsp");
            view.forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
