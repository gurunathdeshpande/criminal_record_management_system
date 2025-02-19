package com.criminal_record_management.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.criminal_record_management.dao.userDao;
import com.criminal_record_management.helper.ConnectionProvider;
import com.criminal_record_management.entities.Message;
import com.criminal_record_management.entities.Users;


public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("test/html");
		
		String Email = req.getParameter("txtemail");
		String Pass = req.getParameter("txtpassword");
		
		userDao ud = new userDao(ConnectionProvider.getConnection());
		Users user = ud.getUserByEmailPass(Email,Pass);
		
		if(user==null) {
			Message ms = new Message("Sorry no user found !!","error","danger");
			HttpSession s = req.getSession();
			
			s.setAttribute("msg" , ms);
			res.sendRedirect("login.jsp");
		} 
		else {
			HttpSession s = req.getSession();
			
			s.setAttribute("currentUser",user);
			res.sendRedirect("index.jsp");
		}
		
		
		//out.println(Email);
		//out.println(Pass);
		
	}

}  