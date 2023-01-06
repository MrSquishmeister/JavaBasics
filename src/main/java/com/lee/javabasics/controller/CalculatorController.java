package com.lee.javabasics.controller;

import com.lee.javabasics.SceneSwitch;
import com.lee.javabasics.model.CalculatorModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CalculatorController {

    @FXML
    AnchorPane calculatorAnchorPane;
    @FXML
    private TextField num1TextField;

    @FXML
    private TextField num2TextField;

    @FXML
    private Label resultLabel;

    private int num1, num2, result;
    private CalculatorModel CalculatorModel = new CalculatorModel();

    @FXML
    void onButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String operatorString = button.getText();
        char operator = operatorString.charAt(0);

        num1 = Integer.parseInt(num1TextField.getText());
        num2 = Integer.parseInt(num2TextField.getText());
        result = CalculatorModel.calculate(num1, num2, operator);
        resultLabel.setText(String.valueOf(result));
    }

    @FXML
    void onBackButtonClick() throws IOException {
        new SceneSwitch(calculatorAnchorPane, "view/intro-view.fxml");
    }

}
