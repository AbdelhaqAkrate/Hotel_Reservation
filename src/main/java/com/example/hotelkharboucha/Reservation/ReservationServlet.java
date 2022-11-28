package com.example.hotelkharboucha.Reservation;
import com.Database.DbConnecting.DbConnecting;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ReservationServlet extends HttpServlet {
    ReservationService reservationService = new ReservationService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        String action = req.getParameter("action");
        if(action == null)
        {
            action = "Reservations";
        }
        switch(action)
        {
            case "Reservations":
                reservationService.getAllReservations(req, resp);
                break;
            case "checkReservation":
                reservationService.checkReservation(req, resp);
                
                break;
            default:
                reservationService.getAllReservations(req, resp);
                break;
        }
    }

  
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doDelete(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);
        int idClient = Integer.parseInt(req.getParameter("idClient"));
        int idRoom = Integer.parseInt(req.getParameter("idRoom"));
        String date_debut = req.getParameter("date_debut");
        String date_fin = req.getParameter("date_fin");
        int idExtra = Integer.parseInt(req.getParameter("idExtra"));
        Reservation newReservation = new Reservation(idClient, idRoom, date_debut, date_fin, idExtra);
        ReservationRepository reservationRepository = new ReservationRepository();
        reservationRepository.addReservation(newReservation);
        req.setAttribute("message", "Reservation added successfully");


    }
}
