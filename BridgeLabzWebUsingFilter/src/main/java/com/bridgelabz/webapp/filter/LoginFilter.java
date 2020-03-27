package com.bridgelabz.webapp.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter extends HttpServlet {
private static final long serialVersionUID=1L;
public void destroy() {
	
}
public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws  
IOException, ServletException{
HttpServletRequest req=(HttpServletRequest) request;
HttpSession session=req.getSession();
if(session.getAttribute("userAtr")==null && 
!req.getRequestURI().endsWith("loginRegister"))
	req.getRequestDispatcher("login.jsp").forward(request, response);
else
	chain.doFilter(request, response);

}
public void init(FilterConfig fConfig) throws ServletException{
	
}
}
