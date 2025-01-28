package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ReservationsVueController {

    @FXML
    private Label carNameLabel;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;

    @FXML
    private Button pay;
    @FXML
    private Button reserve;
    @FXML
    private Button preview;

    private int dailyPrice;
    @FXML
    private Historique historiquePane;


    //Implémentation de ntre patron observateur qui ecoite chaque reservation
    @FXML
    public void initialize() {
        // Initialiser l'instance de Historique en récupérant la référence à partir du FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo/HistoriqueReserve.fxml"));
        try {
            Parent root = loader.load();
            historiquePane = loader.getController(); // Récupérer la référence à partir du FXMLLoader
            addReservationObserver(historiquePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Observateurs de réservation
    private List<ReservationObserver> observers = new ArrayList<>();
    public void addReservationObserver(ReservationObserver observer) {
        observers.add(observer);
    }

    // Méthode pour notifier les observateurs lorsqu'une réservation est effectuée
    @FXML
    private void reserveCar() {
        String carName = carNameLabel.getText();
        String totalPrice = totalPriceLabel.getText();
        notifyObservers(carName, totalPrice);
    }

    // Méthode pour notifier tous les observateurs
    private void notifyObservers(String carName, String totalPrice) {
        for (ReservationObserver observer : observers) {
            observer.update(carName, totalPrice);
        }
    }

    // Méthode pour initialiser les détails de la voiture
    public void setCarDetails(String carName, String dailyPrice) {
        carNameLabel.setText(carName);
        try {
            this.dailyPrice = Integer.parseInt(dailyPrice);
        } catch (NumberFormatException e) {
            // Gérer l'erreur de format de prix ici
            this.dailyPrice = 0;
        }
    }

    // Méthode pour calculer et afficher le prix
    @FXML
    private void calculatePrice() {
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        if (startDate == null || endDate == null) {
            showAlert("Erreur de Date", "Veuillez sélectionner les deux dates.");
            return;
        }

        if (!endDate.isAfter(startDate)) {
            showAlert("Erreur de Date", "La date de fin doit être après la date de début.");
            return;
        }

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate) + 1; // Inclus le jour de début
        int totalPrice = (int) (daysBetween * dailyPrice);
        totalPriceLabel.setText("$" + totalPrice);
    }

    // Méthode pour afficher les alertes
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    //Quand on clique sur le bouton Precedent
    @FXML
    private void handlePrecedentAction(ActionEvent event) {
        // Pour revenir à l'écran d'authentification
        try {
            Parent authentificationVue = FXMLLoader.load(getClass().getResource("/org/example/demo/CatalogueVue2.fxml"));
            Scene authentificationScene = new Scene(authentificationVue);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(authentificationScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Quand on clique sur le bouton de porceder au  paiement
    @FXML
    private void handlePaymentButtonAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo/InterfacePaiement.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) pay.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Quand on clique sur le bouton reserver
    @FXML
    private void handleReserveButtonClick(ActionEvent event) {

        calculatePrice();
        reserveCar();
    }
}

