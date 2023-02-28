package com.servlet;

import com.servlet.customerDao.CreateBill;
import com.servlet.registration.Customer;
import com.servlet.registration.History;
import controllers.DBcontroller;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CreateBill createBill = new CreateBill();
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            
            PreparedStatement preparedStatement = DBcontroller.getCon().prepareStatement("SELECT * FROM customer WHERE email=? AND password=?");
            PreparedStatement preparedStatementEmail = DBcontroller.getCon().prepareStatement("SELECT * FROM customer WHERE email=?");
            PreparedStatement preparedStatementAll = DBcontroller.getCon().prepareStatement("SELECT * FROM customer");
            PreparedStatement preparedStatementUpdateCost = DBcontroller.getCon().prepareStatement("SELECT * FROM updatecost");
            

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatementEmail.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();
            ResultSet rsEmail = preparedStatementEmail.executeQuery();
            ResultSet rsAll = preparedStatementAll.executeQuery();
            ResultSet rsUpdateCost = preparedStatementUpdateCost.executeQuery();
            
            if (rsEmail.next()){
                if (rs.next()) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
                    String currentDate = dateFormat.format(new Date());
                    History history = new History();
                    Customer cu = new Customer(rs);
                    HttpSession session = req.getSession();
                    session.setAttribute("user", cu);
                    req.setAttribute("resultSet", rsAll);
                    
                    // vairables for creating bill
                    int randomNumber = (int)(Math.random() * 1000);
                    int UpdateCostDetermine = 0;
                    int userId = cu.userId;
                    int unit = randomNumber;
                    int greaterThan3 = 0;
                    int between23 = 0;
                    int between12 = 0;
                    int lessThan1 = 0;
                    if (rsUpdateCost.next()){
                        greaterThan3 = rsUpdateCost.getInt("grt3");
                        between23 = rsUpdateCost.getInt("btw23");
                        between12 = rsUpdateCost.getInt("btw12");
                        lessThan1 = rsUpdateCost.getInt("less1");
                    }
                    
                    if (unit >= 300) {
                        UpdateCostDetermine = greaterThan3;
                    }
                    else if (unit >= 200 && unit < 300){
                        UpdateCostDetermine = between23;
                    }
                    else if (unit >= 100 && unit < 200){
                        UpdateCostDetermine = between12;
                    }
                    else if (unit < 100) {
                        UpdateCostDetermine = lessThan1;
                    }
                    
                    int charge = unit * UpdateCostDetermine;
                    String date = currentDate;
                    String status = "unpaid";
                    if ("Admin".equals(cu.role) ){    
                        RequestDispatcher view = req.getRequestDispatcher("adminProfile.jsp");
                        view.forward(req, resp);
                    }
                    else {
                        history.userId = userId;
                        history.unit = unit;
                        history.charge = charge;
                        history.date = date;
                        history.status = status;
                        
                        try {
                            createBill.CreatingBill(history);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        RequestDispatcher view = req.getRequestDispatcher("profile.jsp");
                        view.forward(req, resp);
                    }
                } else {
                    req.setAttribute("error", "Incorrect email or password");
                    RequestDispatcher views = req.getRequestDispatcher("index.jsp");
                    views.forward(req, resp);
                }
            }
            else {
                    req.setAttribute("error", "Couldn't find an account with this email. Go to the nearest billing station and try registering!");
                    RequestDispatcher views = req.getRequestDispatcher("index.jsp");
                    views.forward(req, resp);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
