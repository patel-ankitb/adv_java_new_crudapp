package com.Filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/EmployeeRegistrationServlet")
public class EmployeeRegistrationFilter2 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EmployeeRegistrationFilter2");
		String firstName = request.getParameter("firstName");

		// firstName => a-z A-Z -> regex

		String alphaRegEx = "[a-zA-Z]+";

		boolean isError = false;
		if (firstName.matches(alphaRegEx) == false) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter valid FirstName");
		}

		if (isError == true) {
			request.getRequestDispatcher("EmployeeRegistration.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
		
	}
	public void destroy() {

	}
}
