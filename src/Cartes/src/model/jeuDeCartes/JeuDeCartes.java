package model.jeuDeCartes;

import java.util.LinkedList;
import java.util.List;

import model.carte.Carte;


public abstract class JeuDeCartes extends Tas {

    /**
     *
     * @param nom du jeu
     */
    public JeuDeCartes(String nom) {
        super(nom);
    }

    /**
     *
     */
    public abstract void remplirUnJeu();

    /**
     *
     * @return l'emplacement de coupe aléatoire parmi le tas de
     * cartes : int
     */
    public int couper() {
        int val = 0;
        for (int i = 0; i < getTaille(); i++) {
            if (Math.random() < 0.5) {
                val++;
            }
        }
        return val;
    }

    /**
     * On divise le tas en 2 puis on ajoute le 2eme tas au dessus du premier
     * @return resultat : Tas
     */
    private Tas diviser() {
        Tas resultat = new Tas();
        int c = couper();
        for (int i = 0; i < c; i++) {
            resultat.ajouterCarte(premiereCarte());
        }
        return resultat;
    }

    /**
     * On mélange un paquet passer en parametre
     * @param paquet à melanger : Tas
     */
    private void melangerCartes(Tas paquet) {
        List<Carte> resultat = new LinkedList<Carte>();
        while (!paquet.estVide() && !estVide()) {
            double p = ((double) paquet.getTaille()) / ((double) paquet.getTaille() + getTaille());
            if (Math.random() < p) {
                resultat.add(paquet.premiereCarte());
            } else {
                resultat.add(premiereCarte());
            }
        }

        resultat.addAll(paquet.getLesCartes());
        resultat.addAll(this.getLesCartes());
        setLesCartes(resultat);
    }

    /**
     *
     * Permet de mélanger un paquet plusieurs fois
     * @param nombre de melange : int
     */
    public void battre(int n) {
        for (int i = 0; i < n; i++) {
            Tas tmp = diviser();
            melangerCartes(tmp);
        }
    }

}
