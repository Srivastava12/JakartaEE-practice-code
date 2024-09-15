package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/InputAndInsert")
public class InputAndInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
	PreparedStatement ps=null;
    public InputAndInsert() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	try {
    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "shubham@123");
    		ps=conn.prepareStatement("insert into books value(?,?,?)");
    		System.out.println("Done");
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        pw.println("<html><body>");
        pw.println("<form action='InputAndInsert' method='post'>");
        pw.println("Enter Book I'D   <input type='text' name='bid'><br>");
        pw.println("Enter Book Name  <input type='text' name='bname'><br>");
        pw.println("Enter Book price <input type='text' name='bprice'><br>");
        pw.println("<input type='submit' name='btn' value='Add'>");
        pw.println("<input type='submit' name='btn' value='Update'>");
        pw.println("</form></body></html>");
    	try {
            if(request.getParameter("btn")!=null) {
        		ps.setInt(1,Integer.parseInt(request.getParameter("bid")));
        		ps.setString(2, request.getParameter("bname"));
        		ps.setInt(3,Integer.parseInt(request.getParameter("bprice")));
        		if(request.getParameter("btn").equals("Add")) {
        			ps.addBatch();
        			pw.println("Added Successfully...!");
        		}
        		else {
        			ps.addBatch();
        			ps.executeBatch();
        			pw.println("Updated Successfully...!");
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
