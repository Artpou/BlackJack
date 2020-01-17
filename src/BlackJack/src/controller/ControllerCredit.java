package controller;

import view.Credits;

public class ControllerCredit {
	
	private Credits view;
	
	public ControllerCredit(Credits view) {
        this.view = view;
        this.initButton();
    }
        
    private void initButton() {
    	view.getRetour().addActionListener(e ->
    	{
    		view.fenetre.switchtoMenu();
    	});
    }
}
