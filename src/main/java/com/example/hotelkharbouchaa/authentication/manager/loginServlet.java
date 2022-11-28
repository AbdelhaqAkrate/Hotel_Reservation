package com.example.hotelkharbouchaa.authentication.manager;
import java.io.IOException;
import com.example.hotelkharbouchaa.Manager.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import static java.lang.System.out;

@WebServlet(name = "loginServlet" , urlPatterns = "/admin")
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("src/Manager/index.jsp");
        requestDispatcher.forward(request,response);
        out.println("hello");
     }    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.println("username : " + username + "Password : " + password);
        if(!username.equals("") || !password.equals("")) {

            ManagerRepository managerRepository = new ManagerRepository();
            Manager manager = managerRepository.login(username, password);
            out.println("inside if");
            if(manager != null) {
                System.out.println("there is manager");
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("idAdmin", manager.getIdM());
                response.sendRedirect("/dashboard");

            } else {
                out.println("The username and password is not match.");
                response.sendRedirect("/admin");
            }
        }
        else {
            response.sendRedirect("/admin");
        }
    }
}
