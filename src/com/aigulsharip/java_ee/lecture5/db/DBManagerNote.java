package com.aigulsharip.java_ee.lecture5.db;

import java.sql.*;
import java.util.ArrayList;

public class DBManagerNote {
    public static Connection connection;

    static {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/neoclinic", "postgres", "postgres");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addNote(Note note) {

        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO doctor_notes (note_type, doctor_id, patient_name, content, visit_time) " +
                    "VALUES (?, ?, ?, ?, now())");


            statement.setString(1, note.getNoteType());
            statement.setLong(2, note.getDoctor().getId());
            statement.setString(3, note.getPatientName());
            statement.setString(4, note.getContent());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Note> getAllNotes() {
        ArrayList<Note> notes = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT n.id, users.id, n.note_type, n.doctor_id, users.full_name, n.patient_name, n.content, n.visit_time " +
                    "FROM doctor_notes as n " +
                    "INNER JOIN users on users.id = n.doctor_id ");


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                notes.add (new Note(
                        resultSet.getLong("id"),
                        resultSet.getString("note_type"),
                        new User(resultSet.getLong("doctor_id"), null, null, resultSet.getString("full_name"), null),
                        resultSet.getString("patient_name"),
                        resultSet.getString("content"),
                        resultSet.getTimestamp( "visit_time")
                ));
            }
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


        return notes;

    }


    public static Note getNote (Long id) {

        Note note = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT n.id, users.id, n.note_type, n.doctor_id, users.full_name, n.patient_name, n.content, n.visit_time " +
                    "FROM doctor_notes as n " +
                    "INNER JOIN users on users.id = n.doctor_id " +
                    "WHERE n.id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                note = new Note(
                        resultSet.getLong("id"),
                        resultSet.getString("note_type"),
                        new User (resultSet.getLong("doctor_id"), null, null, resultSet.getString("full_name"),null),
                        resultSet.getString("patient_name"),
                        resultSet.getString("content"),
                        resultSet.getTimestamp( "visit_time")

                );
            }


            statement.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return note;

    }





}
