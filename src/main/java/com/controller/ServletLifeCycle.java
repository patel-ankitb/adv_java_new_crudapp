package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletLifeCycle")		
public class ServletLifeCycle extends HttpServlet{

	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet::init()");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Servlet::service()");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet::destroy()");
	}
}
