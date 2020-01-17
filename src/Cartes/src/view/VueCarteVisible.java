package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.carte.Carte;
import model.carte.CarteImgBuilder;

public class VueCarteVisible extends VueCarte {

    public VueCarteVisible(Carte carte) {
        super(carte);
    }

    /**
     * Affiche la carte face visible
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(CarteImgBuilder.getCardImg(carte,WIDTH,HEIGHT), 0, 0, this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}