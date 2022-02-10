package com.aigulsharip.java_ee.lecture5.servlets.PatientsServlets;


import com.aigulsharip.java_ee.lecture5.db.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/addPatient")
public class AddPatientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User currentUser = (User) request.getSession().getAttribute("current_user");

        if (currentUser != null) {

            if (currentUser.getUserRole() == UserRoles.ROLE_ADMIN) {

                request.getRequestDispatcher("addPatient.jsp").forward(request, response);
            } else {
                response.sendRedirect("/403.jsp");
            }

        } else {
            response.sendRedirect("/signin");
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User currentUser = (User) request.getSession().getAttribute("current_user");

        if (currentUser != null) {

            if (currentUser.getUserRole() == UserRoles.ROLE_ADMIN) {

                String fullName = request.getParameter("full_name");
                Date birthDate = Date.valueOf(request.getParameter("birthdate"));
                String gender = request.getParameter("gender");
                String email = request.getParameter("email");
                String city = request.getParameter("city");

                Patient patient = new Patient();
                patient.setFullName(fullName);
                patient.setBirthDate(birthDate);
                patient.setEmail(email);
                patient.setGender(gender);
                patient.setCity(city);

                DBManagerPatient.addPatient(patient);
                response.sendRedirect("/patients.jsp");

                } else {
                    response.sendRedirect("/patients.jsp");
                }
            } else {
                response.sendRedirect("/signin");
            }
        }
    }

