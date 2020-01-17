package view;

import javax.swing.JPanel;

import model.carte.Carte;

/**
 * VueCarte
 */
public class VueCarte extends JPanel {
    
    protected Carte carte;
    protected final int HEIGHT = 150, WIDTH = 100;

    /**
     * Represente une carte
     * @param Carte
     */
    public VueCarte(Carte carte) {
        this.carte = carte;
    }
    
    @Override
    public int getHeight() {
    	return HEIGHT;
    }
    
    @Override
    public int getWidth() {
    	return WIDTH;
    }
    
}