package com.example.hotelkharbouchaa.Reservation;
import com.example.hotelkharbouchaa.Client.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet (name = "ReservationServlet", urlPatterns = "/reserve")
public class ReservationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("src/User/reservation.jsp");
        requestDispatcher.forward(req,resp);
        String action = req.getParameter("action");
        if(action == null)
        {
            action = "Reservations";
        }
        switch(action)
        {
            case "Reservations":
                getAllReservations(req, resp);
                break;
            case "checkReservation":
                checkReservation(req, resp);
                break;
            default:
                getAllReservations(req, resp);
                break;
        }
    }

    private void checkReservation(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        ReservationRepository reservationRepository = new ReservationRepository();
        Reservation reservation = reservationRepository.getClientReservation(id);
        req.setAttribute("reservation", reservation);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp page where the reservation will be displayed");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void getAllReservations(HttpServletRequest req, HttpServletResponse resp) {
        // get all reservations from the database
        ReservationRepository reservationRepository = new ReservationRepository();
        List<Reservation> reservations = reservationRepository.getAllReservation();
        // add reservations to the request
        req.setAttribute("reservations", reservations);
        // send to the JSP page (view)
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp page where the reservations will be displayed");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doDelete(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientRepository clientRepository = new ClientRepository();
        // get idClient from client package 

        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String adresse = req.getParameter("adresse");
        String email = req.getParameter("email");
        int tel = Integer.parseInt(req.getParameter("tel"));
        String code = nom.substring(0, 4) + prenom.substring(0, 4);
        Client client = new Client(nom, prenom,email, adresse, tel, code);
        int idRoom = Integer.parseInt(req.getParameter("idRoom"));
        String date_debut = req.getParameter("date_debut");
        String date_fin = req.getParameter("date_fin");
        int idExtra = Integer.parseInt(req.getParameter("idExtra"));
        int idClient = clientRepository.addClient(client);
        Reservation newReservation = new Reservation(idClient, idRoom, date_debut, date_fin, idExtra);
        ReservationRepository reservationRepository = new ReservationRepository();
        //here we call mail methode to send the code to the client
        
        reservationRepository.addReservation(newReservation);
        req.setAttribute("message", "Reservation added successfully");
    }
}
