package com.lee.javabasics.controller;

import com.lee.javabasics.SceneSwitch;
import com.lee.javabasics.model.BankModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;

public class BankController {
    @FXML
    private AnchorPane bankAnchorPane;
    @FXML
    private TextField userIDTextField;
    @FXML
    private TextField userPinTextField;
    @FXML
    private Label promptLabel;
    private BankModel BankModel = new BankModel();

    @FXML
    void loginButtonClick(ActionEvent event) {

        try{
            int userID = Integer.parseInt(userIDTextField.getText());
            int userPIN = Integer.parseInt(userPinTextField.getText());
            BankModel.Login(event, userID, userPIN);
        }
        catch (NumberFormatException e){
            promptLabel.setText("Provide credentials to login");
        } catch (SQLException e) {
            promptLabel.setText("Cannot connect to DB");
        }
    }

    @FXML
    void BackButtonClick() throws IOException {
        new SceneSwitch(bankAnchorPane, "view/intro-view.fxml");
    }

}
