package com.aigulsharip.java_ee.lecture5.servlets;


import com.aigulsharip.java_ee.lecture5.db.DBManagerMed;
import com.aigulsharip.java_ee.lecture5.db.DBManagerUser;
import com.aigulsharip.java_ee.lecture5.db.Medication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/loginPage")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("loginPage.jsp").forward(request,response);

        /*
        String email = request.getParameter("email");
        String password = request.getParameter("password");



        if (DBManagerUser.checkUser(email, password)) {
            request.getRequestDispatcher("success.jps");

        }
        else {
            request.getRequestDispatcher("user_not_found.jps");
        }

         */



    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");



        if (DBManagerUser.checkUser(email, password)) {
            request.getRequestDispatcher("success.jsp");
        }
        else {
            request.getRequestDispatcher("user_not_found.jsp");
        }



    }

}
