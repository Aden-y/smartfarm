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

        if (request.getParameter("UpdateProduct") != null) {
            PlantProduct product = PlantProductRepository.get(Long.parseLong(request.getParameter("id")));
            String name = request.getParameter("name"),
                    units = request.getParameter("units"),
                    description = request.getParameter("description");
            int plantId = Integer.parseInt(request.getParameter("plantid"));
            double price = Double.parseDouble(request.getParameter("price")),
                    quantity = Double.parseDouble(request.getParameter("quantity"));
            product.setName(name);
            product.setUnits(units);
            product.setDescription(description);
            product.setPrice(price);
            product.setQuantity(quantity);
            PlantProductRepository.update(product);
            response.sendRedirect("plant-products?p="+plantId);
            return;
        }



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

        if (request.getParameter("did") != null) {
            PlantProduct product = PlantProductRepository.get(Long.parseLong(request.getParameter("did")));
            PlantProductRepository.delete(product.getId());
            response.sendRedirect("plant-products?p="+product.getPlantid());
            return;
        }
        if (request.getParameter("eid") != null) {
            PlantProduct product = PlantProductRepository.get(Long.parseLong(request.getParameter("eid")));
            request.setAttribute("product", product);
            request.setAttribute("products",
                    PlantProductRepository.
                            findByParentId(product.getPlantid()));
            request.setAttribute("plant", PlantRepository.get(product.getPlantid()));
            request.getRequestDispatcher("plant-products.jsp").forward(request, response);
            return;
        }

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
