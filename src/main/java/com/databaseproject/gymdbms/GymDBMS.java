package com.databaseproject.gymdbms;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Group;
import java.io.IOException;

public class GymDBMS extends Application {
    public Button fButton = new Button("Facilities");
    public Button eButton = new Button("Employees");
    public Button mButton = new Button("Members");
    Scene mainScene;
    StackPane facilitiesPage;
    StackPane employeesPage;
    StackPane membersPage;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


            /*facilitiesPage = new StackPane();
            employeesPage = new StackPane();
            membersPage = new StackPane();

            HBox hbox = new HBox();
            hbox.setAlignment(Pos.TOP_CENTER);
            hbox.setSpacing(20.0);

            hbox.getChildren().add(fButton);
            hbox.getChildren().add(eButton);
            hbox.getChildren().add(mButton);

            facilitiesPage.getChildren().addAll(hbox);
            facilitiesPage.setAlignment(Pos.TOP_CENTER);

            fButton.setOnAction(fEvent);
            eButton.setOnAction(eEvent);
            mButton.setOnAction(mEvent);

            mainScene = new Scene(facilitiesPage, 400, 300);
            stage.setScene(mainScene);
            stage.show(); */
        }

        catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }

    EventHandler<ActionEvent> fEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            System.out.println("On Facilities Page");
        }
    };

    EventHandler<ActionEvent> eEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            System.out.println("On Employee Page");
        }
    };

    EventHandler<ActionEvent> mEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            System.out.println("On Members Page");
        }
    };

}