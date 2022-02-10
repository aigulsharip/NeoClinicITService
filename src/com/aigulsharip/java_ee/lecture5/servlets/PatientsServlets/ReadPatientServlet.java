package com.aigulsharip.java_ee.lecture5.servlets.PatientsServlets;


import com.aigulsharip.java_ee.lecture5.db.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(value = "/readPatient")
public class ReadPatientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User currentUser = (User) request.getSession().getAttribute("current_user");

        if (currentUser != null) {

            String id = request.getParameter("id");
            Long patientId = null;
            Patient patient = null;

            try {
                patientId = Long.parseLong(id);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (patientId != null) {
                patient = DBManagerPatient.getPatient(patientId);
            }

            if (patient != null) {
                request.setAttribute("patient", patient);
                ArrayList<Medication> patientMedsList = DBManagerPatient.getAllMedicationByPatientId(patientId);
                request.setAttribute("patientMedsList", patientMedsList);
                request.getRequestDispatcher("/readPatient.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/404.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("/signin");
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User currentUser = (User) request.getSession().getAttribute("current_user");

        if (currentUser != null && currentUser != null && currentUser.getUserRole() == UserRoles.ROLE_ADMIN)  {
            String redirect = "/";
            String id = request.getParameter("id");
            Long patientId = null;
            Patient patient = null;

            try {
                patientId = Long.parseLong(id);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (patientId != null) {
                patient = DBManagerPatient.getPatient(patientId);

                if (patientId != null) {
                    String fullName = request.getParameter("full_name");
                    Date birthdate = Date.valueOf(request.getParameter("birthdate"));
                    String gender = request.getParameter("gender");
                    String email = request.getParameter("email");
                    String city = request.getParameter("city");
                    patient.setFullName(fullName);
                    patient.setBirthDate(birthdate);
                    patient.setGender(gender);
                    patient.setCity(city);
                    patient.setEmail(email);


                    if (DBManagerPatient.updatePatient(patient) > 0) {
                        redirect = "/readPatient?id=" + patientId;
                    }
                }
            }

            response.sendRedirect(redirect);
        } else {
            response.sendRedirect("/signin");
        }

    }

}
