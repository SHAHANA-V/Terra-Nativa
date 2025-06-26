package com.terranativa.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class bookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Read booking form values
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String roomType = request.getParameter("roomType");
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        String specialRequest = request.getParameter("specialRequest");

        // Calculate booking summary (simple example)
        int days = 1;
        int costPerDay = switch (roomType) {
            case "standard" -> 2000;
            case "deluxe" -> 3000;
            case "suite" -> 4000;
            default -> 1000;
        };
        int totalCost = days * costPerDay;

        // Set attributes to forward to confirmation page
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("roomType", roomType);
        request.setAttribute("checkIn", checkIn);
        request.setAttribute("checkOut", checkOut);
        request.setAttribute("specialRequest", specialRequest);
        request.setAttribute("totalCost", totalCost);

        // Forward to confirmation.jsp (or HTML page)
        RequestDispatcher dispatcher = request.getRequestDispatcher("confirmation.jsp");
        dispatcher.forward(request, response);
    }
}

