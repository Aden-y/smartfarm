package controllers;

import beans.Order;
import beans.OrderItem;
import beans.User;
import components.Cart;
import repositories.OrderRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (request.getParameter("CheckOut") != null) {
            if (request.getSession().getAttribute("user") != null) {
               if (cart.items.size() > 0) {
                   User user = (User) request.getSession().getAttribute("user");

                   OrderRepository.create(new Order(cart, Math.toIntExact(user.getId())));
                   cart.items.clear();
                   request.setAttribute("message", "Checkout success!");
                   request.getRequestDispatcher("cart.jsp").forward(request, response);
                   return;
               }else {
                   response.sendRedirect("products");
               }

            }else {
                response.sendRedirect("index.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if (request.getParameter("did") != null) {
                Cart cart = (Cart) request.getSession().getAttribute("cart");
                cart.remove(Integer.parseInt(request.getParameter("did")));
            }
            response.sendRedirect("cart.jsp");
    }
}
