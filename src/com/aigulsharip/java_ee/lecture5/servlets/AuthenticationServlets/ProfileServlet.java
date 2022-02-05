package com.aigulsharip.java_ee.lecture5.servlets.AuthenticationServlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/profile.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}
