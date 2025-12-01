package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateInterest extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Double principle=Double.parseDouble(request.getParameter("principle"));
		Float rate=Float.parseFloat(request.getParameter("rate"));
		int years=Integer.parseInt(request.getParameter("years"));
		Double ans=(principle*rate*years)/100;
		out.println("<h3>Simple Interest is:"+ans+"</h3>");
		
	}

}
