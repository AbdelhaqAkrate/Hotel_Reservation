package com.example.hotelkharbouchaa.Routes;
import com.example.hotelkharbouchaa.Manager.*;
import com.example.hotelkharbouchaa.Room.RoomService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RoutesServlet", urlPatterns = "/")
public class RoutesServlet extends HttpServlet {
    private ManagerService managerService = new ManagerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomService roomService = new RoomService();
        String path = req.getServletPath();
        HttpSession session = req.getSession();
        RequestDispatcher requestDispatcher;
        switch(path)
        {
            
            case "/":
                 requestDispatcher = req.getRequestDispatcher("pg.jsp");
                requestDispatcher.forward(req,resp);
                break;
            case "/rooms":
                requestDispatcher = req.getRequestDispatcher("./src/User/roomAndSuites.jsp");
                requestDispatcher.forward(req,resp);
                break;
            case "/client" :
                try {
                    managerService.listClients(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/newRoom" :
                if(session.getAttribute("idAdmin") != null)
                {try{
                    managerService.newRoom(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }}
                else
                {
                    resp.sendRedirect("/admin");
                }
                break;
            case "/single":
            roomService.getAllRoomsByType(1,req,resp);
            break;
            case "/double":
            roomService.getAllRoomsByType(2,req,resp);
            break;
            case "/triple":
            roomService.getAllRoomsByType(3,req,resp);
            break;
            case "/suites":
            roomService.getAllRoomsByType(4,req,resp);
            break;
            
        }

    }
    

}
