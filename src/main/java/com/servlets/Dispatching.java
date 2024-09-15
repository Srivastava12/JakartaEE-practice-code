package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Dispatching")
public class Dispatching extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String uname="Shubham9576";
		String password="gniot@123";
		RequestDispatcher rd=request.getRequestDispatcher("Home");
		RequestDispatcher rd1=request.getRequestDispatcher("index.html");
		if(request.getParameter("btn")!=null) {
			if(uname.equals(request.getParameter("uname")) && password.equals(request.getParameter("pass")))
				rd.forward(request, response);
			else {
				response.getWriter().println("<h3>USER NAME :- "+request.getParameter("uname")+"</h3>");
				response.getWriter().println("<h3>PASSWORD  :- ###########");
				response.getWriter().println("<h3>not correct !<h3>");
				response.getWriter().println("<h3>Try again.........<h3>");
				rd1.include(request, response);
			}
				
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
