package controllers;

import beans.PlantStoreItem;
import repositories.PlantStoreItemRepository;
import services.DateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PlantStoreController", urlPatterns = {"/plant-store"})
public class PlantStoreController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("NewItem") != null) {
            String name = request.getParameter("name"),
                    units = request.getParameter("units");
            double quantity = Double.parseDouble(request.getParameter("quantity"));
            PlantStoreItemRepository.create(new PlantStoreItem(name, units, quantity, DateService.today(), null));
            response.sendRedirect("plant-store");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("items", PlantStoreItemRepository.all());
        request.getRequestDispatcher("plant-store.jsp").forward(request, response);
    }
}
