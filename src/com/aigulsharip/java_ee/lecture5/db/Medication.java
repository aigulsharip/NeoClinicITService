package com.aigulsharip.java_ee.lecture5.db;

public class Medication {
    private Long id;
    private String name;
    private String dosage;
    private MedicationForm medicationForm;
    private int price;
    private int quantity;

    public Medication () {}

    public Medication(Long id, String name, String dosage, MedicationForm medicationForm, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.medicationForm = medicationForm;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public MedicationForm getMedicationForm() {
        return medicationForm;
    }

    public void setMedicationForm(MedicationForm medicationForm) {
        this.medicationForm = medicationForm;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

