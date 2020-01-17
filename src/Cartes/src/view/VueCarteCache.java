package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.carte.Carte;
import model.carte.CarteImgBuilder;

public class VueCarteCache extends VueCarte {

    public VueCarteCache(Carte carte) {
        super(carte);
    }

    /**
     * Affiche la carte face cache
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(CarteImgBuilder.getHiddenCardImg(carte,WIDTH,HEIGHT), 0, 0, this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}