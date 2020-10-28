package controllers;

import beans.AnimalProduct;
import beans.PlantProduct;
import components.Cart;
import repositories.AnimalProductRepository;
import repositories.PlantProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductsController", urlPatterns = {"/products"})
public class ProductsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("cart") == null) {
            request.getSession().setAttribute("cart", new Cart());
        }

        if (request.getParameter("pc") != null) {
            PlantProduct plantProduct = PlantProductRepository.get(Long.parseLong(request.getParameter("pc")));
            Cart cart =  (Cart) request.getSession().getAttribute("cart");
            cart.add(plantProduct);
        }


        if (request.getParameter("ac") != null) {
            AnimalProduct animalProduct = AnimalProductRepository.get(Long.parseLong(request.getParameter("ac")));
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            cart.add(animalProduct);
        }

        request.setAttribute("plant-products", PlantProductRepository.all());
        request.setAttribute("animal-products", AnimalProductRepository.all());
        request.getRequestDispatcher("products.jsp").forward(request, response);
    }
}
