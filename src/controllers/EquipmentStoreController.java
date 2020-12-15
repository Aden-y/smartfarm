package controllers;

import beans.EquipmentStoreItem;
import repositories.EquipmentStoreItemRepository;
import services.DateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EquipmentStoreController", urlPatterns = {"/equipment-store"})
public class EquipmentStoreController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("UpdateItem") != null) {
            EquipmentStoreItem item = EquipmentStoreItemRepository.get(Long.parseLong(request.getParameter("id")));
            String name = request.getParameter("name");
            double quantity = Double.parseDouble(request.getParameter("quantity"));
            item.setName(name);
            item.setQuantity(quantity);
            item.setUpdatedat(DateService.today());
            EquipmentStoreItemRepository.update(item);
            EquipmentStoreItemRepository.create(new EquipmentStoreItem(name, quantity,DateService.today(), null));
            response.sendRedirect("equipment-store");
            return;
        }

        if (request.getParameter("NewItem") != null) {
            String name = request.getParameter("name");
            double quantity = Double.parseDouble(request.getParameter("quantity"));
            EquipmentStoreItemRepository.create(new EquipmentStoreItem(name, quantity,DateService.today(), null));
            response.sendRedirect("equipment-store");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("eid") != null) {
            request.setAttribute("item", EquipmentStoreItemRepository.get(Long.parseLong(request.getParameter("eid"))));
        }

        if (request.getParameter("did") != null) {
            EquipmentStoreItemRepository.delete(Long.parseLong(request.getParameter("did")));
        }
        request.setAttribute("items", EquipmentStoreItemRepository.all());
        request.getRequestDispatcher("equipment-store.jsp").forward(request, response);
    }
}
