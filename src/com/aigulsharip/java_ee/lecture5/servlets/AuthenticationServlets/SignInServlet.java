package com.aigulsharip.java_ee.lecture5.servlets.AuthenticationServlets;


import com.aigulsharip.java_ee.lecture5.db.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/signin")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String redirect = "/signin?emailerror";
        User user = DBManagerUser.getUser(email);

        if (user != null) {
            redirect = "/signin?passworderror";

            if (user.getPassword().equals(password)) {
                HttpSession session = request.getSession();

                session.setAttribute("current_user", user);
                redirect = "/medications";
            }
        }

        response.sendRedirect(redirect);

    }

}
