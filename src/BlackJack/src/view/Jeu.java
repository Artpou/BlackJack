package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.ControllerJeu;
import model.blackJack.BlackJack;
import model.blackJack.Joueur;
import model.carte.Carte;
import model.jeuDeCartes.JeuFactory;
import model.jeuDeCartes.TypeJeu;


public class Jeu extends JPanel{
		
	private JPanel paquetJoueurs, paquetBanque,banque;
	private JPanel paquet[], paquetCroupier;
	private JPanel actions;
	private Map<Joueur, JPanel> joueurPanel;
	private JButton tirer, passer, nouvellePartie;
    private JLabel score;
    public List<Joueur> joueur;
	
	public BlackJack model;
	public View fenetre;
	private ControllerJeu controller;
	
	/**
	 * Affiche le choix des options du jeu (nombre de joueurs, IA)
	 */
	public Jeu(List<Joueur> joueur, View view) {
		this.setContent(); 
		this.fenetre = view;
		this.joueur = joueur;
		this.controller = new ControllerJeu(this,joueur);
		this.model = controller.model;
		this.setController();
	}
	
	/**
	 * Initialise le contenu
	 */
	private void setContent() {
		initialisationPanelPrincipal();
		initialisationPanelBanque();
		initialisationPanelActions();
	}
	
	/**
	 * Initialise le Panel principal
	 */
	public void initialisationPanelPrincipal() {
		this.setBackground(Color.decode("#037B62"));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		
		this.setSize(1280,720);
	}
	
	/**
	 * Initialise le Panel de la Banque
	 */
	public void initialisationPanelBanque() {
		this.paquetBanque = new JPanel();
		this.paquetBanque.setLayout(new GridLayout(0, 2));
		this.paquetBanque.setOpaque(false);
		
		this.banque = new JPanel();
		this.banque.setOpaque(false);
		this.paquetBanque.add(new VuePaquetCache(JeuFactory.creerJeuDeCartes(TypeJeu.Jeu32)));
		paquetBanque.add(banque);
		
		this.add(paquetBanque);
	}
	
	/**
	 * Initialise le Panel des Joueurs
	 */
	private void initialisationPanelJoueurs() {
		this.joueurPanel = new HashMap<Joueur, JPanel>();
		this.paquetJoueurs = new JPanel();
		this.paquetJoueurs.setLayout(new GridLayout(2,this.model.getNbJoueur()));
		this.paquetJoueurs.setOpaque(false);
		for (Joueur j : this.model.getJoueurs()) {
			this.joueurPanel.put(j, new JPanel());
			actualiseCartesJoueur(j);
			this.paquetJoueurs.add(this.joueurPanel.get(j));
		}
		
		this.add(this.paquetJoueurs);
	}

	
	/**
	 * Initialise le Panel des Actions
	 */
	private void initialisationPanelActions() {
		actions = new JPanel();
		actions.setOpaque(false);
		tirer = new JButton("tirer");
		passer = new JButton("passer");
		actions.add(this.tirer);
		score = new JLabel("Score actuel : 0");
		actions.add(score);
		actions.add(passer);
		nouvellePartie = new JButton("Nouvelle Partie");
		this.add(actions);
	}

	/**
	 * Affiche le résultat de la partie
	 */
	public void afficherResultat() {
		for (Joueur j : model.getJoueurs()) {
			switch (model.getResultat(j)) {
			case -1:
				joueurPanel.get(j).add(new JLabel(" PERDU "));
				break;
			case 0:
				joueurPanel.get(j).add(new JLabel(" EGALITE "));
				break;
			case 1:
				joueurPanel.get(j).add(new JLabel(" GAGNE "));
				break;
			default:
				joueurPanel.get(j).add(new JLabel(" ERREUR "));
				break;
			}
		}
	}
	

	/**
	 * Initialise le controller 
	 */
	private void setController() {
        initialisationPanelJoueurs();
	}

	/**
	 * Ajoute une carte au tas d'un joueur
	 * @param le joueur auquel ajouter une carte : Joueur
	 * @param la carte à ajouter : Carte
	 */
	public void addCard(Joueur j, Carte c) {
		joueurPanel.get(j).add(new VueCarteVisible(c));
		joueurPanel.get(j).updateUI();
		if(j == model.getJoueurCourant()) {
			score.setText("Score actuel "+model.getJoueurCourant().comptePoints());
			score.updateUI();
		}
	}
	
	/**
	 * Actualise les cartes du croupier
	 */
	public void actualiseCartesCroupier() {
		banque.removeAll();
		banque.setOpaque(false);
		this.banque.add(new JLabel("Banque : "));
		for (Carte c : model.getCroupier().getJeu().getLesCartes()) {
			banque.add(new VueCarteVisible(c));
		}
		paquetBanque.updateUI();
		
	}
	
	/**
	 * Actualise les cartes d'un joueur
	 * @param Joueur
	 */
	public void actualiseCartesJoueur(Joueur j) {
		joueurPanel.get(j).removeAll();
		joueurPanel.get(j).setOpaque(false);
		joueurPanel.get(j).add(new JLabel(j.getNom()+" : "));
		for (Carte c : j.getJeu().getLesCartes()) {
			joueurPanel.get(j).add(new VueCarteVisible(c));
		}
	}
	
	/**
	 * Finis la partie 
	 */
	public void partieFinis() {
		controller.sertCroupier();
		actualiseCartesCroupier();
		actions.add(nouvellePartie);
		actions.updateUI();
	}
	
	public void partieGagnée() {
		partieFinis();
		score.setText("Vous avez gagné.");
		score.updateUI();
	}
	
	public void partieGagnéeBJ() {
		partieFinis();
		score.setText("Vous avez fait blackjack !");
		score.updateUI();
	}
	
	public void partiePerdue() {
		partieFinis();
		score.setText("Vous avez perdu.");
		score.updateUI();
	}
	
	public void partieEgalite() {
		partieFinis();
		score.setText("Vous faites égalité, vous conservez votre mise.");
		score.updateUI();
	}

	public JButton getTirer() {
		return tirer;
	}

	public JButton getPasser() {
		return passer;
	}
	
	public JButton getNouvellePartie() {
		return nouvellePartie;
	}
}
