package com.aigulsharip.java_ee.lecture5.servlets.PatientsServlets;

import com.aigulsharip.java_ee.lecture5.db.DBManagerMed;
import com.aigulsharip.java_ee.lecture5.db.DBManagerPatient;
import com.aigulsharip.java_ee.lecture5.db.Medication;
import com.aigulsharip.java_ee.lecture5.db.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet (value = "/patients")
public class PatientsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Patient> patients = DBManagerPatient.getAllPatients();
        request.setAttribute("patients", patients);

        request.getRequestDispatcher("/patients.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {


    }



}



