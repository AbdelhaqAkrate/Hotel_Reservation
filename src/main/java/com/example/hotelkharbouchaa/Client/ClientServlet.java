package com.example.hotelkharbouchaa.Client;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "ClientServlet", urlPatterns = "/myreservation")
public class ClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        // RequestDispatcher requestDispatcher = req.getRequestDispatcher("pg.jsp");
        // String data = "hello me !!";
        // req.setAttribute("mssg", data);
        // requestDispatcher.forward(req,resp);
        //change page if url changed 
        String path = req.getServletPath();
        switch(path)
        {
            case "/":
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("pg.jsp");
                requestDispatcher.forward(req,resp);
                break;
            case "/rooms":
                RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("./src/User/roomAndSuites.jsp");
                requestDispatcher1.forward(req,resp);
                break;
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doDelete(req, resp);
    }
}
