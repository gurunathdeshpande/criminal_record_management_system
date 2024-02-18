package com.criminal_record_management.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.criminal_record_management.dao.FirDAO;
import com.criminal_record_management.entities.Message;
import com.criminal_record_management.helper.ConnectionProvider;

public class DeleteFirServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        
        int delId = Integer.parseInt(req.getParameter("firid"));
        FirDAO firDao = new FirDAO(ConnectionProvider.getConnection());
        String firId = String.valueOf(delId);
        
        firDao.deleteFIR(firId);
        
        HttpSession session = req.getSession();
        Message m = new Message("FIR Deleted Successfully", "success", "danger");
        session.setAttribute("msg", m);
        res.sendRedirect("fir.jsp");
    }
}
