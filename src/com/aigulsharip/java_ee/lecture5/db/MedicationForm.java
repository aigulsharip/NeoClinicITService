package com.aigulsharip.java_ee.lecture5.db;

public class MedicationForm {
    private Long id;
    private String formName;

    public MedicationForm() {
    }

    public MedicationForm(Long id, String formName) {
        this.id = id;
        this.formName = formName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }


}
