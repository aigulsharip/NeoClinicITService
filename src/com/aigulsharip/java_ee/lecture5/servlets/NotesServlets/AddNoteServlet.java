package com.aigulsharip.java_ee.lecture5.servlets.NotesServlets;


import com.aigulsharip.java_ee.lecture5.db.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/addNote")
public class AddNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User currentUser = (User) request.getSession().getAttribute("current_user");

        if (currentUser != null) {

            if (currentUser.getUserRole() == UserRoles.ROLE_ADMIN) {

                request.getRequestDispatcher("addNote.jsp").forward(request, response);
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

        if (currentUser != null ) {

            if (currentUser.getUserRole() == UserRoles.ROLE_ADMIN) {
                String patientName = request.getParameter("patient_name");
                String noteType = request.getParameter("note_type");
                String content = request.getParameter("content");

                Note note = new Note();
                note.setPatientName(patientName);
                note.setNoteType(noteType);
                note.setContent(content);
                note.setDoctor(currentUser);
                DBManagerNote.addNote(note);
                response.sendRedirect("/notes");
            } else {
                response.sendRedirect("/notes");
            }
        }
        else {
            response.sendRedirect("/signin");
        }
    }
}
