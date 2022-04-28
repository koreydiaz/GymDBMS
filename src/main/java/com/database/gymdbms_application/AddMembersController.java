package com.database.gymdbms_application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import static com.database.gymdbms_application.ConnectionManager.connect;

public class AddMembersController implements Initializable {
   public Button updateInfo;
   java.sql.Date dateDB;
   public TextField mIDFld;
   public TextField fnFid;
   public TextField lnFid;
   public TextField bdFid;
   public Button saveButton;
   public Button cancelButton;

   Connection connection = null;
   PreparedStatement insert = null;
   String sql = null;
   ResultSet rs = null;


   @FXML
   private void save(ActionEvent actionEvent) throws ParseException {
      connection = connect();
      int id = Integer.parseInt(mIDFld.getText());
      String fName = fnFid.getText();
      String lName = lnFid.getText();
      String bDay = (String.valueOf(bdFid.getText()));
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
      java.util.Date dateStr = formatter.parse(bDay);
      dateDB = new java.sql.Date(dateStr.getTime());

      if (id < 0 || fName.isEmpty() || lName.isEmpty() || bDay.isEmpty()) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setHeaderText(null);
         alert.setContentText("Please fill in all data");
         alert.showAndWait();
      }
      else
      {
         getQuery();
         insert();
         close();
      }
   }

   private void getQuery() {

      sql = "INSERT INTO member ( Member_ID, Member_FirstName, Member_LastName, Member_BirthDate)" +
              "VALUES (?,?,?,?);";

   }

   private void insert() {
      try {
         insert = connection.prepareStatement(sql);
         insert.setInt(1, Integer.parseInt(mIDFld.getText()));
         insert.setString(2, fnFid.getText());
         insert.setString(3, lnFid.getText());
         insert.setDate(4, dateDB);
         insert.execute();
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

   private void clean() {
      mIDFld.setText(null);
      fnFid.setText(null);
      lnFid.setText(null);
      bdFid.setText(null);
   }

   private void setTextField(int id, String fName, String lName, Date bDay) {
      mIDFld.setText(String.valueOf(id));
      fnFid.setText(fName);
      lnFid.setText(lName);
      bdFid.setText(String.valueOf(bDay));
   }

   public void cancel(ActionEvent actionEvent) {
      close();
   }

   public void close() {
      clean();
      Stage stage = (Stage) cancelButton.getScene().getWindow();
      stage.close();
   }

   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {

   }

   public void updateMemberInfo(ActionEvent actionEvent) throws ParseException, SQLException {
      connection = connect();
      int id = Integer.parseInt(mIDFld.getText());
      String fName = fnFid.getText();
      String lName = lnFid.getText();
      String bDay = (String.valueOf(bdFid.getText()));
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
      java.util.Date dateStr = formatter.parse(bDay);
      dateDB = new java.sql.Date(dateStr.getTime());
      sql = "UPDATE member SET"
              + "Member_ID = ?"
              + "Member_FirstName = ?,"
              + "Member_LastName = ?,"
              + "Member_BirthDate = ? WHERE Member_ID = " + id;
      insert = connection.prepareStatement(sql);
      insert.setInt(1, Integer.parseInt(mIDFld.getText()));
      insert.setString(2, fnFid.getText());
      insert.setString(3, lnFid.getText());
      insert.setDate(4, dateDB);
      insert.execute();

      if (id < 0 || fName.isEmpty() || lName.isEmpty() || bDay.isEmpty()) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setHeaderText(null);
         alert.setContentText("Please fill in all data");
         alert.showAndWait();
      }
      else
      {
         close();
      }
   }
}
