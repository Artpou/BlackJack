package model.blackJack;

import java.util.List;

import model.carte.Carte;
import model.jeuDeCartes.JeuDeCartes;
import model.jeuDeCartes.JeuFactory;
import model.jeuDeCartes.Tas;
import model.jeuDeCartes.TypeJeu;

/**
 * Croupier
 */
public class Croupier {

    private JeuDeCartes paquet;
    private Tas jeu;

    /**
     * Le croupier de la partie
     */
    public Croupier() {
        paquet = JeuFactory.creerJeuDeCartes(TypeJeu.Jeu52);
        jeu = new Tas();
        paquet.battre(10);
    }

    public JeuDeCartes getPaquet() {
        return this.paquet;
    }

    public Tas getJeu() {
        return this.jeu;
    }

    /**
     * sert la première carte du paquet au croupier
     * @return Carte
     */
    public Carte servirCroupier() {
        Carte c = paquet.premiereCarte();
        this.jeu.ajouterCarte(c);
        return c;
    }

    /**
     * sert la première carte du paquet au joueur
     * @param Joueur à servir : Joueur
     * @return Carte
     */
    public Carte servirJoueur(Joueur j) {
        Carte c = paquet.premiereCarte();
        j.recevoirCarte(c);
        return c;
    }
    
    /**
     * Compte les points du jeu du croupier
     * @return points : int
     */
    public int comptePoints() {
		int pts = 0;
		int[] valAs = new int[4];
		valAs[0]=0;valAs[1]=0;valAs[2]=0;valAs[3]=0;
		int i=0;
		for (Carte c : jeu.getLesCartes()) {
			if(c.getHauteur().getValeur() == 14) {
				if(pts+11<=21) {
					valAs[i]=11;
					pts += valAs[i];
				}else {
					valAs[i]=1;
					pts += valAs[i];
				}
				i++;
			} else if (c.getHauteur().getValeur() > 9) {
				pts += 10;
			} else {
				pts += c.getHauteur().getValeur();
			}
		}
		if(pts>21) {
			for (Carte c: jeu.getLesCartes()) {
				if(c.getHauteur().getValeur()==14){
					for(int j=0;j<4;j++) {
						if(valAs[j]==11) {
							valAs[j]=1;
							pts-=10;
							break;
						}
					}
				}
					
			}
		}
		return pts;
	}
	
    @Override
    public String toString() {
        return "{" +
            " paquet='" + getPaquet() + "'" +
            ", jeu='" + getJeu() + "'" +
            "}";
    }

}