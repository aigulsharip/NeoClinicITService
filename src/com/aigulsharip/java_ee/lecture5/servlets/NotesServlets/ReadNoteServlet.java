package com.aigulsharip.java_ee.lecture5.servlets.NotesServlets;


import com.aigulsharip.java_ee.lecture5.db.Comment;
import com.aigulsharip.java_ee.lecture5.db.DBManagerNote;
import com.aigulsharip.java_ee.lecture5.db.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/readNote")
public class ReadNoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String noteId = request.getParameter("id");
        Long id = null;

        try {
            id = Long.parseLong(noteId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Note note = null;
        try {
            note = DBManagerNote.getNote(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (note != null) {
            request.setAttribute("note", note);
            ArrayList<Comment> comments = DBManagerNote.getAllCommentsByNoteId(note.getId());
            request.setAttribute("comments", comments);

            request.getRequestDispatcher("/readNote.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {


    }


}
