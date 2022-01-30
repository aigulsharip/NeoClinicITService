package com.aigulsharip.java_ee.lecture5.db;

import java.sql.*;
import java.util.ArrayList;

public class DBManagerMedForm {

    public static Connection connection;

    static {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/neoclinic", "postgres", "postgres");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<MedicationForm> getAllMedForms () {
       ArrayList<MedicationForm> medicationForms = new ArrayList<>();


        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM medication_form");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                medicationForms.add (new MedicationForm(
                        resultSet.getLong("form_id"),
                        resultSet.getString("form_name")

                ));

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicationForms;
    }
    public static MedicationForm getMedicationForm(Long id) {

        MedicationForm medicationForm = null;
        //String medicationId = null;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM medication_form WHERE form_id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                medicationForm = new MedicationForm(
                        resultSet.getLong("form_id"),
                        resultSet.getString("form_name")

                );



            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicationForm;
    }






}
