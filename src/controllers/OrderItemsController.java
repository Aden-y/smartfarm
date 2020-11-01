package controllers;

import beans.OrderItem;
import repositories.OrderItemRepository;
import repositories.OrderRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderItemsController", urlPatterns = {"/order-items"})
public class OrderItemsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("items", OrderItemRepository.findByParentId(Long.parseLong(request.getParameter("order"))));
        request.setAttribute("order", OrderRepository.get(Long.parseLong(request.getParameter("order"))));
        request.getRequestDispatcher("order-items.jsp").forward(request, response);
    }
}
