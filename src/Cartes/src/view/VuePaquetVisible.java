package view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.carte.Carte;
import model.jeuDeCartes.Tas;

public class VuePaquetVisible extends VuePaquet {

	/**
	 * Represente un tas de Carte face visible
	 * @param Tas
	 */
	public VuePaquetVisible(Tas tas) {
		super(tas);

		JPanel cartes = new JPanel();
		for (Carte c : tas.getLesCartes()) {
			cartes.add(new VueCarteVisible(c));
		}
		this.add(cartes);
	}

    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT+80);
    }
}
