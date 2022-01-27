package com.aigulsharip.java_ee.lecture5.servlets;

import com.aigulsharip.java_ee.lecture5.db.DBManagerUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/checkLogin")
public class CheckLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {



    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (DBManagerUser.checkUser(email, password)) {
            request.getRequestDispatcher("success.jsp").forward(request,response);

        } else {
            request.getRequestDispatcher("user_not_found.jsp").forward(request, response);
        }



    }

}


