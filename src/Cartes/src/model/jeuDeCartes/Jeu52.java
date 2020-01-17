package model.jeuDeCartes;

import model.carte.Carte;
import model.carte.Hauteur;
import model.carte.Symbole;
/**
 * 
 * @author M2103
 *
 */
public class Jeu52 extends JeuDeCartes {
    /**
     * @param nom
     */
    public Jeu52(String nom) {        
       super(nom);
    }
    
    @Override										
    public void remplirUnJeu(){
        for(int i=0; i < Symbole.values().length; i++){
            for(int j=0; j < Hauteur.values().length;j++)
                ajouterCarte(new Carte(Hauteur.values()[j],Symbole.values()[i]));
        }
    }
}
