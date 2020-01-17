package view;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class SelectionJoueur extends JPanel {

	private String[] elements = new String[] {"Aucun","IA","Joueur"};
	private JComboBox listeType;
	
	public SelectionJoueur(int num) {
        this.setLayout(new GridLayout(2,0));
        if(num == 1) {
        	listeType = new JComboBox<String>(new String[] {"Joueur"});
        } else {
    		listeType = new JComboBox<String>(elements);
        }
		this.add(new JLabel("Joueur "+num));
		this.add(listeType);
	}
	
	public String getType() {
		return listeType.getSelectedItem().toString();
	}
}
