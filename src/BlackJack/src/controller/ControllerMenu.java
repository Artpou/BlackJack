package controller;

import model.blackJack.Joueur;
import model.carte.Carte;
import view.Menu;

public class ControllerMenu {
	
	private Menu view;
	
	public ControllerMenu(Menu view) {
		this.view=view;
		this.initButton();
	}
	
	private void initButton() {
    	view.getJouer().addActionListener(e ->
    	{
    		view.fenetre.switchToSelection();
    	});
    	
    	view.getCredits().addActionListener(e ->
    	{
    		view.fenetre.switchToCredits();
    	});
    	
    	view.getQuitter().addActionListener(e ->
    	{
    		view.fenetre.quit();
    	});
    	
    }
}
