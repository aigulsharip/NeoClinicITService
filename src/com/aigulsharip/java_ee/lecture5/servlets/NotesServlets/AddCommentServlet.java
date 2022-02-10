package com.aigulsharip.java_ee.lecture5.servlets.NotesServlets;


import com.aigulsharip.java_ee.lecture5.db.Comment;
import com.aigulsharip.java_ee.lecture5.db.DBManagerNote;
import com.aigulsharip.java_ee.lecture5.db.Note;
import com.aigulsharip.java_ee.lecture5.db.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addComment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User currentUser = (User) request.getSession().getAttribute("current_user");

        if (currentUser != null ) {

            request.setCharacterEncoding("UTF8");

            String comment = request.getParameter("comment");
            Long note_id = Long.parseLong(request.getParameter("note_id"));

            Note note = DBManagerNote.getNote(note_id);

            if (note != null) {

                Comment comment1 = new Comment();

                comment1.setAuthor(currentUser);
                comment1.setNote(note);
                comment1.setCommment(comment);

                DBManagerNote.addComment(comment1);

                response.sendRedirect("/readNote?id="+note.getId());


            } else {
                response.sendRedirect("/notes");
            }

        }
        else {
            response.sendRedirect("/signin");
        }
    }

}
