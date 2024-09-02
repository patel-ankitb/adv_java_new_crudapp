package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListProductServlet")
public class ListProductServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/advjava";
		String dbUserName = "root";
		String dbPassword = "root";
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		PreparedStatement pstmt = con.prepareStatement("select * from products");
		ResultSet rs = pstmt.executeQuery();
		
		request.setAttribute("rs", rs);
		request.getRequestDispatcher("ListProducts.jsp").forward(request, response);
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
}
