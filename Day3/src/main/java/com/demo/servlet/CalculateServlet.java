package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("Text/html");
		PrintWriter out= response.getWriter();
		String btn=request.getParameter("btn");
		int num1= Integer.parseInt(request.getParameter("num1"));
		
		switch(btn) {
		case "add"->{
			int num2= Integer.parseInt(request.getParameter("num2"));
			int ans=num1+num2;
			out.println("<h2>addition is "+ans+"</h2>");
		}
		case "sub"->{
			int num2= Integer.parseInt(request.getParameter("num2"));
			int ans=num1-num2;
			out.println("<h2>subtraction is "+ans+"</h2>");
		}
		case "fact"->{
			int ans=factorial(num1);
			out.println("<h2>Factorial is: "+ans+"</h2>");
		}
		}
		
		
		
		

}

	private int factorial(int num1) {
		int fact=1;
		for(int i=1;i<=num1;i++) {
			fact=fact*i;
		}
		return fact;
	}
}