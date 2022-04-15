module com.databaseproject.gymdbms {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.databaseproject.gymdbms to javafx.fxml;
    exports com.databaseproject.gymdbms;
}