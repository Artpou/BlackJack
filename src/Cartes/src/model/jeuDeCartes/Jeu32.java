package model.jeuDeCartes;

import model.carte.*;

/**
 * 
 * @author M2103
 *
 */
public class Jeu32 extends JeuDeCartes {

    
    /**
     * @param nom
     */
    public Jeu32(String nom) {        
       super(nom);
    }
    
    @Override
    public void remplirUnJeu(){
        for(int i=0; i<Symbole.values().length; i++){
            for(int j=5; j<Hauteur.values().length;j++)
                ajouterCarte(new Carte(Hauteur.values()[j],Symbole.values()[i]));
        }
    }
}
