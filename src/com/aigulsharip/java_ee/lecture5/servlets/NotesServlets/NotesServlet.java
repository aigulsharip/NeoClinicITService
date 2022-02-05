package com.aigulsharip.java_ee.lecture5.servlets.NotesServlets;

import com.aigulsharip.java_ee.lecture5.db.DBManagerMed;
import com.aigulsharip.java_ee.lecture5.db.DBManagerNote;
import com.aigulsharip.java_ee.lecture5.db.Medication;
import com.aigulsharip.java_ee.lecture5.db.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet (value = "/notes")
public class NotesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Note> notes = DBManagerNote.getAllNotes();
        request.setAttribute("notes", notes);

        request.getRequestDispatcher("/notes.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {


    }



}



