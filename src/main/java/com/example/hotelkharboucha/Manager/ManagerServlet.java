package com.example.hotelkharboucha.Manager;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ManagerServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "login";
        }
        switch(action) {
            case "login":
                try {
                    login(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "logout":
                try {
                    logout(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    login(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                //sign up metode
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                Manager manager = new Manager(username, password);
                ManagerRepository managerRepository = new ManagerRepository();
                managerRepository.newManager(manager);
                //create session
                
                response.sendRedirect("jsp page where the manager will be displayed");
    }
    private void login(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ManagerRepository managerRepository = new ManagerRepository();
        boolean isExist = managerRepository.isExist(username);
        if(isExist) {

            Manager manager = managerRepository.login(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("redirect him to rooms page");
        } else {
            response.sendRedirect("keep him on login page");
        }
    }
    private void logout(HttpServletRequest request, HttpServletResponse response)  throws Exception{
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("redirect him to login page");
    }

    
}
