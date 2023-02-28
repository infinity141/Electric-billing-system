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

public class PaymentHistoryUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) req.getSession().getAttribute("user");
        if (customer != null) {
            String searchBar = req.getParameter("search");
            try {
                if (searchBar != null && !searchBar.equals("")) {
                    String SEARCHER = "SELECT * FROM history, customer where history.status = \"paid\" and customer.userId = ? and history.date LIKE ? and history.userId = customer.userId";
                    PreparedStatement preparedStatementSearch = DBcontroller.getCon().prepareStatement(SEARCHER);
                    preparedStatementSearch.setInt(1, customer.userId);
                    preparedStatementSearch.setString(2, searchBar + "%");
                    ResultSet rsSearch = preparedStatementSearch.executeQuery();
                    req.setAttribute("resultHistory", rsSearch);
                    RequestDispatcher view = req.getRequestDispatcher("historyUser.jsp");
                    view.forward(req, resp);
                } else {
                    PreparedStatement preparedStatementHistory = DBcontroller.getCon().prepareStatement("SELECT * FROM history, customer where history.status = \"paid\" and customer.userId = ? and history.userId = customer.userId");
                    preparedStatementHistory.setInt(1, customer.userId);
                    ResultSet rsHistory = preparedStatementHistory.executeQuery();
                    req.setAttribute("resultHistory", rsHistory);
                    RequestDispatcher view = req.getRequestDispatcher("historyUser.jsp");
                    view.forward(req, resp);
                }

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
                PreparedStatement preparedStatementHistory = DBcontroller.getCon().prepareStatement("SELECT * FROM history, customer where history.status = \"paid\" and customer.userId = ? and history.userId = customer.userId");
                preparedStatementHistory.setInt(1, customer.userId);
                ResultSet rsHistory = preparedStatementHistory.executeQuery();
                req.setAttribute("resultHistory", rsHistory);
                RequestDispatcher view = req.getRequestDispatcher("historyUser.jsp");
                view.forward(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

}
