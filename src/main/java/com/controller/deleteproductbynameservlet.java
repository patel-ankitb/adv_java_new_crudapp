package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteproductbynameservlet")
public class deleteproductbynameservlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productname = request.getParameter("productName");
		
		try {
			
			String dbUrl = "jdbc:mysql://localhost:3306/advjava";
			String dbUserName = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			
			PreparedStatement pstmt = con.prepareStatement("delete from products where productName = ?");
			pstmt.setString(1,productname);
			
			int rowsAffected = pstmt.executeUpdate();
			
			request.getRequestDispatcher("ListProductServlet").forward(request, response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
