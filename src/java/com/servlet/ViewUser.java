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

public class ViewUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer cu = (Customer) req.getSession().getAttribute("user");
        if (cu != null) {
            String searchBar = req.getParameter("search");
            try {
                int searchBarInt;
                if (searchBar != null && !searchBar.equals("")) {
                    searchBarInt = Integer.parseInt(searchBar);
                    String SEARCHER = "SELECT * FROM customer WHERE userId = ?";
                    PreparedStatement preparedStatementSearch = DBcontroller.getCon().prepareStatement(SEARCHER);
                    preparedStatementSearch.setInt(1, searchBarInt);
                    ResultSet rsSearch = preparedStatementSearch.executeQuery();
                    req.setAttribute("resultSet", rsSearch);
                    RequestDispatcher view = req.getRequestDispatcher("viewUser.jsp");
                    view.forward(req, resp);
                } else {
                    PreparedStatement preparedStatementHistory = DBcontroller.getCon().prepareStatement("SELECT * FROM customer");
                    ResultSet rsHistory = preparedStatementHistory.executeQuery();
                    req.setAttribute("resultSet", rsHistory);
                    RequestDispatcher view = req.getRequestDispatcher("viewUser.jsp");
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
        Customer cu = (Customer) req.getSession().getAttribute("user");
        if (cu != null) {
            try {
                PreparedStatement preparedStatementAll = DBcontroller.getCon().prepareStatement("SELECT * FROM customer");
                ResultSet rsAll = preparedStatementAll.executeQuery();
                req.setAttribute("resultSet", rsAll);
                RequestDispatcher view = req.getRequestDispatcher("viewUser.jsp");
                view.forward(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

}
