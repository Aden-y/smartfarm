package controllers;

import beans.AnimalStoreItem;
import repositories.AnimalStoreItemRepository;
import services.DateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AnimalStoreController", urlPatterns = {"/animal-store"})
public class AnimalStoreController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("NewItem") != null) {
            String name = request.getParameter("name"),
                    units = request.getParameter("units");
            double quantity = Double.parseDouble(request.getParameter("quantity"));
            AnimalStoreItemRepository.create(new AnimalStoreItem(name, units, quantity, DateService.today(), null));
            response.sendRedirect("animal-store");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("items", AnimalStoreItemRepository.all());
        request.getRequestDispatcher("animal-store.jsp").forward(request, response);
    }
}
