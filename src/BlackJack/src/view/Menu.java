package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.ControllerMenu;
import model.blackJack.BlackJack;

public class Menu extends JPanel {

	private JPanel boutons;
	private JButton jouer, credits, quitter;
	
	public View fenetre;
	private ControllerMenu controller;
	
	public Menu(View view) {
		this.fenetre = view;
		this.setContent();
		this.controller = new ControllerMenu(this);
	}
	
	private void setContent() {
		this.setLayout(new GridLayout(3, 0));
		jouer = new JButton("Jouer");
		credits = new JButton("Crédits");
		quitter = new JButton("Quitter");
		boutons = new JPanel();
		boutons.setOpaque(false);
		boutons.add(jouer);
		boutons.add(credits);
		boutons.add(quitter);
		this.add(boutons);
	}
	
	public JButton getJouer() {
		return jouer;
	}
	
	public JButton getCredits() {
		return credits;
	}
	
	public JButton getQuitter() {
		return quitter;
	}

}
