package controllers;

import beans.Order;
import beans.User;
import repositories.OrderRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrdersController", urlPatterns = {"/orders"})
public class OrdersController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("complete") != null) {
            Order order = OrderRepository.get(Long.parseLong(request.getParameter("complete")));
            order.setStatus("Complete");
            OrderRepository.update(order);
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user.getType().equals("Customer")) {
            request.setAttribute("orders", OrderRepository.findByCustomerId(user.getId()));
        }else {
            request.setAttribute("orders", OrderRepository.all());
        }
        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }


}
