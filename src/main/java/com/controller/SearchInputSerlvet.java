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

@WebServlet("/SearchInputSerlvet")
public class SearchInputSerlvet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		
		try {
			
			String dbUrl = "jdbc:mysql://localhost:3306/advjava";
			String dbUserName = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			
			PreparedStatement pstmt = con.prepareStatement("select * from products where category = ?");
			pstmt.setString(1,category);
			ResultSet rs = pstmt.executeQuery();
			
			request.setAttribute("rs", rs);
			request.getRequestDispatcher("OutputSerch.jsp").forward(request, response);
//			while(rs.next()) {
//				String productname = rs.getNString("productname");
//				Integer price = rs.getInt("price");
//			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
