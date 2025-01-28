package org.example.demo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Label signsuccess;

    @FXML
    private Hyperlink connexion;

    // Quand on clique sur le bouton d'inscription, les champs sont d'abord validés
    @FXML
    private void handleSignUpButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {
            signsuccess.setText("Tous les champs doivent être remplis");
            signsuccess.setStyle("-fx-text-fill: red;");
        } else if (!phoneNumber.matches("\\d+")) {
            signsuccess.setText("Numéro de téléphone invalide");
            signsuccess.setStyle("-fx-text-fill: red;");
            phoneNumberField.setStyle("-fx-border-color: red;");
        } else {
            signsuccess.setText("Inscription Réussie!");
            signsuccess.setStyle("-fx-text-fill: green;");
        }
    }

    //Quand on clique sur connexion une fois inscrit
    @FXML
    private void handleConnexionLinkAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo/Login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage)connexion.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


