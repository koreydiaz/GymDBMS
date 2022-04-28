module com.example.gymdms_application {
   requires javafx.controls;
   requires javafx.fxml;
   requires java.sql;
   requires java.desktop;


   opens com.database.gymdbms_application to javafx.fxml;
   exports com.database.gymdbms_application;
}