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
        if (request.getParameter("UpdateItem") != null) {
            AnimalStoreItem item = AnimalStoreItemRepository.get(Long.parseLong(request.getParameter("id")));
            String name = request.getParameter("name"),
                    units = request.getParameter("units");
            double quantity = Double.parseDouble(request.getParameter("quantity"));
            item.setName(name);
            item.setUnits(units);
            item.setQuantity(quantity);
            item.setUpdatedat(DateService.today());
            AnimalStoreItemRepository.update(item);
            response.sendRedirect("animal-store");
            return;
        }

        if (request.getParameter("NewItem") != null) {
            String name = request.getParameter("name"),
                    units = request.getParameter("units");
            double quantity = Double.parseDouble(request.getParameter("quantity"));
            AnimalStoreItemRepository.create(new AnimalStoreItem(name, units, quantity, DateService.today(), null));
            response.sendRedirect("animal-store");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("eid") != null) {
            request.setAttribute("item", AnimalStoreItemRepository.get(Long.parseLong(request.getParameter("did"))));
        }

        if (request.getParameter("did") != null) {
            AnimalStoreItemRepository.delete(Long.parseLong(request.getParameter("did")));
        }
        request.setAttribute("items", AnimalStoreItemRepository.all());
        request.getRequestDispatcher("animal-store.jsp").forward(request, response);
    }
}
