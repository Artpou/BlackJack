package model.carte;

/**
 * @author M2103
 *
 */
public class Carte implements Comparable<Carte> {
	
    private final Hauteur hauteur;
    private final Symbole symbole;
    /**
     * @param hauteur de la carte
     * @param symbole de la carte
     */
    public Carte(Hauteur hauteur, Symbole symbole) {
        this.hauteur = hauteur;
        this.symbole = symbole;
    }

    /**
     * @return la hauteur de la carte
     */
    public Hauteur getHauteur() {
        return hauteur;
    }

    /**
     * @return le symbole de la carte
     */
    public Symbole getSymbole() {
        return symbole;
    }

    public int getValeur() {
        return hauteur.getValeur();
    }

    /**
     * @return String representant une carte. Par exemple: Dame de Pique
     */
    @Override
    public String toString() {
        return hauteur + " de " + symbole;
    }

    /**
     * @return la comparaison d'une carte à une autre. Par exemple : -2
     */
    @Override
    public int compareTo(Carte autre) {
        return hauteur.getValeur() - autre.getHauteur().getValeur();
    }

}
