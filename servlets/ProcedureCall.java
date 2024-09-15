package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ProcedureCall")
public class ProcedureCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CallableStatement conn=null;
    public void init() {
    	try {
			conn=SqlConnection.getConnection().prepareCall("{call addRecord(?,?,?)}");
		} catch (Exception e) {
		    System.out.println(e);
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		pw.println("<form action='ProcedureCall' method='post'>");
		pw.println("Enter Book I'D   <input type='text' name='bid'><br>");
        pw.println("Enter Book Name  <input type='text' name='bname'><br>");
        pw.println("Enter Book price <input type='text' name='bprice'><br>");
        pw.println("<input type='submit' name='btn' value='Add'>");
        pw.println("<input type='submit' name='btn' value='Update'>");
        pw.println("</form></body></html>");
        try {
	        if(request.getParameter("btn")!=null) {
	        	conn.setInt(1,Integer.parseInt(request.getParameter("bid")));
	        	conn.setString(2,request.getParameter("bname"));
	        	conn.setInt(3,Integer.parseInt(request.getParameter("bprice")));
	        	conn.addBatch();
	        	if(request.getParameter("btn").equals("Update")) {
	        		conn.executeBatch();
	        		pw.println("Updeted Successfully..........!");
	        	}
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
