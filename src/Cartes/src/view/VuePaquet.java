package view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.jeuDeCartes.Tas;

public abstract class VuePaquet extends JPanel {

	protected Tas tas;
    protected final int HEIGHT = 150, WIDTH = 100;

	public VuePaquet(Tas tas) {
		super();
		this.tas = tas;

		this.setMaximumSize(new Dimension(400, 1920));
	}
}
