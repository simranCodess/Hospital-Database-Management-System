package com.example.demo111;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HelloController {
    @FXML
    private Button close;

    //methods
    public void close(){
        System.exit(0);
    }
    @FXML
    private AnchorPane homescreen;

    @FXML
    private Button loginbutton;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;


    //Database
    private Connection connection;
    private PreparedStatement preparedStatement;

    private ResultSet resultSet;



    public void login(){
        String adminQuery="SELECT * FROM ADMIN WHERE USERNAME=? AND PASSWORD=?";

        connection= DatabaseController.connection();

        try {
            preparedStatement = connection.prepareStatement(adminQuery);
            preparedStatement.setString(1, username.getText());
            preparedStatement.setString(2, password.getText());
            resultSet = preparedStatement.executeQuery();

            Alert alert;
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the fields");
                alert.showAndWait();
                return;
            } else if (resultSet.next()) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Login Successful");
                alert.showAndWait();
                loginbutton.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Invalid Login, Please check your username and password");
                alert.showAndWait();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}