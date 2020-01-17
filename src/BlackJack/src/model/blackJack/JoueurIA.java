package model.blackJack;
import model.jeuDeCartes.Tas;

public class JoueurIA extends Joueur{

	public JoueurIA(String nom) {
		super(nom);
		this.type = TypeJoueur.IA;
	}
	
    /**
     * Le joueur identifié par son jeu
     * @param jeu : Tas
     */		
	public JoueurIA(Tas jeu) {
		super(jeu);
		this.type = TypeJoueur.IA;
	}
		
}
