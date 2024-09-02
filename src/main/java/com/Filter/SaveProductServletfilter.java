package com.Filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;

@WebFilter("/SaveProductServlet")
public class SaveProductServletfilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("SaveProductServletfilter::init()");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
			boolean isError = false;
		String productName = request.getParameter("productName");
        String priceStr = request.getParameter("price");
        String category = request.getParameter("category");
        String qtyStr = request.getParameter("qty");
        if (productName == null || productName.trim().length() == 0) {
           isError = true;
        	request.setAttribute("productnameerror", "pleae enter the product name");
        }
        if (priceStr == null ||priceStr.trim().length() == 0) {
        	isError = true;
        	request.setAttribute("priceError","please enter the price");
        }
        if (category == null || category.trim().length() == 0) {
        	isError = true;
        	request.setAttribute("categoryError", "please enter the category");
        }
        if (qtyStr == null || qtyStr.trim().length() == 0) {
        	isError = true;
        	request.setAttribute("qtyError","please enter the qty");
        }

//        try {
//            // Check if price and qty are valid integers
//            int price = Integer.parseInt(priceStr);
//            int qty = Integer.parseInt(qtyStr);
//
//  
////            request.setAttribute("priceError","please enter the price");
////	            request.setAttribute("qtyError","please enter the qty");
//
//        } catch (NumberFormatException e) {
//        	 isError = true;
//             request.setAttribute("numberFormatError", "Price and Quantity must be valid numbers.");
//        }
        if (isError == true) {
			// back
			request.getRequestDispatcher("InputProduct.jsp").forward(request, response);
		} else {
			// forward
			chain.doFilter(request, response);
		}
		
	}
	@Override
	public void destroy() {
		System.out.println("SaveProductServletfilter::destory()");
	}
}
