package com.aigulsharip.java_ee.lecture5.servlets;


import com.aigulsharip.java_ee.lecture5.db.DBManagerMed;
import com.aigulsharip.java_ee.lecture5.db.DBManagerMedForm;
import com.aigulsharip.java_ee.lecture5.db.Medication;
import com.aigulsharip.java_ee.lecture5.db.MedicationForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/readMedication")
public class ReadMedicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        Long medicationId = null;
        Medication medication = null;

        try {
            medicationId = Long.parseLong(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (medicationId != null) {
            medication = DBManagerMed.getMedication(medicationId);
        }

        if (medication != null) {
            request.setAttribute("medication", medication);
            ArrayList<MedicationForm> medicationForms = DBManagerMedForm.getAllMedForms();
            request.setAttribute("medicationForms", medicationForms);
            request.getRequestDispatcher("/readMedication.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String redirect = "/";
        String id = request.getParameter("id");
        Long medicationId = null;
        Medication medication = null;

        try {
            medicationId = Long.parseLong(id);
        } catch (Exception e ) {
            e.printStackTrace();
        }

        if (medicationId != null) {
            medication = DBManagerMed.getMedication(medicationId);

            if (medication != null) {
                String name = request.getParameter("name");
                String dosage = request.getParameter("dosage");
                Long form_id = Long.valueOf(request.getParameter("form"));
                int price = Integer.parseInt(request.getParameter("price"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));

                MedicationForm medicationForm = DBManagerMedForm.getMedicationForm(form_id);
                medication.setName(name);
                medication.setDosage(dosage);
                medication.setMedicationForm(medicationForm);
                medication.setPrice(price);
                medication.setQuantity(quantity);


                if (DBManagerMed.updateMedication(medication) > 0) {
                    redirect = "/readMedication?id=" + medicationId;
                }


            }

        }

        response.sendRedirect(redirect);





    }

}
