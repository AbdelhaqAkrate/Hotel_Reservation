package com.example.hotelkharbouchaa.Manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.example.hotelkharbouchaa.Client.*;
import com.example.hotelkharbouchaa.Room.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import static java.lang.System.out;

public class ManagerService {
    private ClientRepository clientRepository = new ClientRepository();
    private RoomRepository roomRepository = new RoomRepository();
     public void showNewRoomPage(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("src/Manager/NewRoom.jsp");
        dispatcher.forward(request, response);
    }
       public void listClients(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Client > listClients = clientRepository.getAllClients();
        request.setAttribute("listClients", listClients);

        RequestDispatcher dispatcher = request.getRequestDispatcher("src/Manager/ListClient.jsp");
        dispatcher.forward(request, response);
           out.println(Arrays.toString(listClients.toArray()));
    }
    public void newRoom(HttpServletRequest request, HttpServletResponse response)
   throws SQLException, IOException, ServletException {
        List<Type> types = roomRepository.getTypes();
        System.out.println("hello");
        request.setAttribute("types", types);
        for(Type type : types) {
            System.out.println("type: " + type.getName());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("src/Manager/NewRoom.jsp");
        dispatcher.forward(request, response);
    }
}
