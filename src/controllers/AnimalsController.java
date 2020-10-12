package controllers;

import beans.Animal;
import repositories.AnimalRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AnimalsController", urlPatterns = {"/animals"})
public class AnimalsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if (request.getParameter("NewAnimal") != null) {
           String name= request.getParameter("name"),
                   category = request.getParameter("category"),
                   breed = request.getParameter("breed"), gender = request.getParameter("gender"),
                   color = request.getParameter("color"), dob = request.getParameter("dob");
           double weight = Double.parseDouble(request.getParameter("weight"));
           int count = Integer.parseInt(request.getParameter("count"));
           AnimalRepository.create(new Animal(null, name, color, category, breed, gender, weight, dob, count));
           response.sendRedirect("animals");
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("animals", AnimalRepository.all());
        request.getRequestDispatcher("animals.jsp").forward(request, response);
    }
}
