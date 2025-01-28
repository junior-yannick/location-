package org.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/demo/Login.fxml"));
        primaryStage.setTitle("Système de location de véhicules");
        Scene scene = new Scene(root);

        // Ajout du fichier CSS
        String cssFile = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(cssFile);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
