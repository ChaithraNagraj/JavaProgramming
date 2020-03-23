package com.bridgelabz.loginreg.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.loginreg.model.Customer;
import com.bridgelabz.loginreg.repository.CustomerDao;
import com.bridgelabz.loginreg.serviceprovider.CustomerDaoImpl;

//@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginRegister() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao cd=new CustomerDaoImpl();
		String userID=request.getParameter("userID");
		String password=request.getParameter("password");
		String submitType=request.getParameter("submit");
		Customer c=cd.getCustomer(userID, password);
		if(submitType.equals("login")&& c!=null && c.getFirstName()!=null) {
			request.setAttribute("message",c.getFirstName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
		else if(submitType.equals("register")) {
			String name=request.getParameter("first");
			userID=request.getParameter("userID");
			password=request.getParameter("password");
			//c.setPassword(password);
			//c.setUserId(userID);
			c=new Customer(name,userID,password);
			cd.insertCustomer(c);
			HttpSession session=request.getSession();
			session.setAttribute("successmessage","registration done");
			response.sendRedirect("login.jsp");
		}
		else 
		{
			request.setAttribute("message", "data not found");
			request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	}
}
