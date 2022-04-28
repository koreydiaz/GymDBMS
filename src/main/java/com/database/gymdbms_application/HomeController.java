package com.database.gymdbms_application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;

import java.io.IOException;
import java.util.ResourceBundle;

import static com.database.gymdbms_application.ConnectionManager.connect;

public class HomeController implements Initializable
{
   public TableView<Facilities> facilityTable;
   public TableColumn<Facilities, String> location;
   public TableColumn<Facilities, String> numEmployees;
   public TableColumn<Facilities, String> numMembers;
   private Stage stage;
   private Scene scene;

   Connection connection = null;
   PreparedStatement insert = null;
   String sql = null;
   ResultSet rs = null;
   Facilities facilities = null;

   ObservableList<Facilities> facilitiesList = FXCollections.observableArrayList();

   public void switchToEmployees(ActionEvent event) throws IOException
   {
      try
      {
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

   public void switchToMembers(ActionEvent event) throws IOException
   {
      try
      {
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

   private void refreshFacilitiesData()
   {
      facilitiesList.clear();
      try
      {
         sql = "SELECT * FROM facility";
         insert = connection.prepareStatement(sql);
         rs = insert.executeQuery();

         while(rs.next())
         {
            facilitiesList.add(new Facilities(
                    rs.getString("Location"),
                    rs.getString("Number_OfEmployees"),
                    rs.getString("Number_OfMembers")
            ));
            facilityTable.setItems(facilitiesList);
         }
         insert.close();
         rs.close();
      }
      catch (SQLException e)
      {
         e.printStackTrace();
      }
   }

   private void loadFacilityData()
   {
      connection = connect();
      refreshFacilitiesData();
      location.setCellValueFactory(new PropertyValueFactory<>("Location"));
      numEmployees.setCellValueFactory(new PropertyValueFactory<>("Number_OfEmployees"));
      numMembers.setCellValueFactory(new PropertyValueFactory<>("Number_OfMembers"));

      facilityTable.setItems(facilitiesList);
   }


   public void addEmployee(ActionEvent event) throws IOException
   {
      try
      {
         // TODO: insert employee into database here
      }
      catch (Exception e)
      {
         System.out.println(e.getMessage());
      }
   }

   public void deleteEmployee(ActionEvent event) throws IOException
   {
      try
      {
         // TODO: delete employee from database here
      }
      catch (Exception e)
      {
         System.out.println(e.getMessage());
      }
   }

   public void searchForEmployee(ActionEvent event) throws IOException
   {
      try
      {
         // TODO: select employee by name
      }
      catch (Exception e)
      {
         System.out.println(e.getMessage());
      }
   }

   @Override
   public void initialize(URL url, ResourceBundle resourceBundle)
   {
      loadFacilityData();
   }
}
