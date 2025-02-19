package com.criminal_record_management.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.criminal_record_management.dao.FirDAO;
import com.criminal_record_management.entities.FIR;
import com.criminal_record_management.entities.Message;
import com.criminal_record_management.helper.ConnectionProvider;

public class UpdateFirServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        // Check if txtfirId parameter is not null before parsing it
        String txtFirIdParam = req.getParameter("txtFirId");
        if (txtFirIdParam == null || txtFirIdParam.isEmpty()) {
            // Handle the case where the parameter is null or empty
            out.println("FIR ID parameter is missing or empty.");
            return;
        }
        
        int firId = Integer.parseInt(txtFirIdParam);
        String dateOfFir = req.getParameter("date");
        String complainantName = req.getParameter("complainant-name");
        String policeName = req.getParameter("police-name");
        String incidentDate = req.getParameter("incident-date");
        String incidentTime = req.getParameter("incident-time");
        String location = req.getParameter("location");
        String incidentDescription = req.getParameter("incident-description");
        String accusedDetails = req.getParameter("accused-details");

        FIR fir = new FIR(firId, dateOfFir, complainantName, policeName, incidentDate, incidentTime, location, incidentDescription, accusedDetails);
        FirDAO firDao = new FirDAO(ConnectionProvider.getConnection());
        firDao.updateFIR(fir);

        HttpSession session = req.getSession();
        Message m = new Message("FIR data updated successfully!", "success", "success");
        session.setAttribute("msg", m);

        // Redirect to the fir.jsp page
        res.sendRedirect("fir.jsp");
        out.println("Data updated successfully!");
    }
}
