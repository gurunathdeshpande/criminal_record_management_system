package com.criminal_record_management.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.criminal_record_management.dao.CrimeDAO;
import com.criminal_record_management.helper.ConnectionProvider;
import com.criminal_record_management.entities.Crime;
import com.criminal_record_management.entities.Message;

public class CrimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests here if needed
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests here
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Retrieve crime details from the form
        String date = request.getParameter("date");
        String location = request.getParameter("location");
        String type = request.getParameter("crime-type");
        String description = request.getParameter("description");
        String peopleInvolved = request.getParameter("people-involved");
        String status = request.getParameter("status");

        // Create a Crime object with the retrieved details
        Crime crime = new Crime(date, location, type, description, peopleInvolved, status);

        // Instantiate a CrimeDao object
        CrimeDAO crimeDao = new CrimeDAO(ConnectionProvider.getConnection());

        // Insert the crime details into the database
        crimeDao.addCrime(crime);

        // Set message in session
        HttpSession session = request.getSession();
        Message m = new Message("Data Saved Successfully!", "success", "success");
        session.setAttribute("msg", m);

        // Redirect to the crime.jsp page
        response.sendRedirect("crimes.jsp");
    }
}
