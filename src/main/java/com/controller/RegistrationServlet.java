package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet{

	
	 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String firstName = request.getParameter("firstName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			PrintWriter out = response.getWriter();

			response.setContentType("text/html");// MIME

			out.print("<h2>Registartion done</h2>");
			out.print("<br>FirstName : " + firstName);
			out.print("<br>Email     : " + email);
			out.print("<br>Password : " + password);
	}
}
