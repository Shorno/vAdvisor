package com.example.vadvisor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.control.*;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private RadioButton cse111RadioButton;

    @FXML
    private RadioButton cse222RadioButton;

    @FXML
    private Button login_Button;

    @FXML
    private TextField passwordText_Field;

    @FXML
    private Button signup_Button;

    @FXML
    private TextField usernameText_Field;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup toggleGroup = new ToggleGroup();
        cse111RadioButton.setToggleGroup(toggleGroup);
        cse222RadioButton.setToggleGroup(toggleGroup);
        cse111RadioButton.setSelected(true);

        signup_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();

                if (!usernameText_Field.getText().trim().isEmpty() && !passwordText_Field.getText().trim().isEmpty()){
                    DBUtils.signUpUser(event, usernameText_Field.getText(), passwordText_Field.getText(), toggleName);
                } else {
                    System.out.println("Please fill the infos");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Fill all info to sign up");
                    alert.show();
                }
            }
        });
        login_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "sample.fxml", "Log in!", null, null, 600,400);
            }
        });
    }
}
