package com.example.hotelkharbouchaa.Room;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();
    public void getAllRoomsByType(int idType, ServletRequest req, ServletResponse resp) {
        List<Room> rooms = roomRepository.getRoomByType(idType);
        Type type = roomRepository.getRoomType(idType);
        req.setAttribute("roomType", rooms);
        req.setAttribute("type", type);
        RequestDispatcher dispatcher = req.getRequestDispatcher("src/User/roomsAva.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int addRoom(int num, int type, String description, String status, Double price) {
        return roomRepository.addRoom(num, type, description, status, price);
    }
    public Room getRoom(int num) {
        return roomRepository.getRoom(num);
    }
   


    
}
