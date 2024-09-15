package com.servlets;
import java.sql.*;
public class SqlConnection {
	public static Connection getConnection() {
		Connection conn=null;
		try {
			String url="jdbc:mysql://localhost:3306/book";
			String user="root";
			String password="shubham@123";
			conn=DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}
