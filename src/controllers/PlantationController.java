package controllers;

import beans.Plant;
import repositories.FarmRepository;
import repositories.PlantRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PlantationController", urlPatterns = {"/plantation"})
public class PlantationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("NewPlant") != null) {
            String name = request.getParameter("name"),
                    category = request.getParameter("category"),
                    plantedon = request.getParameter("plantedon"),
                    description = request.getParameter("description");
            int rootscount = Integer.parseInt(request.getParameter("rootscount"));
            Long farmid = Long.parseLong(request.getParameter("farmid"));
            PlantRepository.create(new Plant(null, name, category, description, plantedon, rootscount, farmid));
            response.sendRedirect("plantation?fid="+farmid);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("fid") != null) {
            Long fid = Long.parseLong(request.getParameter("fid"));
            request.setAttribute("farm", FarmRepository.get(fid));
            request.setAttribute("plants", PlantRepository.findByParentId(fid));
            request.getRequestDispatcher("plantation.jsp").forward(request, response);
        }else {
            response.sendRedirect("farms");
        }
    }
}
