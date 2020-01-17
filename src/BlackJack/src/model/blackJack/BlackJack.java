package model.blackJack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.carte.Carte;
import model.blackJack.*;
import model.jeuDeCartes.Tas;

public class BlackJack {

	private Croupier croupier;
	private List<Joueur> joueurs;
	private List<Joueur> enJeu;
	private Joueur joueurCourant;

	public BlackJack(List<Joueur> joueurs) {
		this.joueurs = joueurs;
		this.croupier  = new Croupier();
		this.initialiseJeu();
	}

	public static BlackJack jeuTest() {
		List<Joueur> joueurs = new ArrayList<>();
		joueurs.add(new JoueurJouable("j1"));
		BlackJack jeu = new BlackJack(joueurs);
		return jeu;
	}

	public void initialiseJeu() {
		enJeu=new ArrayList<Joueur>();
		enJeu.addAll(joueurs);
		for (Joueur joueur : enJeu) {
			System.out.println("joueur "+ joueur.getNom()+" tire: "+croupier.servirJoueur(joueur)+"\n");
		}
		joueurCourant = enJeu.get(0);
	}
	
	public Croupier getCroupier() {
		return croupier;
	}

	public void tourJoueurs() {
		while(!enJeu.isEmpty()) {
			Iterator<Joueur> iterator = enJeu.iterator();
			while (iterator.hasNext()) {
				if(!demanderCarte(iterator.next())) {
					iterator.remove();
					enJeu.remove(iterator);
				}
			}
		}
	}

	public boolean demanderCarte(Joueur j) {
		Scanner sc = new Scanner(System.in);
		System.out.println(j.getNom() +": score total : "+j.comptePoints());
		System.out.println("0: passe \n1: tire");
		if(j.comptePoints() < 21 && sc.nextInt() == 1) {
			System.out.println("carte obtenu : "+croupier.servirJoueur(j));
			System.out.println("score total : "+j.comptePoints()+"\n");
			return true;
		}else {
			return false;
		}
	} 
	
	public int servirCroupier() {
			System.out.println("carte obtenu : " + croupier.servirCroupier());
		return croupier.comptePoints();
	}
	
	public Carte servirJoueur(Joueur j) {
		return croupier.servirJoueur(j);
	}

	private int comptePoints(Tas tas) {
		int pts = 0;
		for (Carte c : tas.getLesCartes()) {
			if(c.getHauteur().getValeur() == 14) {
				pts += 11; 
			} else if (c.getHauteur().getValeur() > 9) {
				pts += 10;
			} else {
				pts += c.getHauteur().getValeur();
			}
		}
		return pts;
	}

	public void jouer() {
		initialiseJeu();
		tourJoueurs();
		afficherScore();
	}

	public void afficherScore() {
		servirCroupier();
		for (Joueur joueur : joueurs) {
			getResultat(joueur);
		}
	}
	
	public int getResultat(Joueur joueur) {
		int valC= croupier.comptePoints();
		int valJ=joueur.comptePoints();
		System.out.println("joueur "+ joueur.getNom()+" score : "+valJ+"\n");
		if(valJ > 21) {
			System.out.println("Perdu !");
			return -1;
		}else if (valJ == 21) {
			System.out.println("Gagné : BlackJack !");
			return 1;
		}else {
			System.out.println("valeur croupier : "+valC);
			if(valC < valJ || valC>21) {
				System.out.println("Gagné !");
				return 1;
			}else if (valC > valJ) {
				System.out.println("Perdu !");
				return -1;
			}else {
				System.out.println("Egalité !");
				return 0;
			}
		}
	}
	
	public int getNbJoueur() {
		return joueurs.size();
	}
	
	public Joueur getJoueurCourant() {
		return joueurCourant;
	}
	
	public boolean isOut(Joueur j) {
		return j.comptePoints() > 21;
	}
	
	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public boolean skipJoueur() {
		if(!plusDeProchainJoueur()) {
			enJeu.remove(joueurCourant);
			joueurCourant = enJeu.get(0);
			return true;
		}
		return false;
	}
	

	public boolean plusDeProchainJoueur() {
		return enJeu.size() <= 1;
	}
	
	
	public static void main(String[] args) {
		BlackJack jeu = jeuTest();
		jeu.jouer();
	}

}
