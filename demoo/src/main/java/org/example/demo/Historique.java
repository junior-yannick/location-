package org.example.demo;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class Historique implements ReservationObserver {

    @FXML
    private TableView<String> historique;
    @FXML
    private TableColumn<String, String> voiturecol;
    @FXML
    private TableColumn<String, String> prixcol;


    // Méthode de mise à jour de l'observateur de réservation
    @Override
    public void update(String carName, String price) {
        addReservation(carName, price);
    }

    // Méthode pour ajouter une nouvelle ligne au tableau avec le nom de la voiture et le prix
    public void addReservation(String carName, String price) {
        // Créer une nouvelle ligne avec le nom de la voiture et le prix
        historique.getItems().add(carName + " - " + price);
    }

    // Méthode d'initialisation appelée après le chargement de l'interface utilisateur
    @FXML
    public void initialize() {
        // Initialiser les colonnes avec des valeurs appropriées
        voiturecol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().split(" - ")[0]));
        prixcol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().split(" - ")[1]));
    }

    // Bouton précédent
    @FXML
    private void handlePreviousButtonAction(ActionEvent event) {
        try {
            Parent catalogueVue = FXMLLoader.load(getClass().getResource("/org/example/demo/CatalogueVue2.fxml"));
            Scene catalogueScene = new Scene(catalogueVue);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(catalogueScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
