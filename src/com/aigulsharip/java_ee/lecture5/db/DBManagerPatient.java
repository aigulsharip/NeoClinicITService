package com.aigulsharip.java_ee.lecture5.db;

import java.sql.*;
import java.util.ArrayList;

public class DBManagerPatient {
    public static Connection connection;

    static {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/neoclinic", "postgres", "postgres");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addPatient(Patient patient) {

        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO patients (full_name, birthdate, gender, email, city) " +
                    "VALUES (?, ?, ?, ?, ?)");

            statement.setString(1, patient.getFullName());
            statement.setDate(2, patient.getBirthDate());
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getEmail());
            statement.setString(5, patient.getCity());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Patient> getAllPatients() {
        ArrayList<Patient> patients = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM patients ");


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                patients.add (new Patient(
                        resultSet.getLong("id"),
                        resultSet.getString("full_name"),
                        resultSet.getDate("birthdate"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("city"), null));
            }
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


        return patients;

    }


    public static Patient getPatient (Long id) {

        Patient patient = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM patients WHERE id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                patient = new Patient(
                        resultSet.getLong("id"),
                        resultSet.getString("full_name"),
                        resultSet.getDate("birthdate"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("city"),
                        null);

            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return patient;

    }

    public static int updatePatient(Patient patient) {
        int result = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE patients SET full_name =?, birthdate = ?,gender = ?, email = ?, city = ? WHERE id = ?");
            statement.setString(1, patient.getFullName());
            statement.setDate(2, patient.getBirthDate());
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getEmail());
            statement.setString(5, patient.getCity());
            statement.setLong(6, patient.getId());


            result = statement.executeUpdate();
            statement.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }




    public static ArrayList<Medication> getAllMedicationByPatientId(Long id) {
        ArrayList<Medication> medications = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT m.id, m.name, m.dosage, m.form_id, m.price, m.quantity FROM patient_medication pm " +
                    "INNER JOIN medications m on m.id = pm.medication_id " +
                    "INNER JOIN patients p on p.id = pm.patient_id " +
                    "WHERE pm.patient_id = ? ");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Medication med = new Medication();

                med.setId(resultSet.getLong("id"));
                med.setName(resultSet.getString("name"));
                med.setDosage(resultSet.getString("dosage"));
                med.setMedicationForm(
                        new MedicationForm(resultSet.getLong("form_id"),
                                null));
                med.setPrice(resultSet.getInt("price"));
                med.setQuantity(resultSet.getInt("quantity"));
                medications.add(med);

            }
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return medications;
    }


}
