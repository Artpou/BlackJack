package model.carte;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import model.carte.*;

/**
 * CarteImgBuilder
 */
public class CarteImgBuilder {

    private static BufferedImage allCardsImg;
    private static final int width = 73;
    private static final int height = 98;

    private static List<BufferedImage> allCards = new ArrayList<BufferedImage>();

    /**
     * Retourne une image de la carte en format BufferedImage
     * @param card : La carte à afficher
     * @return la Carte en tant qu'image : BufferedImage
     */
    public static BufferedImage getCardImg(Carte card) {
        if (!isCardsSet()) {
            createCards();
        }
        int index = 0;
        if (card.getSymbole() == Symbole.PIQUE) index += 13;
        else if (card.getSymbole() == Symbole.COEUR) index += 13*2;
        else if (card.getSymbole() == Symbole.CARREAU) index += 13*3;

        if(!(card.getHauteur() == Hauteur.AS)) {
            index += card.getValeur()-1;
        }
        return allCards.get(index);
    }
    
    /**
     * Retourne une image de la carte caché
     * @param card : La carte à afficher
     * @return la Carte en tant qu'image : BufferedImage
     */
    public static BufferedImage getHiddenCardImg(Carte card) {
    	BufferedImage CardImg = null;
    	try {
        	CardImg = ImageIO.read(CarteImgBuilder.class.getResource("res/cardHidden.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CardImg;
    }
    
    /**
     * Retourne une image de la carte en format BufferedImage en spécifiant la hauteur et la largeur souhaité
     * @param card : La carte à afficher
     * @param width : largeur souhaité
     * @param height : hauteur souhaité
     * @return la Carte en tant qu'image : BufferedImage
     */
    public static BufferedImage getCardImg(Carte card,int width, int height) {
    	return CarteImgBuilder.resize(CarteImgBuilder.getCardImg(card),width,height);
    }
    
    /**
     * Retourne une image de la carte caché en spécifiant la hauteur et la largeur souhaité
     * @param card : La carte à afficher
     * @param width : largeur souhaité
     * @param height : hauteur souhaité
     * @return la Carte en tant qu'image : BufferedImage
     */
    public static BufferedImage getHiddenCardImg(Carte card,int width, int height) {
    	return CarteImgBuilder.resize(CarteImgBuilder.getHiddenCardImg(card),width,height);
    }
    
    /**
     * Permet de recadrer une image
     * @param img : l'image à recadrer
     * @param newW : largeur souhaité
     * @param newH : hauteur souhaité
     * @return La nouvelle image recadré : BufferedImage
     */
    private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    /**
     * Retourne si la est définit
     * @return : boolean
     */
    private static boolean isCardsSet() {
        return (allCards.size() > 0);
    }

    /**
     * Permet de créer la carte
     */
    private static void createCards() {

        try {
        	allCardsImg = ImageIO.read(CarteImgBuilder.class.getResource("res/cards.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage tmpImg;

        for (int ligne = 0; ligne < 4; ligne++) {
            for (int num = 0; num < 13; num++) {
                tmpImg = allCardsImg.getSubimage(
                    num*width,
                    ligne*height,
                    width,
                    height);
                allCards.add(tmpImg);
            }
        }
    } 
}