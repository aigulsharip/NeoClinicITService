package com.aigulsharip.java_ee.lecture5.db;

import java.sql.Date;
import java.util.ArrayList;

public class Patient {

    private Long id;
    private String fullName;
    private Date birthDate;
    private String gender;
    private String email;
    private String city;
    private ArrayList<Medication> medicationsList;

    public Patient() {
    }

    public Patient(Long id, String fullName, Date birthDate, String gender, String email, String city, ArrayList<Medication> medicationsList) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.city = city;
        this.medicationsList = medicationsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<Medication> getMedicationsList() {
        return medicationsList;
    }

    public void setMedicationsList(ArrayList<Medication> medicationsList) {
        this.medicationsList = medicationsList;
    }
}
