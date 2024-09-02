package com.Filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class EmployeeRegistrationFilter implements Filter{

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("EmployeeRegistrationFilter::init()");

	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EmployeeRegistrationFilter::doFilter()");

		boolean isError = false;

		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String birthYear = request.getParameter("birthYear");

		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter FirstName");
		}
		if (birthYear == null || birthYear.trim().length() == 0) {
			isError = true;
			request.setAttribute("birthYearError", "Please Enter BirthYear");
		}

		if (isError == true) {
			// back
			request.getRequestDispatcher("EmployeeRegistration.jsp").forward(request, response);
		} else {
			// forward
			chain.doFilter(request, response);
		}
		
	}
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("EmployeeRegistrationFilter::destroy()");

	}
}
