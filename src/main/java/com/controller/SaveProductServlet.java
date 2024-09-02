	package com.controller;
	
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	
	import jakarta.servlet.RequestDispatcher;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	
	@WebServlet("/SaveProductServlet")
	public class SaveProductServlet extends HttpServlet{
	
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String productname = request.getParameter("productName");
			System.out.println(productname);
			Integer price = Integer.parseInt(request.getParameter("price"));
			String category = request.getParameter("category");
			Integer qty = Integer.parseInt(request.getParameter("qty"));
		
			
			
			// validation
//			
//			RequestDispatcher rd = request.getRequestDispatcher("InputProduct.jsp");
//			rd.forward(request, response);
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root",
						"root");
				PreparedStatement pstmt = conn.prepareStatement("insert into products (productName,price,category,qty) values (?,?,?,?)");
				pstmt.setString(1, productname);
				pstmt.setInt(2,price);
				pstmt.setString(3, category);
				pstmt.setInt(4, qty);
				
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("ListProductServlet").forward(request, response);
		}
	}
	
