package org.example.demo;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Vehicule {
    private final SimpleStringProperty marque;
    private final SimpleStringProperty modele;
    private final SimpleDoubleProperty prixJournalier;

    public Vehicule(String marque, String modele, double prixJournalier) {
        this.marque = new SimpleStringProperty(marque);
        this.modele = new SimpleStringProperty(modele);
        this.prixJournalier = new SimpleDoubleProperty(prixJournalier);
    }

    // Getters et setters pour la marque
    public String getMarque() {
        return marque.get();
    }

    public void setMarque(String marque) {
        this.marque.set(marque);
    }

    public SimpleStringProperty marqueProperty() {
        return marque;
    }

    // Getters et setters pour le modèle
    public String getModele() {
        return modele.get();
    }

    public void setModele(String modele) {
        this.modele.set(modele);
    }

    public SimpleStringProperty modeleProperty() {
        return modele;
    }

    // Getters et setters pour le prix journalier
    public double getPrixJournalier() {
        return prixJournalier.get();
    }

    public void setPrixJournalier(double prixJournalier) {
        this.prixJournalier.set(prixJournalier);
    }

    public SimpleDoubleProperty prixJournalierProperty() {
        return prixJournalier;
    }

    // Méthode toString() pour l'affichage dans la console
    @Override
    public String toString() {
        return "Vehicule{" +
                "marque=" + marque.get() +
                ", modele=" + modele.get() +
                ", prixJournalier=" + prixJournalier.get() +
                '}';
    }
}


