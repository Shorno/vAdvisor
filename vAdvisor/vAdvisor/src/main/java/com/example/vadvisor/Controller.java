package com.example.vadvisor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button signupButton;

    @FXML
    private TextField usernameTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.logInUser(event, usernameTextField.getText(), passwordTextField.getText());
            }
        });
        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"sign-up.fxml", "Sign up!", null, null, 600,400);
            }
        });
    }
}
