package com.databaseproject.gymdbms;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MembersController {
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

    public void addMember(ActionEvent event) throws IOException {
        try {
            // TODO: insert member into database
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void deleteMember(ActionEvent event) throws IOException {
        try {
            // TODO: delete member from database
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void searchForMember(ActionEvent event) throws IOException {
        try {
            // TODO: select member by name
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
