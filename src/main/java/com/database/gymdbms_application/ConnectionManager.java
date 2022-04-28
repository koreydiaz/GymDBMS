package com.database.gymdbms_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{

   public static Connection connect()
   {
      Connection conn = null;
      String url, username = null;
      String password = null;

      url = "jdbc:mysql://localhost:3306/gym_dbms";
      username = "root";
      password = "@Mouctar43";

      try
      {
         conn = DriverManager.getConnection(url, username, password);
         System.out.println("Connection Established!");
      } catch (SQLException e){
         e.printStackTrace();
      }
      return conn;
   }
}
