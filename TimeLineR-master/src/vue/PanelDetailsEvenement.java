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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modele.Evenement;


public class PanelDetailsEvenement extends JPanel
	{
	private JTextArea leTexte;
	private JLabel leTitre;
	private JLabel laImage;
	
	public PanelDetailsEvenement(Evenement parEvt) throws IOException
		{
		JPanel lePanel = new JPanel();
		JPanel lePanel2 = new JPanel();
		
		this.setLayout(new GridLayout(1, 0));
		lePanel.setLayout(new GridLayout(0, 1));
		lePanel2.setLayout(new BoxLayout(lePanel2, BoxLayout.PAGE_AXIS));
		
		
		leTexte = new JTextArea(parEvt.getChDesc());
		leTexte.setEditable(false);
		leTitre = new JLabel(parEvt.getChNom());
		laImage = new JLabel(new ImageIcon("images/blank.png"));
		
		
		lePanel.add(leTitre);
		lePanel.add(leTexte);
		this.add(laImage);
		this.add(lePanel);
		
		
		JPanel card0 = new JPanel();
		
		
		}
	private void createCard()
		{
		
		}
	}