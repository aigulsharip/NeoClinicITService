package com.aigulsharip.java_ee.lecture5.db;

import java.sql.Timestamp;

public class Comment {

    private Long id;
    private User author;
    private Note note;
    private String commment;
    private Timestamp postDate;

    public Comment() {
    }

    public Comment(Long id, User author, Note note, String commment, Timestamp postDate) {
        this.id = id;
        this.author = author;
        this.note = note;
        this.commment = commment;
        this.postDate = postDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public String getCommment() {
        return commment;
    }

    public void setCommment(String commment) {
        this.commment = commment;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }
}
