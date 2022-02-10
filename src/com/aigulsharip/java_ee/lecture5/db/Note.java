package com.aigulsharip.java_ee.lecture5.db;

import java.sql.Timestamp;

public class Note {

    private Long id;
    private String noteType;
    private User doctor;
    private String patientName;
    private String content;
    private Timestamp visitTime;
    private int likes;

    public Note(Long id, String noteType, User doctor, String patientName, String content, Timestamp visitTime, int likes) {
        this.id = id;
        this.noteType = noteType;
        this.doctor = doctor;
        this.patientName = patientName;
        this.content = content;
        this.visitTime = visitTime;
        this.likes = likes;
    }

    public Note() {
    }

    public Note(Long id, String noteType, User doctor, String patientName, String content, Timestamp visitTime) {
        this.id = id;
        this.noteType = noteType;
        this.doctor = doctor;
        this.patientName = patientName;
        this.content = content;
        this.visitTime = visitTime;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Timestamp visitTime) {
        this.visitTime = visitTime;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
