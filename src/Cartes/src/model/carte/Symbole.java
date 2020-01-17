/**
 * 
 */
package model.carte;

/**
 * Définit le symbole d'une carte
 */
public enum Symbole {
     PIQUE (Couleur.NOIR),
     CARREAU(Couleur.ROUGE),
     COEUR (Couleur.ROUGE),
     TREFLE(Couleur.NOIR);

     private Couleur couleur;

     private Symbole (final Couleur couleur) {
          this.couleur = couleur;
     }

     /**
      * @return La couleur de la carte en fonction de son symbole : Couleur
      */
     public Couleur getCouleur() {		
		return this.couleur;
	}
}
