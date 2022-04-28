package com.database.gymdbms_application;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import static com.database.gymdbms_application.ConnectionManager.connect;

public class MemberController implements Initializable {
   public TableView<Members> memberTable;
   public TableColumn<Members, String> member_ID;
   public TableColumn<Members, String> fName;
   public TableColumn<Members, String> lName;
   public TableColumn<Members, String> birthDate;
   public Button updateButton;
   public TextField keywordTextField;
   java.sql.Date dateDB;
   private Stage stage;
   private Scene scene;
   Connection connection = null;
   PreparedStatement insert = null;
   String sql = null;
   ResultSet rs = null;
   Members members;
   int selectedID;

   ObservableList<Members> membersList = FXCollections.observableArrayList();

   public void switchToEmployees(ActionEvent event) throws IOException {
      try {
         AnchorPane root = FXMLLoader.load(getClass().getResource("Employees.fxml"));
         stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }

   }

   public void switchToHome(ActionEvent event) throws IOException {
      try {
         AnchorPane root = FXMLLoader.load(getClass().getResource("Home.fxml"));
         stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }

      refreshMemberData();
   }

   public void refreshMemberData() {
      membersList.clear();
      try {
         sql = "SELECT * FROM member";
         insert = connection.prepareStatement(sql);
         rs = insert.executeQuery();

         while (rs.next()) {
            membersList.add(new Members(
                    rs.getString("Member_ID"),
                    rs.getString("Member_FirstName"),
                    rs.getString("Member_LastName"),
                    rs.getString("Member_BirthDate")
            ));
            memberTable.setItems(membersList);
         }
         insert.close();
         rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void loadMemberData() {
      connection = connect();
      refreshMemberData();
      member_ID.setCellValueFactory(new PropertyValueFactory<>("Member_ID"));
      fName.setCellValueFactory(new PropertyValueFactory<>("Member_FirstName"));
      lName.setCellValueFactory(new PropertyValueFactory<>("Member_LastName"));
      birthDate.setCellValueFactory(new PropertyValueFactory<>("Member_BirthDate"));

      memberTable.setItems(membersList);
   }

   public void addMember(ActionEvent event) throws IOException {
      AnchorPane root = FXMLLoader.load(getClass().getResource("AddMembers.fxml"));
      stage = new Stage();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
   }

   public void updateInfo(ActionEvent actionEvent) throws SQLException, ParseException {
      String bDay = (String.valueOf(birthDate.getText()));
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
      java.util.Date dateStr = formatter.parse(bDay);
      dateDB = new java.sql.Date(dateStr.getTime());
      selectedID = memberTable.getSelectionModel().getSelectedIndex();
      String selectedM_ID = memberTable.getSelectionModel().getSelectedItem().Member_ID;
      int memberToUpdate = Integer.parseInt(selectedM_ID);
      sql = "UPDATE member SET"
              + "Member_ID = ?"
              + "Member_FirstName = ?,"
              + "Member_LastName = ?,"
              + "Member_BirthDate = ? WHERE Member_ID = " + memberToUpdate;
      insert = connection.prepareStatement(sql);
      insert.setString(2, fName.getText());
      insert.setString(3, lName.getText());
      insert.setDate(4, dateDB);
      insert.execute();
      refreshMemberData();
   }

   public void deleteMember(ActionEvent event) throws IOException {
      try {
         selectedID = memberTable.getSelectionModel().getSelectedIndex();
         String selectedM_ID = memberTable.getSelectionModel().getSelectedItem().Member_ID;
         int memberToDelete = Integer.parseInt(selectedM_ID);
         sql = "DELETE FROM member WHERE Member_ID = " + memberToDelete;
         insert = connection.prepareStatement(sql);
         insert.execute();
         memberTable.getItems().remove(selectedID);
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      refreshMemberData();
   }

   public void searchForMember(MouseEvent event) throws IOException
   {
      try {
         // initial filtered list
         FilteredList<Members> filteredData = new FilteredList<>(membersList, b -> true);
         keywordTextField.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(members->{
               // if no search value then display all records or whatever record it currently has.
               if (newValue.isEmpty() || newValue.isBlank()){
                  return true;
               }
               String searchKeyword = newValue.toLowerCase();
               if (members.getMember_ID().toLowerCase().contains(searchKeyword)){
                  return true;
               }
               else if (members.getMember_FirstName().toLowerCase().contains(searchKeyword)){
                  return true; // means we found a match
               }
               else if (members.getMember_LastName().toLowerCase().contains(searchKeyword)) {
                  return true;
               }
               else if (members.getMember_BirthDate().toLowerCase().contains(searchKeyword)){
                  return true;
               }
               else {
                  return false; // no match found
               }
            });
         });

         SortedList<Members> sortedData = new SortedList<>(filteredData);

         // Bind sorted result with Table view
         sortedData.comparatorProperty().bind(memberTable.comparatorProperty());

         // Apply filtered and sorted data to the Table view
         memberTable.setItems(sortedData);
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }

   public void makeEdits(MouseEvent mouseEvent)
   {
//      member_ID.setCellFactory(TextFieldTableCell.forTableColumn());
//      member_ID.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setMember_ID(e.getNewValue()));
      fName.setCellFactory(TextFieldTableCell.forTableColumn());
      fName.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setMember_FirstName(e.getNewValue()));
      lName.setCellFactory(TextFieldTableCell.forTableColumn());
      lName.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setMember_LastName(e.getNewValue()));
      birthDate.setCellFactory(TextFieldTableCell.forTableColumn());
      birthDate.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setMember_BirthDate(e.getNewValue()));

      memberTable.setEditable(true);
   }
   public void refreshTable(MouseEvent mouseEvent)
   {
      keywordTextField.clear();
      refreshMemberData();
   }

   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      loadMemberData();
   }


}
