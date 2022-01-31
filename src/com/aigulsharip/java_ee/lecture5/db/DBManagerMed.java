package com.aigulsharip.java_ee.lecture5.db;

import java.sql.*;
import java.util.ArrayList;

public class DBManagerMed {

    public static Connection connection;

    static {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/neoclinic", "postgres", "postgres");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Medication> getAllMedications () {
        ArrayList<Medication> meds = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT med.id, med.name, med.dosage, mf.form_id, mf.form_name, med.price, med.quantity " +
                    "FROM medications as med " +
                    "INNER JOIN medication_form as mf on mf.form_id = med.form_id");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Medication med = new Medication();

                med.setId(resultSet.getLong("id"));
                med.setName(resultSet.getString("name"));
                med.setDosage(resultSet.getString("dosage"));
                med.setMedicationForm(
                        new MedicationForm(resultSet.getLong("form_id"),
                                           resultSet.getString ("form_name")));
                med.setPrice(resultSet.getInt("price"));
                med.setQuantity(resultSet.getInt("quantity"));
                meds.add(med);
            }
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return meds;
    }


    public static void addMedication(Medication medication) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("INSERT INTO medications (name, dosage, form_id, price, quantity) VALUES (?, ?, ?, ?, ?)");


        statement.setString(1, medication.getName());
        statement.setString(2, medication.getDosage());
        statement.setLong(3, medication.getMedicationForm().getId());
        statement.setInt(4, medication.getPrice());
        statement.setInt(5, medication.getQuantity());


        statement.execute();
        statement.close();

    }

    public static Medication getMedication(Long id) {

        Medication medication = null;
        String medicationId = null;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT med.id, med.name, med.dosage, mf.form_id, mf.form_name, med.price, med.quantity " +
                    "FROM medications as med " +
                    "INNER JOIN medication_form as mf on mf.form_id = med.form_id " +
                    "WHERE med.id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                medication = new Medication();
                medication.setId(resultSet.getLong("id"));
                medication.setName(resultSet.getString("name"));
                medication.setDosage( resultSet.getString("dosage"));
                medication.setMedicationForm(
                        new MedicationForm(resultSet.getLong("form_id"), resultSet.getString ("form_name")));
                medication.setPrice(resultSet.getInt("price"));
                medication.setQuantity(resultSet.getInt("quantity"));


            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medication;
    }


    public static int updateMedication (Medication medication) {
        int result = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE medications SET name =?, dosage = ?,form_id = ?, price = ?, quantity = ? WHERE id = ?");
            statement.setString(1, medication.getName());
            statement.setString(2, medication.getDosage());
            statement.setLong(3, medication.getMedicationForm().getId());
            statement.setInt(4, medication.getPrice());
            statement.setInt(5, medication.getQuantity());

            statement.setLong(6, medication.getId());

            result = statement.executeUpdate();
            statement.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static int deleteMedication (Long id) {

        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM medications WHERE id = ?");
            statement.setLong(1, id);
            result = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;




    }



}
