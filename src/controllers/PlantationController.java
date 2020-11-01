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
        if (request.getParameter("UpdatePlant") != null) {
            long id = Long.parseLong(request.getParameter("id"));
            String name = request.getParameter("name"),
                    category = request.getParameter("category"),
                    plantedon = request.getParameter("plantedon"),
                    description = request.getParameter("description");
            int rootscount = Integer.parseInt(request.getParameter("rootscount"));
            Long farmid = Long.parseLong(request.getParameter("farmid"));
            Plant plant = PlantRepository.get(id);
            plant.setName(name);
            plant.setCategory(category);
            plant.setPlantedon(plantedon);
            plant.setDescription(description);
            plant.setRootscount(rootscount);

            PlantRepository.update(plant);
            response.sendRedirect("plantation?fid="+farmid);
            return;
        }

        if (request.getParameter("NewPlant") != null) {
            String name = request.getParameter("name"),
                    category = request.getParameter("category"),
                    plantedon = request.getParameter("plantedon"),
                    description = request.getParameter("description");
            int rootscount = Integer.parseInt(request.getParameter("rootscount"));
            Long farmid = Long.parseLong(request.getParameter("farmid"));
            PlantRepository.create(new Plant(null, name, category, description, plantedon, rootscount, farmid));
            response.sendRedirect("plantation?fid="+farmid);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("did") != null) {
            Plant plant = PlantRepository.get(Long.parseLong(request.getParameter("did")));
            PlantRepository.delete(plant.getId());
            response.sendRedirect("plantation?fid="+plant.getFarmid());
            return;
        }

        if (request.getParameter("eid") != null) {
            Plant plant = PlantRepository.get(Long.parseLong(request.getParameter("eid")));
            request.setAttribute("plant", plant);
            request.setAttribute("farm", FarmRepository.get(plant.getFarmid()));
            request.setAttribute("plants", PlantRepository.findByParentId(plant.getFarmid()));
            request.getRequestDispatcher("plantation.jsp").forward(request, response);
            return;
        }
        if (request.getParameter("fid") != null) {
            Long fid = Long.parseLong(request.getParameter("fid"));
            request.setAttribute("farm", FarmRepository.get(fid));
            request.setAttribute("plants", PlantRepository.findByParentId(fid));
            request.getRequestDispatcher("plantation.jsp").forward(request, response);
            return;
        }else {
            response.sendRedirect("farms");
            return;
        }
    }
}
