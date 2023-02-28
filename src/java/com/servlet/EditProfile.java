package com.servlet;

import com.servlet.customerDao.CustomerEdit;
import com.servlet.registration.Customer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditProfile extends HttpServlet {

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
            String fullName = req.getParameter("fullName");
            // Phone number
            String phoneNumber = req.getParameter("phoneNumber");
            // Password
            String password = req.getParameter("password");
            // Gender
            String gender = req.getParameter("gender");

            customer.fullName = fullName;
            customer.phoneNumber = phoneNumber;
            customer.password = password;
            customer.gender = gender;

            CustomerEdit.EdtiCustomer(customer);
            RequestDispatcher view = req.getRequestDispatcher("index.jsp");
            view.forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
