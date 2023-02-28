package com.servlet;

import com.servlet.registration.Customer;
import com.servlet.customerDao.customerDao;
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

public class register extends HttpServlet {

    private customerDao customerDao = new customerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer cu = (Customer) req.getSession().getAttribute("user");
        if (cu != null) {
            RequestDispatcher view = req.getRequestDispatcher("register.jsp");
            view.forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer cu = (Customer) req.getSession().getAttribute("user");
        if (cu != null) {
            try {
                Customer customer = new Customer();

                String fullName = req.getParameter("fullName");
                String address = req.getParameter("address");
                String email = req.getParameter("email");
                // Phone number
                String phoneNumber = req.getParameter("phoneNumber");
                // Password
                String password = req.getParameter("password");
                // Gender
                String gender = req.getParameter("gender");
                // Role
                String role = req.getParameter("role");

                // put it in a database
                PreparedStatement preparedStatement = DBcontroller.getCon().prepareStatement("SELECT * FROM customer WHERE email=?");
                preparedStatement.setString(1, email);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    req.setAttribute("error", "This account already exists. Try logging in!");
                    RequestDispatcher views = req.getRequestDispatcher("register.jsp");
                    views.forward(req, resp);
                } else {
                    customer.fullName = fullName;
                    customer.address = address;
                    customer.email = email;
                    customer.phoneNumber = phoneNumber;
                    customer.password = password;
                    customer.gender = gender;
                    customer.role = role;
                    RequestDispatcher view = req.getRequestDispatcher("index.jsp");
                    view.forward(req, resp);
                    try {
                        customerDao.registerCustomer(customer);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
