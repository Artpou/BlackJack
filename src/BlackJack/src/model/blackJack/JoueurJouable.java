package model.blackJack;

import model.jeuDeCartes.Tas;

public class JoueurJouable extends Joueur {

	public JoueurJouable(String nom) {
		super(nom);
		this.type = TypeJoueur.Jouable;
	}
	
    public JoueurJouable(Tas jeu) {
		super(jeu);
		this.type = TypeJoueur.Jouable;
    }
	
}
