package com.servlet;

import com.servlet.customerDao.WriteUpdateCost;
import com.servlet.registration.Customer;
import com.servlet.registration.UpdateCostWrite;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCost extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) req.getSession().getAttribute("user");
        if (customer != null) {
            RequestDispatcher view = req.getRequestDispatcher("updatecost.jsp");
            view.forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) req.getSession().getAttribute("user");
        if (customer != null) {
            WriteUpdateCost writeUpdateCost = new WriteUpdateCost();
            UpdateCostWrite updateCostWrite = new UpdateCostWrite();

            String greaterThan3 = req.getParameter("unit1");
            String between23 = req.getParameter("unit2");
            String between12 = req.getParameter("unit3");
            String lessThan1 = req.getParameter("unit4");

            updateCostWrite.greaterThan3 = Integer.parseInt(greaterThan3);
            updateCostWrite.between23 = Integer.parseInt(between23);
            updateCostWrite.between12 = Integer.parseInt(between12);
            updateCostWrite.lessThan1 = Integer.parseInt(lessThan1);
            writeUpdateCost.WriteUpdate(updateCostWrite);
            req.setAttribute("updated", "Cost Updated Successfully");
            RequestDispatcher view = req.getRequestDispatcher("updatecost.jsp");
            view.forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
