package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyCookieServlet extends HttpServlet {
	private static final long serialVersionUID =1L;
	
	public void doGet(HttpServletResponse response,HttpServletRequest request) throws IOException {
		response.setContentType("html/text");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String btn=request.getParameter("btn");
		
		switch(btn){
		
		case "add"->{
			String val=request.getParameter("val");
			Cookie c=new Cookie(name,val);
			response.addCookie(c);
			out.println("<h1>Cookie added</h1>");
		}
		
		case "delete"->{
			Cookie[] carr=request.getCookies();
			for(Cookie c :carr) {
				if(c.getName().equals(name)) {
					//delete the cookie
					c.setMaxAge(0);
					response.addCookie(c);
					out.println("<h3>Cookie deleted "+name+"</h3>");
					break;
					
				}
			}
		}
		
		case "display"->{
			Cookie[] carr=request.getCookies();
			for(Cookie c :carr) {
				out.println("name : "+c.getName()+"---->"+"Value : "+c.getValue());
		}
			
			
		}
			
		
		
		}
	}
}



