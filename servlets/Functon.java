package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "Function", urlPatterns = { "/Function" })
public class Functon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CallableStatement conn=null;
    public void init() {
    	try {
			conn=SqlConnection.getConnection().prepareCall("{?=call addNumber(?,?)}");
		} catch (Exception e) {
		    System.out.println(e);
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		pw.println("<form action='Function' method='post'>");
		pw.println("Enter a Number  <input type='text' name='n1'><br>");
        pw.println("Enter a Number  <input type='text' name='n2'><br>");
        pw.println("<input type='submit' name='btn' value='Add'>");
        pw.println("</form></body></html>");
        try {
	        if(request.getParameter("btn")!=null) {
	        	int a=Integer.parseInt(request.getParameter("n1"));
	        	int b=Integer.parseInt(request.getParameter("n2"));
	        	conn.setInt(2,a);
	        	conn.setInt(3,b);
	        	conn.registerOutParameter(1, Types.INTEGER);
	        	conn.execute();
	            pw.println(a+"+"+b+"="+(conn.getInt(1)));
	        }
        }catch(Exception e) {
        	System.out.println(e);
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
