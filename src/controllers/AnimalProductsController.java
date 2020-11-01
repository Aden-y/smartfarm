package controllers;

import beans.Animal;
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
            AnimalProductRepository.create(new AnimalProduct(name, description, units, quantity, price, (long)animalId , null));
            response.sendRedirect("animal-products?a="+animalId);
            return;
        }

        if (request.getParameter("UpdateProduct") != null) {
            AnimalProduct product = AnimalProductRepository.get(Long.parseLong(request.getParameter("id")));
            String name = request.getParameter("name"),
                    units = request.getParameter("units"),
                    description = request.getParameter("description");
            int animalId = Integer.parseInt(request.getParameter("animalid"));
            double price = Double.parseDouble(request.getParameter("price")),
                    quantity = Double.parseDouble(request.getParameter("quantity"));
            product.setName(name);
            product.setUnits(units);
            product.setDescription(description);
            product.setPrice(price);
            product.setQuantity(quantity);
            AnimalProductRepository.update(product);
            response.sendRedirect("animal-products?a="+animalId);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("did") != null) {
            AnimalProduct product = AnimalProductRepository.get(Long.parseLong(request.getParameter("did")));
            AnimalProductRepository.delete(product.getId());
            response.sendRedirect("animal-products?p="+product.getAnimalid());
            return;
        }
        if (request.getParameter("eid") != null) {
            AnimalProduct product = AnimalProductRepository.get(Long.parseLong(request.getParameter("eid")));
            request.setAttribute("product", product);
            request.setAttribute("products",
                    AnimalProductRepository.
                            findByParentId(product.getAnimalid()));
            request.setAttribute("animal", AnimalRepository.get(product.getAnimalid()));
            request.getRequestDispatcher("animal-products.jsp").forward(request, response);
            return;
        }

        if (request.getParameter("a") != null) {
            request.setAttribute("products",
                    AnimalProductRepository.
                            findByParentId(Long.parseLong(request.getParameter("a"))));
            request.setAttribute("animal", AnimalRepository.get(Long.parseLong(request.getParameter("a"))));
            request.getRequestDispatcher("animal-products.jsp").forward(request, response);
        }else {
            response.sendRedirect("animals");
        }
    }
}
