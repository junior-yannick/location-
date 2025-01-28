package org.example.demo;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PaiementController {
    @FXML
    private TextField cardNumberField;
    @FXML
    private TextField expirationDateField;
    @FXML
    private TextField securityCodeField;
    @FXML
    private Button payButton;
    @FXML
    private Label errorcarte;
    @FXML
    private Label success;

    public void initialize() {
        resetFields();
    }


    //Valider le champ de saisie du numero de carte
    @FXML
    private void validateCardNumber() {
        if (cardNumberField.getText().length() < 16) {
            cardNumberField.setStyle("-fx-border-color: red;");
            errorcarte.setText("Numéro de carte invalide");
        } else {
            cardNumberField.setStyle("");
            errorcarte.setText("");
        }
        updateSuccessLabel();
    }

    //  Valider le champ de saisie de la date d'expiration
    @FXML
    private void validateExpirationDate() {
        if (expirationDateField.getText().length() < 4) {
            expirationDateField.setStyle("-fx-border-color: red;");

        } else {
            expirationDateField.setStyle("");
            errorcarte.setText("");
        }
        updateSuccessLabel();
    }

    // Valider le champ de saisie de CVV
    @FXML
    private void validateSecurityCode() {
        if (securityCodeField.getText().length() < 3) {
            securityCodeField.setStyle("-fx-border-color: red;");

        } else {
            securityCodeField.setStyle("-fx-border-color: green;");
            errorcarte.setText("");
        }
        updateSuccessLabel();
    }

    // Quand on clique sur le bouton Paiement
    @FXML
    private void handlePayment() {
        if (cardNumberField.getText().length() == 16 && expirationDateField.getText().length() == 4 && securityCodeField.getText().length() == 3) {
            success.setText("Paiement réussi !");
            success.setStyle("-fx-text-fill: green;");

        }
        else {success.setText("Erreur de paiment");
            success.setStyle("-fx-text-fill: red;");
        }
    }

    //Quand le paiement est réussi et que tous les champs sont enfin valides
    private void updateSuccessLabel() {
        if (cardNumberField.getStyle().equals("") && expirationDateField.getStyle().equals("") && securityCodeField.getStyle().equals("")) {
            success.setText("");
        }
    }

    private void resetFields() {
        cardNumberField.setStyle("");
        expirationDateField.setStyle("");
        securityCodeField.setStyle("");
        errorcarte.setText("");
        success.setText("");
    }
}

