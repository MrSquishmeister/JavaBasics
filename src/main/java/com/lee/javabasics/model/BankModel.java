package com.lee.javabasics.model;

import com.lee.javabasics.JavaBasicsApplication;
import com.lee.javabasics.controller.AccountController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class BankModel {
    public void ChangeScene(ActionEvent event, String fxml, int userID, int userBalance){
        Parent root = null;

        if(userID != 0 && userBalance != 0){
            try{
                FXMLLoader loader = new FXMLLoader (JavaBasicsApplication.class.getResource(fxml));
                root = loader.load();
                AccountController accountController = loader.getController();
                accountController.UserInformation(userID, userBalance);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        else {
            try{
                root = FXMLLoader.load(JavaBasicsApplication.class.getResource(fxml));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Java Basics");
        stage.setScene(new Scene(root, 800, 400));
        stage.show();
    }

    public void Login(ActionEvent event, int userID, int userPIN) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankDB", "root", "rootpassword");
            preparedStatement = connection.prepareStatement("SELECT userPIN, userBalance FROM bankDB.users WHERE userID = ?");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided userID not found");
                alert.show();
            }else{
                while (resultSet.next()){
                    int retrievedUserPIN = resultSet.getInt("userPIN");
                    int retrievedBalance = resultSet.getInt("userBalance");
                    if (retrievedUserPIN == userPIN){
                        System.out.println("userPIN MATCHES");
                        ChangeScene(event, "view/account-view.fxml", userID, retrievedBalance);
                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided userPin incorrect");
                        alert.show();
                    }
                }
            }

        }
        catch(Exception e){
            e.printStackTrace();
        } finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
