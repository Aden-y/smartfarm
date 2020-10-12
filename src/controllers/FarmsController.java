package controllers;

import beans.Farm;
import repositories.FarmRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FarmsController", urlPatterns = {"/farms"})
public class FarmsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("NewFarm") != null) {
            String name = request.getParameter("name"),
                    location = request.getParameter("location");
            double size = Double.parseDouble(request.getParameter("size"));
            FarmRepository.create(new Farm(null, name, size, location));
            response.sendRedirect("farms");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("farms", FarmRepository.all());
            request.getRequestDispatcher("farms.jsp").forward(request, response);
    }
}
