package controller;

import java.util.ArrayList;
import java.util.List;

import model.blackJack.Joueur;
import model.blackJack.JoueurIA;
import model.blackJack.JoueurJouable;
import view.ChoisirJeu;
import view.SelectionJoueur;

public class SelectionJoueurController {

	private ChoisirJeu view;
	
	public SelectionJoueurController(ChoisirJeu view) {
		this.view=view;
		this.initButton();
	}
	
	private void initButton() {
    	view.getJouer().addActionListener(e ->
    	{
    		view.fenetre.switchtoPlay(this.creerListJoueur()); 
    	});
    }
	
	private List<Joueur> creerListJoueur() {
		ArrayList<Joueur> joueurList = new ArrayList<Joueur>();
		int i = 1;
		for(SelectionJoueur j : view.joueur) {
			switch(j.getType()) {
				case "Joueur":
					joueurList.add(new JoueurJouable("J"+i));
					i++;
					break;
				case "IA":
					joueurList.add(new JoueurIA("J"+i));
					i++;
					break;
				default:
					break;
			}
		}
		return joueurList;
	}
}
