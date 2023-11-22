package com.example.vadvisor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CalculateSemesterCGPAController implements Initializable {

    @FXML
    TextField courseName1TextField;
    @FXML
    TextField courseName2TextField;
    @FXML
    TextField courseName3TextField;
    @FXML
    TextField courseName4TextField;

    @FXML
    private Label totalCreditsLabel;

    @FXML
    private Label cgpaResultLabel;

    @FXML
    private Button addButton;

    @FXML
    private Button calculateButton;

    @FXML
    private TextField cgpa1TextField;

    @FXML
    private TextField cgpa2TextField;

    @FXML
    private TextField cgpa3TextField;

    @FXML
    private TextField cgpa4TextField;

    @FXML
    private ComboBox<Integer> credit1ComboBox;

    @FXML
    private ComboBox<Integer> credit2ComboBox;

    @FXML
    private ComboBox<Integer> credit3ComboBox;

    @FXML
    private ComboBox<Integer> credit4ComboBox;

    @FXML
    private Button removeButton;

    @FXML
    private Button resetButton;
    @FXML
    private Button homeButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectCreditComboBox(credit1ComboBox);
        selectCreditComboBox(credit2ComboBox);
        selectCreditComboBox(credit3ComboBox);
        selectCreditComboBox(credit4ComboBox);
    }

    private void selectCreditComboBox(ComboBox<Integer> credit) {
        Integer[] creditList = {1, 2, 3, 4, 5};
        credit.getItems().setAll(creditList);
    }

    @FXML
    private void handleCalculateButtonAction(ActionEvent event) {
        // Get the selected credits and CGPA values
        int credit1 = credit1ComboBox.getValue();
        double cgpa1 = Double.parseDouble(cgpa1TextField.getText());

        int credit2 = credit2ComboBox.getValue();
        double cgpa2 = Double.parseDouble(cgpa2TextField.getText());

        int credit3 = credit3ComboBox.getValue();
        double cgpa3 = Double.parseDouble(cgpa3TextField.getText());

        int credit4 = credit4ComboBox.getValue();
        double cgpa4 = Double.parseDouble(cgpa4TextField.getText());

        // Calculate the weighted sum of credits and CGPA values
        double weightedSum = (credit1 * cgpa1 + credit2 * cgpa2 + credit3 * cgpa3 + credit4 * cgpa4);

        // Calculate the total credits
        int totalCredits = credit1 + credit2 + credit3 + credit4;

        // Calculate the CGPA
        double cgpa = weightedSum / totalCredits;



        // Display the result
        cgpaResultLabel.setText(String.format("CGPA: %.2f", cgpa));
        totalCreditsLabel.setText("Total Credits: " + totalCredits);

    }

    @FXML
    private void handleResetButtonAction(ActionEvent event) {
        // Clear all text fields
        cgpa1TextField.clear();
        cgpa2TextField.clear();
        cgpa3TextField.clear();
        cgpa4TextField.clear();
        courseName1TextField.clear();
        courseName2TextField.clear();
        courseName3TextField.clear();
        courseName4TextField.clear();

        // Reset combo boxes to default values
        credit1ComboBox.getSelectionModel().clearSelection();
        credit2ComboBox.getSelectionModel().clearSelection();
        credit3ComboBox.getSelectionModel().clearSelection();
        credit4ComboBox.getSelectionModel().clearSelection();

        // Clear labels
        totalCreditsLabel.setText("Total Credits: ");
        cgpaResultLabel.setText("CGPA: ");
    }

    private HBox coursesContainer; // Assuming this is the container for all course entries

    private List<ComboBox<Integer>> creditComboBoxes = new ArrayList<>();
    private List<TextField> cgpaTextFields = new ArrayList<>();
    private List<TextField> courseNameTextFields = new ArrayList<>();

    // ... Other fields and methods

    @FXML
    private void handleAddButtonAction() {
        // Create new course entry components
        ComboBox<Integer> creditComboBox = new ComboBox<>();
        selectCreditComboBox(creditComboBox);
        creditComboBoxes.add(creditComboBox);

        TextField cgpaTextField = new TextField();
        cgpaTextFields.add(cgpaTextField);

        TextField courseNameTextField = new TextField();
        courseNameTextFields.add(courseNameTextField);

        // Create an HBox to hold the new entry components
        HBox newCourseEntry = new HBox(10); // You can adjust the spacing as needed
        newCourseEntry.getChildren().addAll(
                new Label("Course Name:"),
                courseNameTextField,
                new Label("Credit:"),
                creditComboBox,
                new Label("CGPA:"),
                cgpaTextField
        );

        // Add the new HBox to the container
        coursesContainer.getChildren().add(newCourseEntry);
    }
    @FXML
    private void handleHomeButtonAction(ActionEvent event) {
        // Add code to handle the action when the "Home" button is pressed.
        // For example, you can use the DBUtils.changeScene method to navigate to the home screen.
        DBUtils.changeScene(event, "logged-in.fxml", "CGPA Calculator", null, null, 600, 400);
    }



}
