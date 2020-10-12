package controllers;

import beans.User;
import repositories.UserRepository;
import services.DateService;
import services.MailerService;
import services.PasswordGeneratorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstname"),
                lastName = request.getParameter("lastname"),
                email  = request.getParameter("email"),
                role = request.getParameter("role") == null ? "Customer" : request.getParameter("role"),
                password = PasswordGeneratorService.generate(6);
        int phone = Integer.parseInt( request.getParameter("phone"));

        if (UserRepository.findByEmail(email) != null) {
            request.setAttribute("error", "Email has been used.");
        }else if (UserRepository.findByPhone(phone) != null) {
            request.setAttribute("error", "Phone number has been used.");
        }else {
            UserRepository.create(new User(null, firstName,
                    lastName, email, password, "Customer",
                    DateService.today(), DateService.today(), phone));
            MailerService.sendMessage(email, "Registration", "You have been successfully registered as "+role+".\nUse these credentials to access the system :" +
                    "\nEmail :"+email+"" +
                    "\nPassword : "+password+"" +
                    "\nWe advice you change your password for security." +
                    "\nKind regards.");
            request.setAttribute("message", "Registration success. Password emailed to "+email);
        }
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }
}
