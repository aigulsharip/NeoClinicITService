package com.aigulsharip.java_ee.lecture5.servlets;


import com.aigulsharip.java_ee.lecture5.db.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/addMedication")
public class AddMedicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User currentUser = (User) request.getSession().getAttribute("current_user");

        if (currentUser != null) {

            ArrayList<MedicationForm> medicationForms = DBManagerMedForm.getAllMedForms();
            request.setAttribute("medicationForms", medicationForms);

            request.getRequestDispatcher("addMedication.jsp").forward(request, response);

        } else {
            response.sendRedirect("/signin");
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User currentUser = (User) request.getSession().getAttribute("current_user");

        if (currentUser != null) {
            String name = request.getParameter("name");
            String dosage = request.getParameter("dosage");
            Long form_id = Long.valueOf(request.getParameter("form"));
            Integer price = Integer.parseInt(request.getParameter("price"));
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));

            MedicationForm medicationForm = DBManagerMedForm.getMedicationForm(form_id);
            if (medicationForm != null) {
                Medication medication = new Medication();
                medication.setName(name);
                medication.setDosage(dosage);
                medication.setMedicationForm(medicationForm);
                medication.setPrice(price);
                medication.setQuantity(quantity);
                try {
                    DBManagerMed.addMedication(medication);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                response.sendRedirect("/medications");
            } else {
                response.sendRedirect("/signin");
            }

        }

    }
}
