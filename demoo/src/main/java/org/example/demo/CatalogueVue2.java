package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CatalogueVue2 {
    @FXML
    private ImageView accueil;

    @FXML
    private ImageView loupe;

    @FXML
    private ImageView voiture1;

    @FXML
    private ImageView voiture2;

    @FXML
    private ImageView voiture3;
    @FXML
    private Button reservation;

    @FXML
    private Button reserverlambo;

    @FXML
    private Button logout;

    @FXML
    private Button reservertoyota;

    @FXML
    private Button reservertesla;

    @FXML
    private Label dispo;

    @FXML
    private Label champvoiture;

    @FXML
    private Label price;

    @FXML
    private TextArea describe;

    @FXML
    private Label sloganlambo;

    @FXML
    private Label slogantoyota;

    @FXML
    private Label slogantesla;

    @FXML
    private TextField research;

    @FXML
    private ListView<String> suggestionListView;

    private final ObservableList<String> suggestions = FXCollections.observableArrayList(
            "Toyota", "Tesla", "BMW", "Lamborghini"
    );



    public void initialize() {

        //charger toutes les images de la page
        chargerImage(accueil, "/Images/accueil.png");
        chargerImage(loupe, "/Images/loupe.png");
        chargerImage(voiture1, "/Images/403487-2024-lamborghini-huracan.jpg");
        chargerImage(voiture2, "/Images/S0-toyota-bz4x-670375.jpg");
        chargerImage(voiture3, "/Images/tesla-model-x-03.jpg");


        //affichage de base de la barre de recherche
        suggestionListView.setVisible(false);
        research.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() >= 2) {
                showSuggestions(newValue);
            } else {
                suggestionListView.setVisible(false);
            }
        });
        suggestionListView.setItems(suggestions);
    }

    // méthode qui va charger les images
    private void chargerImage(ImageView imageView, String imageUrl) {
        try {
            URL imageURL = getClass().getResource(imageUrl);
            if (imageURL != null) {
                Image image = new Image(imageURL.toExternalForm());
                imageView.setImage(image);
            } else {
                System.err.println("L'image " + imageUrl + " n'a pas été trouvée.");
            }
        } catch (Exception e) {
            System.err.println("Une erreur est survenue lors du chargement de l'image " + imageUrl + " : " + e.getMessage());
        }
    }

    // évènements quand on survole des images
    @FXML
    private void sombreImage(MouseEvent event) {
        ImageView imageView = (ImageView) event.getSource();
        imageView.setOpacity(0.6); // Opacité réduite lors du survol
    }
    @FXML
    private void clairImage(MouseEvent event) {
        ImageView imageView = (ImageView) event.getSource();
        imageView.setOpacity(1.0); // Opacité rétablie lorsque le curseur quitte l'image
    }

    // évènements quand on sélectionne sur une voiture pour voir plus de détails
    @FXML
    private void handleVoiture1Click() {
        champvoiture.setText("Lamborghini Huracan");
        price.setText("200 $/Jour");
        describe.setText("Icône de la vitesse et du luxe,\navec un moteur V10 suralimenté,\n610 chevaux et un kilométrage\nde 5,7 km/l.");
    }
    @FXML
    private void handleVoiture2Click() {
        champvoiture.setText("Toyota BZ4X");
        price.setText("195 $/Jour");
        describe.setText("Pionnière de l'électrification,\noffrant une autonomie de 400 km,\nun espace intérieur spacieux\net une consommation\nde 3,8 km/kWh.");
    }
    @FXML
    private void handleVoiture3Click() {
        champvoiture.setText("Tesla Model X3");
        price.setText("198 $/Jour");
        describe.setText("Symbole de technologie et de\ndurabilité, avec une autonomie\nde 500 km,des portes Falcon\nWing etun intérieur\nhaut de gamme");
    }

    // Bouton "précédent" qui renvoi vers l'interface précédente au click
    @FXML
    private void handlePrecedentAction(ActionEvent event) {
        // Pour revenir à l'écran d'authentification
        try {
            Parent authentificationVue = FXMLLoader.load(getClass().getResource("/org/example/demo/Login.fxml"));
            Scene authentificationScene = new Scene(authentificationVue);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(authentificationScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // évènements qui nous renvoient vers la page de réservation au click sur le bouton "reserver"
    @FXML
    private void handleReservationLambo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo/ReservationVue.fxml"));
            Parent reservationsVue = loader.load();

            ReservationsVueController reservationsController = loader.getController();
            reservationsController.setCarDetails("Lamborghini Huracan", "200");


            Scene reservationsScene = new Scene(reservationsVue);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(reservationsScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleReservationToyota(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo/ReservationVue.fxml"));
            Parent reservationsVue = loader.load();

            ReservationsVueController reservationsController = loader.getController();
            reservationsController.setCarDetails("TOYOTA BZ4X ", "195");

            Scene reservationsScene = new Scene(reservationsVue);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(reservationsScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleReservationTesla(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo/ReservationVue.fxml"));
            Parent reservationsVue = loader.load();

            ReservationsVueController reservationsController = loader.getController();
            reservationsController.setCarDetails("TESLA MODEL X3 ", "198");

            Scene reservationsScene = new Scene(reservationsVue);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(reservationsScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // suggestions de marque de voiture lors de la recherche
    private void showSuggestions(String input) {
        ObservableList<String> filteredSuggestions = FXCollections.observableArrayList();
        for (String suggestion : suggestions) {
            if (suggestion.toLowerCase().startsWith(input.toLowerCase())) {
                filteredSuggestions.add(suggestion);
            }
        }
        suggestionListView.setItems(filteredSuggestions);
        suggestionListView.setVisible(true);
    }

    // charger l'historique de reservation quand on clique sur le menu "historique
    @FXML
    private void handleReservation(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo/HistoriqueReserve.fxml"));
            Parent historiqueVue = loader.load();



            Scene historiqueScene = new Scene(historiqueVue);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(historiqueScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // se déconnecter quand on clique sur "deconnexion"
    @FXML
    private void handleLogout(ActionEvent event) {
        try {
            Parent loginVue = FXMLLoader.load(getClass().getResource("/org/example/demo/Login.fxml"));
            Scene loginScene = new Scene(loginVue);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
