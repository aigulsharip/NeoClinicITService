package com.aigulsharip.java_ee.lecture5.servlets.AuthenticationServlets;


import com.aigulsharip.java_ee.lecture5.db.DBManagerUser;
import com.aigulsharip.java_ee.lecture5.db.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/signout")
public class SignOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().removeAttribute("current_user");
        response.sendRedirect("/signin");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}
