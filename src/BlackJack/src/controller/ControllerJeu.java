package controller;

import model.blackJack.BlackJack;
import model.blackJack.Joueur;
import model.carte.Carte;
import view.Jeu;
import view.View;

import java.util.Iterator;
import java.util.List;

import model.blackJack.*;

public class ControllerJeu {
		private Jeu view;
	    public BlackJack model;

	    public ControllerJeu(Jeu view, List<Joueur> joueur) {
	        this.view = view;
	        model = new BlackJack(joueur);
	        this.initButton();
	    }
	    
	    public void sertCroupier() {
	    	while(model.servirCroupier()<16) 
	    		model.servirCroupier();
	    }
	        
	    private void initButton() {
	    	view.getTirer().addActionListener(e ->
	    	{
	    		Joueur j = model.getJoueurCourant();
	    		//le joueur a plus de 21
	    		if(model.isOut(j)) {
	    			//il n'y a plus de joueur dispo
	    			 if (model.plusDeProchainJoueur()) {
	    				 //on finit la partie
	    				this.finDePartie();
	    			 } else {
	    				 //on skip pour le prochain joueur
	    				 this.skipJoueur(j);
	    			 }
	    		}else {
	    			sertJoueur(j);
	    		}	
	    	});    	
	    	
	    	view.getPasser().addActionListener(e ->
	    	{
	    		Joueur j = model.getJoueurCourant();
	    		if(model.plusDeProchainJoueur()) {
	  				this.finDePartie();
	 			}else {
					 this.skipJoueur(j);
	 			}
	    	});
	    	
	    	view.getNouvellePartie().addActionListener(e ->
	    	{
	    		for (Joueur j : view.joueur) {
					j.resetTas();
				}
	    		view.fenetre.switchtoPlay(view.joueur);
	    	});
	    }
	    
	    private void sertJoueur(Joueur j) {
    		Carte c = model.servirJoueur(j);
    		view.addCard(j, c);
			System.out.println("GIVE : "+j);
	    }
	    
	    private void sertJoueurIA(Joueur j) {
	    	while(j.comptePoints() < 16) {
	    		sertJoueur(j);
	    	}
	    	skipJoueur(j);
	    }
	    
	    private void skipJoueur(Joueur j) {
			 if (model.skipJoueur()) {
				 System.out.println("SKIP");
				 if(model.getJoueurCourant().getType() == TypeJoueur.IA) {
					 this.desactivateButtons();
					 this.sertJoueurIA(model.getJoueurCourant());
				 } else {
					 this.activateButtons();
				 }
			 } else {
				 this.finDePartie();
			 }
	    }
	    
		private void finDePartie() {			
			this.desactivateButtons();
			sertCroupier();
			 view.actualiseCartesCroupier();
			 int valJ=model.getJoueurCourant().comptePoints();
			 int valC=model.getCroupier().comptePoints();
			 if(valJ > 21)
					view.partiePerdue();
				else if (valJ == 21)
					view.partieGagnéeBJ();
				else {
					if(valC<valJ || valC>21)
						view.partieGagnée();
					else if (valC > valJ)
						view.partiePerdue();
					else
						view.partieEgalite();
				}
			 view.afficherResultat();
			 System.out.println("FINISH");
		}
		
		private void desactivateButtons() {
			view.getTirer().setVisible(false); 
			view.getTirer().updateUI();
			view.getPasser().setVisible(false);
			view.getPasser().updateUI();
		}
		
		
		private void activateButtons() {
			view.getTirer().setVisible(true); 
			view.getTirer().updateUI();
			view.getPasser().setVisible(true);
			view.getPasser().updateUI();
		}
}
