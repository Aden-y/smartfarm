package controllers;

import beans.PlantProduct;
import repositories.PlantProductRepository;
import repositories.PlantRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PlantProductsController", urlPatterns = {"/plant-products"})
public class PlantProductsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("NewProduct") != null) {
            String name = request.getParameter("name"),
                    units = request.getParameter("units"),
                    description = request.getParameter("description");
            int plantId = Integer.parseInt(request.getParameter("plantid"));
            double price = Double.parseDouble(request.getParameter("price")),
                    quantity = Double.parseDouble(request.getParameter("quantity"));
            PlantProductRepository.create(new PlantProduct(name, description, units, quantity, price, new Long(plantId) , null));
            response.sendRedirect("plant-products?p="+plantId);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("p") != null) {
            request.setAttribute("products",
                    PlantProductRepository.
                            findByParentId(new Long(Integer.parseInt(request.getParameter("p")))));
            request.setAttribute("plant", PlantRepository.get(Long.parseLong(request.getParameter("p"))));
            request.getRequestDispatcher("plant-products.jsp").forward(request, response);
        }else {
            response.sendRedirect("farms");
        }
    }
}
