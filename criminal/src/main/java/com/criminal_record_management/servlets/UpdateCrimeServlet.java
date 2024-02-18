package com.criminal_record_management.servlets;

import com.criminal_record_management.dao.CrimeDAO;
import com.criminal_record_management.entities.Crime;
import com.criminal_record_management.entities.Message;
import com.criminal_record_management.helper.ConnectionProvider;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateCrimeServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            int crimeId = Integer.parseInt(req.getParameter("txtcrmId"));
            String crimeDate = req.getParameter("date");
            String crimeLocation = req.getParameter("location");
            String crimeType = req.getParameter("crime-type");
            String crimeDescription = req.getParameter("description");
            String crimePeopleInvolved = req.getParameter("people-involved");
            String crimeStatus = req.getParameter("status");

            Crime crm = new Crime(crimeId, crimeDate, crimeLocation, crimeType, crimeDescription, crimePeopleInvolved, crimeStatus);
            CrimeDAO edao = new CrimeDAO(ConnectionProvider.getConnection());
            edao.updatecrime(crm);

            HttpSession session = req.getSession();
            Message m = new Message("Data updated Successfully!", "success", "success");
            session.setAttribute("msg", m);

            // Redirect to the crimes.jsp page
            res.sendRedirect("crimes.jsp");
        } catch (NumberFormatException e) {
            // Handle invalid integer input
            out.println("Invalid crime ID provided.");
        } catch (Exception e) {
            // Handle other unexpected exceptions
            out.println("An error occurred while updating crime data.");
            e.printStackTrace();
        }
    }
}
