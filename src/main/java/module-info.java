module com.lee.javabasics {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.lee.javabasics to javafx.fxml;
    exports com.lee.javabasics;
    exports com.lee.javabasics.controller;
    opens com.lee.javabasics.controller to javafx.fxml;
}