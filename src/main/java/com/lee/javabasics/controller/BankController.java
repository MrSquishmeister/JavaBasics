package com.lee.javabasics.controller;

import com.lee.javabasics.SceneSwitch;
import com.lee.javabasics.model.BankModel;
import com.lee.javabasics.model.CalculatorModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class BankController {
    @FXML
    private AnchorPane bankAnchorPane;
    @FXML
    private Pane bankPane;
    @FXML
    private Pane loginPane;
    @FXML
    private TextField userIDTextField;
    @FXML
    private TextField userPinTextField;
    @FXML
    private Label promptLabel;
    @FXML
    private Label balanceLabel;
    @FXML
    private Label userIDLabel;

    private BankModel BankModel = new BankModel();

    @FXML
    void loginButtonClick() {
        try{
            int userID = Integer.parseInt(userIDTextField.getText());
            int userPin = Integer.parseInt(userPinTextField.getText());
            int balance = BankModel.Login(userID, userPin);
            if (balance != 0) {
                promptLabel.setVisible(false);
                balanceLabel.setText("£" + balance);
                loginPane.setVisible(false);
                bankPane.setVisible(true);
                userIDLabel.setText("userID: " + userID);
            }
            promptLabel.setText("Incorrect combination");
        }
        catch (NumberFormatException e){
            promptLabel.setText("Enter number values");
        }

    }

    @FXML
    void BackButtonClick() throws IOException {
        new SceneSwitch(bankAnchorPane, "view/intro-view.fxml");
    }

}
