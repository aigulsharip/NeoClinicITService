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
            /*
            if (resultSet.next()) {


                user = new User (
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("fullName"));



            }

             */


            //result = statement.executeUpdate();
            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        //return result;
        return hasUser;




    }


}
