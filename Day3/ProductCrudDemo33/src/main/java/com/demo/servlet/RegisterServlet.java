package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.MyUser;
import com.demo.service.RegisterService;
import com.demo.service.RegisterServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String uname = request.getParameter("uname");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String gender = request.getParameter("gender");
        String[] hobbiesArr = request.getParameterValues("hobbies");
        String hobbies = (hobbiesArr != null) ? String.join(",", hobbiesArr) : "";
        String city = request.getParameter("city");

        MyUser user = new MyUser(uname, email, "customer", gender, hobbies, city);
        RegisterService rservice = new RegisterServiceImpl();
        boolean status = rservice.register(user, pass);

        if (status) {
            out.print("<h1>Registration Successful!</h1>");
            RequestDispatcher rd = request.getRequestDispatcher("Login.html");
            rd.include(request, response);
        } else {
            out.print("<h1>Registration Failed!</h1>");
            RequestDispatcher rd = request.getRequestDispatcher("Register.html");
            rd.include(request, response);
        }
    }
}
