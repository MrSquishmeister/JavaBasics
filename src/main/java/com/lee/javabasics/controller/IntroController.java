package com.lee.javabasics.controller;

import com.lee.javabasics.SceneSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class IntroController {

    @FXML
    AnchorPane introAnchorPane;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onIntroButtonClick() {
        welcomeText.setText("Welcome to Java Basics Application!");
    }

    @FXML
    void onCalculatorButtonClick() throws IOException {
        new SceneSwitch(introAnchorPane, "view/calculator-view.fxml");
    }
}