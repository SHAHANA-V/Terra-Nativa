package com.terranativa.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class confirmationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Thank you for booking!</h2>");
    }
}

