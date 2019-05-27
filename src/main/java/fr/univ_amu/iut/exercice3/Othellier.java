package fr.univ_amu.iut.exercice3;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.List;


public class Othellier extends GridPane {

    private static final Point2D[] directions = {
            new Point2D(1, 0),
            new Point2D(1, 1),
            new Point2D(0, 1),
            new Point2D(-1, 1),
            new Point2D(-1, 0),
            new Point2D(-1, -1),
            new Point2D(0, -1),
            new Point2D(1, -1)
    };
    private final EventHandler<ActionEvent> caseListener = event -> {
    };
    private int taille;
    private Case[][] cases;
    private ObjectProperty<Joueur> joueurCourant = new SimpleObjectProperty<>(Joueur.NOIR);

    public Othellier() {

    }

    public ObjectProperty<Joueur> joueurCourantProperty() {
    }

    private void remplirOthelier(int taille) {
    }

    private void adapterLesLignesEtColonnes() {
        for (int i = 0; i < taille; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(Priority.ALWAYS);
            getColumnConstraints().add(column);
        }

        for (int i = 0; i < taille; i++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.ALWAYS);
            getRowConstraints().add(row);
        }
    }

    private void positionnerPionsDebutPartie() {
        cases[taille/2-1] [taille/2-1].setPossesseur(Joueur.BLANC);
        Joueur.BLANC.incrementerScore();
        cases[taille/2-1] [taille/2].setPossesseur(Joueur.NOIR);
        Joueur.NOIR.incrementerScore();
        cases[taille/2] [taille/2-1].setPossesseur(Joueur.NOIR);
        Joueur.NOIR.incrementerScore();
        cases[taille/2] [taille/2].setPossesseur(Joueur.BLANC);
        Joueur.BLANC.incrementerScore();
    }


    public void nouvellePartie() {
        joueurCourant.set(Joueur.NOIR);
        vider();
        positionnerPionsDebutPartie();
    }

    private boolean peutJouer() {
    }

    private List<Case> casesJouables() {
    }

    private List<Case> casesCapturable(Case caseSelectionnee) {
        List<Case> casesCapturable = new ArrayList<>();

        for (Point2D direction : directions) {
            casesCapturable.addAll(casesCapturable(caseSelectionnee, direction));
        }

        return casesCapturable;
    }

    private List<Case> casesCapturable(Case caseSelectionnee, Point2D direction) {
        List<Case> casesCapturable = new ArrayList<>();

        int indiceLigne = caseSelectionnee.getLigne() + (int) direction.getY();
        int indiceColonne = caseSelectionnee.getColonne() + (int) direction.getX();

        while (estIndicesValides(indiceLigne, indiceColonne)) {
            if (cases[indiceLigne][indiceColonne].getPossesseur() != joueurCourant.get().suivant())
                break;

            casesCapturable.add(cases[indiceLigne][indiceColonne]);

            indiceLigne += direction.getY();
            indiceColonne += direction.getX();
        }

        if (estIndicesValides(indiceLigne, indiceColonne) &&
                cases[indiceLigne][indiceColonne].getPossesseur() == joueurCourant.get())
            return casesCapturable;
        return new ArrayList<>();
    }

    private boolean estIndicesValides(int indiceLigne, int indiceColonne) {
    }

    private boolean estIndiceValide(int indiceColonne) {
    }

    private boolean estPositionJouable(Case caseSelectionnee) {
    }

    private void capturer(Case caseCapturee) {
    }

    public Joueur getJoueurCourant() {
    }

    private void tourSuivant() {
    }

    private void vider() {
        for (int i = 0; i < taille; i++){
            for (int j = 0; j < taille; j++){
                cases[i][j].setPossesseur(Joueur.PERSONNE);
            }
        }
        Joueur.BLANC.scoreProperty().set(0);
        Joueur.NOIR.scoreProperty().set(0);
    }
}
