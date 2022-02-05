package com.aigulsharip.java_ee.lecture5.servlets.MedicationServlets;

import com.aigulsharip.java_ee.lecture5.db.DBManagerMed;
import com.aigulsharip.java_ee.lecture5.db.Medication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet (value = "/medications")
public class MedicationsServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Medication> medications = DBManagerMed.getAllMedications();
        request.setAttribute("medications", medications);

        request.getRequestDispatcher("/medications.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {


    }



}



