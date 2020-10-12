package controllers;

import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProfileController", urlPatterns = {"/profile"})
public class ProfileController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email"),
                newPassword = request.getParameter("newpassword"),
                password = request.getParameter("password");
        User user = (User) request.getSession().getAttribute("user");

        if (user.getPassword().equals(password)) {
            user.setEmail(email);
            user.setPhone(Integer.parseInt(request.getParameter("phone")));
            if (!newPassword.trim().equals("")) {
                user.setPassword(newPassword);
            }
            request.setAttribute("message", "Profile updated successfully");
        }else {
            request.setAttribute("error", "Incorrect current password");
        }
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("profile.jsp");
    }

}
