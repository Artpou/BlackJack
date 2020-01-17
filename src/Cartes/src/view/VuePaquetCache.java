package view;

import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import model.carte.Carte;
import model.jeuDeCartes.Tas;

public class VuePaquetCache extends VuePaquet {

	/**
	 * Represente un tas de Carte face cache
	 * @param Tas
	 */
	public VuePaquetCache(Tas tas) {
		super(tas);
		this.setOpaque(false);
	    OverlayLayout overlay = new OverlayLayout(this);
		this.setLayout(overlay);

		int i = 0;
		JPanel carte = new JPanel();
	    JLayeredPane layout = new JLayeredPane();  
	    
		for (Carte c : tas.getLesCartes()) {
			carte = new VueCarteCache(c);
			carte.setBounds(i, i, carte.getWidth(), carte.getWidth());
			//carte.setSize(i, i);
			layout.add(carte);
			i++;
		}
		
		this.add(layout);
	}
}
