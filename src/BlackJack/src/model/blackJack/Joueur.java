package model.blackJack;

import model.carte.Carte;
import model.jeuDeCartes.*;

/**
 * Joueur
 */
public abstract class Joueur {

    protected Tas jeu;
    protected String nom;
    protected TypeJoueur type;

    /**
     * Le joueur identifié par son nom
     * @param nom : String
     */
    public Joueur(String nom) {
        this.nom = nom;
        jeu = new Tas();
    }

    /**
     * Le joueur identifé par son jeu
     * @param jeu
     */
    public Joueur(Tas jeu) {
        this.jeu = jeu;
    }

    public Tas getJeu() {
        return this.jeu;
    }

    public String getNom() {
        return this.nom;
    }
    
    public TypeJoueur getType() {
    	return this.type;
    }

    /**
     * reçois une carte et l'ajoute à son 
     * @param Carte
     */
    public void recevoirCarte(Carte c) {
        this.jeu.ajouterCarte(c);
    }
    
    /**
     * Compte les points du jeu du Joueur
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
	
	public void resetTas() {
        jeu = new Tas();
	}
	
    @Override
    public String toString() {
        return getNom() + " : {" +
            " jeu='" + getJeu() + "'" +
            "}";
    }

}