package com.lee.javabasics.controller;

import com.lee.javabasics.SceneSwitch;
import com.lee.javabasics.model.BankModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    Pane loginPane;
    @FXML
    Pane accountPane;
    @FXML
    private TextField userIDTextField;
    @FXML
    private TextField userPinTextField;
    @FXML
    private TextField inputTextField;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Label promptLabel;
    @FXML
    private Label balanceLabel;
    private BankModel BankModel = new BankModel();
    private int userID;
    private int userBalance;

    void AccountSuccess(){
        loginPane.setVisible(false);
        accountPane.setVisible(true);
        welcomeLabel.setText("Welcome to the Bank userID " + userID);
        balanceLabel.setText("Balance: £" + userBalance);
    }

    @FXML
    void onloginButtonClick() {
        try{
            userID = Integer.parseInt(userIDTextField.getText());
            int userPIN = Integer.parseInt(userPinTextField.getText());
            userBalance = BankModel.Login(userID, userPIN);
            AccountSuccess();
        }
        catch (NumberFormatException e){
            promptLabel.setText("Provide credentials to login");
        } catch (SQLException e) {
            promptLabel.setText("Cannot connect to DB");
        }
    }

    @FXML
    void onButtonClick(ActionEvent event){
        Button button = (Button) event.getSource();
        String operatorString = button.getText();
        try{
            int userInput = Integer.parseInt(inputTextField.getText());
            userBalance = BankModel.Deposit(userInput, operatorString);
            balanceLabel.setText("Balance: £" + userBalance);
        }catch (NumberFormatException e){
            System.out.println("NOT INT");
        }
    }


    @FXML
    void onBackButtonClick() throws IOException {
        new SceneSwitch(bankAnchorPane, "view/intro-view.fxml");
    }

}
