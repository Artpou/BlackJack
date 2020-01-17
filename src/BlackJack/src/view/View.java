package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import model.blackJack.*;

public class View extends JFrame {

	public JPanel fenetre;
	public BlackJack model;

	public View() {
		fenetre=new Menu(this);
		this.getContentPane().add(fenetre);
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void switchToSelection() {
		fenetre = new ChoisirJeu(this);
		this.getContentPane().removeAll();
		this.getContentPane().add(fenetre);
		fenetre.updateUI();
	}

	public void switchtoPlay(List<Joueur> joueurs) {
		fenetre = new Jeu(joueurs,this);
		this.getContentPane().removeAll();
		this.getContentPane().add(fenetre);
		fenetre.updateUI();
	}

	public void switchToCredits() {
		fenetre = new Credits(this);
		this.getContentPane().removeAll();
		this.getContentPane().add(fenetre);
		fenetre.updateUI();		
	}
	
	public void switchtoMenu() {
		fenetre=new Menu(this);
		this.getContentPane().removeAll();
		this.getContentPane().add(fenetre);
		fenetre.updateUI();
	}

	public void quit() {
		System.exit(0);
	}

}
