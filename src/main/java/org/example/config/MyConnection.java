package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection getConnection() throws SQLException {

        return  DriverManager.getConnection("jdbc:postgresql://localhost:5432/w7c1", "postgres", "postgres");




    }


}
