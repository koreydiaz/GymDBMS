package com.databaseproject.gymdbms;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Stage stage;
    private Scene scene;

    public void switchToEmployees(ActionEvent event) throws IOException {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("Employees.fxml"));
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

    public void showPlatteville(ActionEvent event) throws IOException {
        try {
            // TODO: show Platteville stats
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void showCreek(ActionEvent event) throws IOException {
        try {
            // TODO: show Creek stats
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void showBondPark(ActionEvent event) throws IOException {
        try {
            // TODO: show Bond Park stats
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void showCentral(ActionEvent event) throws IOException {
        try {
            // TODO: show Central stats
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

