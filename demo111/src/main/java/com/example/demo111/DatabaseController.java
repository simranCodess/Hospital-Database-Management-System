package com.example.demo111;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseController {
     public static Connection connection() {
         Connection connection = null;
         try {
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOSPITAL_MANAGEMENT", "root", "Astronomy541");
             System.out.println("Connection status: " + connection);
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return connection;
     }
}
