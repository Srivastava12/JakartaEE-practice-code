package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns= {"/CFGCNTX"},initParams= {
		@WebInitParam(name="name",value="Shubham"),
		@WebInitParam(name="city",value="Greter Noida")
})
public class CFGCNTX extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CFGCNTX() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println(getServletConfig().getInitParameter("name")+"<br>");
		pw.println(getServletConfig().getInitParameter("city"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
