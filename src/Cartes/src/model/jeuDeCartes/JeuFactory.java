/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.jeuDeCartes;

public class JeuFactory {
    
	/**
	 * Créer un jeu de carte en fonction de son type
	 * @param Le type du jeu : TypeJeu
	 * @return le nouveau Jeu créée : JeuDeCartes
	 */
    public static JeuDeCartes creerJeuDeCartes(TypeJeu type) {
    	JeuDeCartes j=null;
    	switch (type) {
		case Jeu32:
	        j = new Jeu32("jeu");
			break;
			
		case Jeu52:
	        j = new Jeu52("jeu");
			break;

		default:
			System.err.println("ERROR : TypeJeu inconnu");
			break;
		}
        j.remplirUnJeu();
        return j;
    }
    
}
