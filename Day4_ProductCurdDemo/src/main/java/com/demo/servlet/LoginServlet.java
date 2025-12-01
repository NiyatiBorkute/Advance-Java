package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		LoginService lservice=new LoginServiceImpl();
		MyUser user=lservice.validateUSer(uname,pass);
		if(user!=null) {
			out.print("<h1>valid user</h1>");
		}else {
			out.print("<h1>Invalid credentials</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			
		}
		
	}

}
