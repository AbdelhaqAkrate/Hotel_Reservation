package com.example.hotelkharbouchaa.Manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

import com.example.hotelkharbouchaa.Image.*;
import com.example.hotelkharbouchaa.Room.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.MultipartConfig;
import static java.lang.System.out;

@WebServlet(name = "ManagerServlet", urlPatterns = "/dashboard")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)

public class ManagerServlet extends HttpServlet {
    
    private ManagerService managerService = new ManagerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username != null)
      {  
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("src/Manager/dashboard.jsp");
        requestDispatcher.forward(request,response);
    }
    else {
        response.sendRedirect("/admin");
    }
       
  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                RoomService roomService = new RoomService();
                ImageService imageService = new ImageService();
                String action = request.getParameter("action");
                switch(action)
                {
                    case "addRoom" :
                       String description = request.getParameter("description");
                        int type = Integer.parseInt(request.getParameter("type"));
                        Double price = Double.parseDouble(request.getParameter("price"));
                        int num = Integer.parseInt(request.getParameter("num"));
                        String status = request.getParameter("status");
                        Part filePart = request.getPart("file");

                        System.out.println("description : "+description);
                        System.out.println("type : "+type);
                        System.out.println("price : "+price);
                        System.out.println("num : "+num);
                        System.out.println("status : "+status);
                        int id = roomService.addRoom(num,type,description,status,price);
                        System.out.println("id : "+id);
                         for (Part part : request.getParts()) {
                        String fileName = part.getSubmittedFileName();
                        
                        // part.write("C:\\xampp\\htdocs\\pictures\\PromoImages\\" + fileName1);
                        if(fileName != null)
                        {

                            part.write("C:\\xampp\\htdocs\\assets\\imgs\\rooms\\" + fileName);
                            Image image = new Image(fileName,id);
                            try {
                                imageService.saveImage(image);
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                        
                        
                        }

                        break;
                }
                response.sendRedirect(request.getServletPath());
    }
    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ManagerRepository managerRepository = new ManagerRepository();
        boolean isExist = managerRepository.isExist(username);
        if(isExist) {
            //login methode from manager repository
            Manager manager = managerRepository.login(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
           // response.sendRedirect("redirect him to rooms page");
        } else {
           // response.sendRedirect("keep him on login page");
        }
    }
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("/admin");
    }

    
}
