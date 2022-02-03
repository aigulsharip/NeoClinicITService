package com.aigulsharip.java_ee.lecture5.db;

import java.sql.*;

public class DBManagerUser {
    public static Connection connection;

    static {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/neoclinic", "postgres", "postgres");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }


    public static User getUser (String email) {

        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();

                user.setEmail(resultSet.getString("email"));
                user.setId(resultSet.getLong("id"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return user;
    }


    public static boolean checkUser (String email, String password) {

        int result = 0;
        boolean hasUser = false;

        User user = null;
        String medicationId = null;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            statement.setString(1,email);
            statement.setString(2,password);

            //result = statement.executeUpdate();

            ResultSet resultSet = statement.executeQuery();
            hasUser = resultSet.next();

            if (hasUser) {
                System.out.println("User is found");
                System.out.println("email: " + email);
                System.out.println("password: " + password);
            }
            else {
                System.out.println("No user found");
                System.out.println("email: " + email);
                System.out.println("password: " + password);
            }
            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hasUser;
    }


}
