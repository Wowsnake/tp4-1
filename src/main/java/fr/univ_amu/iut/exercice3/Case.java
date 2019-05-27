package fr.univ_amu.iut.exercice3;


import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

class Case extends Button {
    private int ligne;
    private int colonne;
    private Joueur possesseur;
    private ImageView imageView;

    public Case(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        possesseur = Joueur.PERSONNE;
        setHeight(50);
        setWidth(50);
        imageView.fitHeightProperty().bind(heightProperty());
        imageView.fitWidthProperty().bind(widthProperty());
    }

    public Joueur getPossesseur() {
        return possesseur;
    }

    public void setPossesseur(Joueur possesseur) {
        this.possesseur = possesseur;
        imageView.setImage(possesseur.getImage());
    }

    public int getLigne() {
        return ligne;

    }

    public int getColonne() {
        return colonne;
    }
}
