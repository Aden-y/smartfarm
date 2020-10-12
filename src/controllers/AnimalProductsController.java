package controllers;

import beans.AnimalProduct;
import repositories.AnimalProductRepository;
import repositories.AnimalRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AnimalProductsController", urlPatterns = {"/animal-products"})
public class AnimalProductsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("NewProduct") != null) {
            String name = request.getParameter("name"),
                    units = request.getParameter("units"),
                    description = request.getParameter("description");
            int animalId = Integer.parseInt(request.getParameter("animalid"));
            double price = Double.parseDouble(request.getParameter("price")),
                    quantity = Double.parseDouble(request.getParameter("quantity"));
            AnimalProductRepository.create(new AnimalProduct(name, description, units, quantity, price, new Long(animalId) , null));
            response.sendRedirect("animal-products?a="+animalId);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("a") != null) {
            request.setAttribute("products",
                    AnimalProductRepository.
                            findByAnimalId(new Long(Integer.parseInt(request.getParameter("a")))));
            request.setAttribute("animal", AnimalRepository.get(Long.parseLong(request.getParameter("a"))));
            request.getRequestDispatcher("animal-products.jsp").forward(request, response);
        }else {
            response.sendRedirect("animals");
        }
    }
}