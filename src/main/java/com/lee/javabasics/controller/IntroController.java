package com.lee.javabasics.controller;

import com.lee.javabasics.SceneSwitch;
import com.lee.javabasics.model.CalculatorModel;
import com.lee.javabasics.model.IntroModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class IntroController {
    @FXML
    AnchorPane introAnchorPane;
    @FXML
    private TextField nameTextField;
    @FXML
    private Label reverseLabel;

    String name;
    private com.lee.javabasics.model.IntroModel IntroModel = new IntroModel();

    @FXML
    protected void onReverseButtonClick() {
        name = nameTextField.getText();
        reverseLabel.setText(String.valueOf(IntroModel.Reverse(name)));
    }

    @FXML
    void onCalculatorButtonClick() throws IOException {
        new SceneSwitch(introAnchorPane, "view/calculator-view.fxml");
    }
}