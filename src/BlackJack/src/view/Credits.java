package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControllerCredit;

public class Credits extends JPanel {
	
	public View fenetre;
	private ControllerCredit controller;
	private JButton retour;
	
	public Credits(View view) {
		this.fenetre = view;
		this.setContent();
		this.controller = new ControllerCredit(this);
	}
	
	private void setContent() {
		this.add(new JLabel("<html>"
				+ "Application développé par : <br>"
				+ "Amiour Amine <br>"
				+ "Pierre-Auguste Cédric <br>"
				+ "Arthur Poullin <br><br>"
				+ "dans le cadre de notre Licence Informatique"
				+ "</html>"));
		
		retour = new JButton("retour au menu");
		this.add(retour);
	}

	public JButton getRetour() {
		return retour;
	}
}
