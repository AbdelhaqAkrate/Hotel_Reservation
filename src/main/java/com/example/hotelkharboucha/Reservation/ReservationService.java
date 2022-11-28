package com.example.hotelkharboucha.Reservation;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ReservationService extends HttpServlet { 

    public void checkReservation(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        ReservationRepository reservationRepository = new ReservationRepository();
        Reservation reservation = reservationRepository.getClientReservation(id);
        req.setAttribute("reservation", reservation);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp page where the reservation will be displayed");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e)                                                                                                                               {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getAllReservations(HttpServletRequest req, HttpServletResponse resp) {
        ReservationRepository reservationRepository = new ReservationRepository();
        List<Reservation> reservations = reservationRepository.getAllReservation();
        req.setAttribute("reservations", reservations);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp page where the reservations will be displayed");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
