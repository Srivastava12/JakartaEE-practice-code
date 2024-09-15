package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ProcedureRetuen")
public class ProcedureRetuen extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CallableStatement cs=null;
    public void init(){
        try{
            cs=SqlConnection.getConnection().prepareCall("{call addNumber(?,?,?)}");
        }catch(Exception e){
            System.out.println(e);
        }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
         PrintWriter pw=response.getWriter();
         pw.println("<html><body>");
         pw.println("<form action='ProcedureRetuen' method='post'>");
         pw.println("Enter a number <input type='text' name='n1'><br>");
         pw.println("Enter a number <input type='text' name='n2'><br>");
         pw.println("<input type='submit' name='btn' value='add'><br>");
         pw.println("</form></body></html>");
         if(request.getParameter("btn")!=null){
             try{
            cs.setInt(1,Integer.parseInt(request.getParameter("n1")));
            cs.setInt(2,Integer.parseInt(request.getParameter("n2")));
            cs.registerOutParameter(3,Types.INTEGER);
            cs.execute();
            pw.println("Sum is :- "+cs.getInt(3));
            }catch(Exception e){
                System.out.println(e);
            }
         }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
