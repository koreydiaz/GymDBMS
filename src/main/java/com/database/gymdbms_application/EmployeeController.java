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
import  java.sql.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.database.gymdbms_application.ConnectionManager.connect;

public class EmployeeController implements Initializable
{
   public TableView<Employees> employeeTable;
   public TableColumn<Employees, String> empID;
   public TableColumn<Employees, String> empFname;
   public TableColumn<Employees, String> empLname;
   public TableColumn<Employees, String> empBday;
   public TableColumn<Employees, String> empPlocation;
   public TableColumn<Employees, String> empType;
   private Stage stage;
   private Scene scene;
   Connection connection = null;
   PreparedStatement insert = null;
   String sql = null;
   ResultSet rs = null;
   Employees employees = null;

   ObservableList<Employees> employeesList = FXCollections.observableArrayList();

   public void switchToHome(ActionEvent event) throws IOException
   {
      try
      {
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

   private void refreshEmployeeData()
   {
      employeesList.clear();
      try
      {
         sql = "SELECT * FROM employee";
         insert = connection.prepareStatement(sql);
         rs = insert.executeQuery();

         while(rs.next())
         {
            employeesList.add(new Employees(
                    rs.getString("Employee_ID"),
                    rs.getString("Employee_FirstName"),
                    rs.getString("Employee_LastName"),
                    rs.getString("Employee_BirthDate"),
                    rs.getString("Primary_Location"),
                    rs.getString("Employee_Type")
            ));
            employeeTable.setItems(employeesList);
         }
         insert.close();
         rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   private void loadEmployeeData()
   {
      connection = connect();
      refreshEmployeeData();
      empID.setCellValueFactory(new PropertyValueFactory<>("Employee_ID"));
      empFname.setCellValueFactory(new PropertyValueFactory<>("Employee_FirstName"));
      empLname.setCellValueFactory(new PropertyValueFactory<>("Employee_LastName"));
      empBday.setCellValueFactory(new PropertyValueFactory<>("Employee_BirthDate"));
      empPlocation.setCellValueFactory(new PropertyValueFactory<>("Primary_Location"));
      empType.setCellValueFactory(new PropertyValueFactory<>("Employee_Type"));

      employeeTable.setItems(employeesList);
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
      loadEmployeeData();
   }
}
