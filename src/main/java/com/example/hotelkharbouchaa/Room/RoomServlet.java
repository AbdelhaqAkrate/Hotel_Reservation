package com.example.hotelkharbouchaa.Room;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import com.example.hotelkharbouchaa.Image.Image;
import com.example.hotelkharbouchaa.Image.ImageService;

@WebServlet(name = "RoomServlet", value = "/room")
public class RoomServlet extends HttpServlet {

    private RoomRepository roomRepository = new RoomRepository();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomService roomService = new RoomService();
        String action = req.getParameter("action");
        switch(action)
        {
            case "detail":
            int id = Integer.parseInt(req.getParameter("id"));
            roomService.getAllRoomsByType(id,req,resp);
            break;
             
        }
       
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //details?id
        //get id from url
        RoomService roomService = new RoomService();
        ImageService imageService = new ImageService();
        int id = Integer.parseInt(req.getParameter("number"));
        Room room = roomService.getRoom(id);
        System.out.println("room : "+room.getIdR());
        req.setAttribute("room",room);
        try {
            List<Image> images = imageService.getImages(id);
            System.out.println("images : "+images.get(1).getName());
            req.setAttribute("images", images);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("src/User/roomDetail.jsp");
        requestDispatcher.forward(req,resp);

        System.out.println("id : "+id);
    }   
    

    private void deleteRoom(HttpServletRequest req, HttpServletResponse resp) {
        int num = Integer.parseInt(req.getParameter("num"));
        roomRepository.deleteRoom(num);
        try {
            resp.sendRedirect("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void checkRoom(HttpServletRequest req, HttpServletResponse resp) {
        int num = Integer.parseInt(req.getParameter("num"));
        Room room = roomRepository.getRoom(num);
        req.setAttribute("room", room);
        RequestDispatcher dispatcher = req.getRequestDispatcher("src/m");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void getAllRooms(HttpServletRequest req, HttpServletResponse resp) {
        List<Room> rooms = roomRepository.getAllRooms();
        req.setAttribute("rooms", rooms);
        RequestDispatcher dispatcher = req.getRequestDispatcher("./src/User/roomAndSuites.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}