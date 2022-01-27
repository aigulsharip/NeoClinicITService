package com.aigulsharip.java_ee.lecture5.servlets;


import com.aigulsharip.java_ee.lecture5.db.DBManagerMed;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteMedication")
public class DeleteMedicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String redirect = "/";

        String id = request.getParameter("id");
        Long medicationId = null;

        try {
            medicationId = Long.parseLong(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (medicationId != null) {
            DBManagerMed.deleteMedication(medicationId);

        }

        response.sendRedirect(redirect);

    }

}

