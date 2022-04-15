package com.databaseproject.gymdbms;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeesController {
    private Stage stage;
    private Scene scene;

    public void switchToHome(ActionEvent event) throws IOException {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void switchToMembers(ActionEvent event) throws IOException {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("Members.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void addEmployee(ActionEvent event) throws IOException {
        try {
            // TODO: insert employee into database here
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEmployee(ActionEvent event) throws IOException {
        try {
            // TODO: delete employee from database here
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void searchForEmployee(ActionEvent event) throws IOException {
        try {
            // TODO: select employee by name
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

