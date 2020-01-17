package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.blackJack.*;
import controller.ControllerMenu;
import controller.SelectionJoueurController;

public class ChoisirJeu extends JPanel {

	public View fenetre;
	public SelectionJoueur[] joueur;
	private JButton jouer;
	private SelectionJoueurController controller;
	
	/**
	 * Affiche le choix des options du jeu (nombre de joueurs, IA)
	 */
	public ChoisirJeu(View view) {
		this.fenetre = view;
		this.setContent();
		this.controller = new SelectionJoueurController(this);
	}
	
	/**
	 * Initialise le contenu
	 */
	private void setContent() {		
		int maxJoueur = 4;
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		joueur = new SelectionJoueur[maxJoueur];
		
		for(int i = 0; i < maxJoueur;i++) {
			joueur[i] = new SelectionJoueur(i+1);
			this.add(joueur[i]);
		}
		
		jouer = new JButton("Jouer");
		this.add(jouer);
	}
	
	public JButton getJouer() {
		return jouer;
	}
}
