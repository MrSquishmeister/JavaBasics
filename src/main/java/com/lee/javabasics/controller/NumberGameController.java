package com.lee.javabasics.controller;

import com.lee.javabasics.SceneSwitch;
import com.lee.javabasics.model.NumberGameModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NumberGameController {
    @FXML
    private TextField guessTextField;
    @FXML
    private Label hintLabel;
    @FXML
    private AnchorPane numbergameAnchorPane;
    private NumberGameModel NumberGameModel = new NumberGameModel();

    @FXML
    void CheckButtonClick() {
        try{
            int numGuess = Integer.parseInt(guessTextField.getText());
            hintLabel.setText(NumberGameModel.Hint(numGuess));
        }
        catch (NumberFormatException e){
            hintLabel.setText("Enter a number");
        }
    }

    @FXML
    void BackButtonClick() throws IOException {
        new SceneSwitch(numbergameAnchorPane, "view/intro-view.fxml");
    }

}
