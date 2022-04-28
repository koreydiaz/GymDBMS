package com.database.gymdbms_application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
   public Button fButton = new Button("Facilities");
   public Button eButton = new Button("Employees");
   public Button mButton = new Button("Members");
   Scene mainScene;
   StackPane facilitiesPage;
   StackPane employeesPage;
   StackPane membersPage;



   @Override
   public void start(Stage stage) throws IOException
   {
      try
      {
         AnchorPane root = FXMLLoader.load(getClass().getResource("Home.fxml"));
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
      }
      catch (Exception e)
      {

         System.out.println(e.getMessage());
      }
   }

   public static void main(String[] args)
   {
      launch();
   }

   EventHandler<ActionEvent> fEvent = new EventHandler<ActionEvent>()
   {
      public void handle(ActionEvent e)
      {
         System.out.println("On Facilities Page");
      }
   };

   EventHandler<ActionEvent> eEvent = new EventHandler<ActionEvent>()
   {
      public void handle(ActionEvent e)
      {
         System.out.println("On Employee Page");
      }
   };

   EventHandler<ActionEvent> mEvent = new EventHandler<ActionEvent>()
   {
      public void handle(ActionEvent e)
      {
         System.out.println("On Members Page");
      }
   };
}
