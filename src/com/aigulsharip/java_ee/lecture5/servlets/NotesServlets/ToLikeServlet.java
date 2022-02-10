package com.aigulsharip.java_ee.lecture5.servlets.NotesServlets;


import com.aigulsharip.java_ee.lecture5.db.DBManagerNote;
import com.aigulsharip.java_ee.lecture5.db.Note;
import com.aigulsharip.java_ee.lecture5.db.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/toLike")
public class ToLikeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User currentUser = (User) request.getSession().getAttribute("current_user");

        if (currentUser != null) {

            Long noteId = Long.parseLong(request.getParameter("note_id"));

            Note note = DBManagerNote.getNote(noteId);

            if(note!=null) {

                DBManagerNote.ToLike(note, currentUser);
                response.sendRedirect("/readNote?id="+note.getId());

            }else{

                response.sendRedirect("/notes");

            }


        }else{

            response.sendRedirect("/signin");

        }

    }

}
