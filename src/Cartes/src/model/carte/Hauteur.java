package model.carte;
/**
 * Défienit la hauteur d'une carte
 */
public enum Hauteur {
	
	DEUX(2),
	TROIS(3),
	QUATRE(4),
	CINQ(5),
	SIX(6),
	SEPT(7),
	HUIT(8),
	NEUF(9),
	DIX(10),
	VALET(11),
	DAME(12),
	ROI(13),
	AS(14);
	 
	private final int valeur;
	
    private Hauteur (final int val) {
    	this.valeur = val;
	  }
	 
	/**
	 * @return la valeur de la hauteur : int
	 */
	public int getValeur() {		
		return this.valeur;
	}
	    
	  @Override
	  public String toString(){
		switch(valeur){
		case 2: case 3: case 4: case 5:
        case 6: case 7: case 8: case 9: 
        case 10: return ""+valeur;
        case 11: return "Valet";
        case 12: return "Dame";
        case 13: return "Roi";
        case 14: return "As";
        default: return null;			
		}
		  
	  }	  

}
