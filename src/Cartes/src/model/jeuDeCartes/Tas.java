package model.jeuDeCartes;

import java.util.LinkedList;
import java.util.List;

import model.carte.Carte;

public class Tas {

    private List<Carte> lesCartes;
    private final String label;

    public Tas() {
        label = "";
        lesCartes = new LinkedList<Carte>();
    }

    /**
     * @param label du tas : String
     */
    public Tas(String label) {
        this.label = label;
        lesCartes = new LinkedList<Carte>();
    }

    /**
     *
     * @param le tas a copier : Tas
     */
    public Tas(Tas autreTas) {
        label = autreTas.label;
        lesCartes = new LinkedList<Carte>();
        for (Carte carte : autreTas.lesCartes) {
            lesCartes.add(carte);
        }
    }

    /**
     * @return lesCartes : List<Carte>
     */
    public List<Carte> getLesCartes() {
        return lesCartes;
    }

    /**
     * @return le label : String
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param lesCartes permettant de modifier la liste des cartes : List<Carte>
     */
    public void setLesCartes(List<Carte> lesCartes) {
        this.lesCartes = lesCartes;
    }

    /**
     *
     * @return enleve et renvoie la carte au sommet du tas : Carte
     */
    public Carte premiereCarte() {
        Carte premiere = (Carte) ((LinkedList<Carte>) lesCartes).removeFirst();
        return premiere;
    }

    /**
     *
     * @return indique si le tas est vide : boolean
     */
    public boolean estVide() {
        return lesCartes.isEmpty();
    }

    /**
     *
     * @param une Carte est ajoute sous le tas 
     */
    public void ajouterCarte(Carte uneCarte) {
        lesCartes.add(uneCarte);
    }

    /**
     *
     * @param tas dont les cartes sont ajoutees sous celles du tas appelant
     */
    public void ajouterTous(Tas tas) {
        lesCartes.addAll(tas.lesCartes);
    }

    /**
     *
     * @return la taille du paquet : int
     */
    public int getTaille() {
        return lesCartes.size();
    }

    /**
     *
     * @return la valeur du paquet : int
     */
    public int getValeur() {
        int valeur = 0;
        for (Carte carte : lesCartes) {
            valeur += carte.getValeur();
        }
        return valeur;
    }

    @Override
    public String toString() {
        return "" + lesCartes;
    }

}
