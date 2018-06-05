package vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import modele.Evenement;


public class PanelDetailsEvenement extends JPanel
	{
	private JTextField leTexte;
	private JLabel leTitre;
	private JLabel laImage;
	
	public PanelDetailsEvenement(Evenement parEvt) throws IOException
		{
		JPanel lePanel = new JPanel();
		JPanel lePanel2 = new JPanel();
		
		lePanel.setLayout(new BoxLayout(lePanel, BoxLayout.LINE_AXIS));
		
		
		
		leTexte = new JTextField("Lalala");
		leTitre = new JLabel(parEvt.getChNom());
		laImage = new JLabel(new ImageIcon("images/blank.png"));
		
		lePanel.add(laImage);
		lePanel2.add(leTitre);
		lePanel2.add(leTexte);
		
		this.add(lePanel);
		this.add(lePanel2);
		
		JPanel card0 = new JPanel();
		
		
		}
	private void createCard()
		{
		
		}
	}