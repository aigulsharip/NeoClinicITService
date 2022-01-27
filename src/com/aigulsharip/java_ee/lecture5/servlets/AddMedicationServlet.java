package com.aigulsharip.java_ee.lecture5.servlets;


import com.aigulsharip.java_ee.lecture5.db.DBManagerMed;
import com.aigulsharip.java_ee.lecture5.db.Medication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/addMedication")
public class AddMedicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("addMedication.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String dosage = request.getParameter("dosage");
        String form = request.getParameter("form");
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));


        Medication medication = new Medication();
        medication.setName(name);
        medication.setDosage(dosage);
        medication.setForm(form);
        medication.setPrice(price);
        medication.setQuantity(quantity);

        try {
            DBManagerMed.addMedication(medication);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/medications");


    }

}
