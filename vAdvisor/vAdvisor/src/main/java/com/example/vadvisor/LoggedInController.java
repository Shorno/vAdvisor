package com.example.vadvisor;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    private Button logoutButton;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Label welcomeTextLable;
    @FXML
    private Button calculateSemesterCGPAButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "sample.fxml", "Log in!", null, null, 600, 400);


            }
        });

        calculateSemesterCGPAButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"CalculateSemesterCGPA.fxml", "CGPA Calculator", null,null, 600, 600);
            }
        });
    }

    public void setUserInformation(String username, String favCourse){
        welcomeLabel.setText("Welcome "+ username+ "!");

    }
}
