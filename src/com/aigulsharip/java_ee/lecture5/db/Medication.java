package com.aigulsharip.java_ee.lecture5.db;

public class Medication {
    private Long id;
    private String name;
    private String dosage;
    private String form;
    private int price;
    private int quantity;

    public Medication () {}

    public Medication(Long id, String name, String dosage, String form, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.form = form;
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

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
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

