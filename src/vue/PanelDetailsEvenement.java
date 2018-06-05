package vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import javax.imageio.ImageIO;
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
		
		leTexte = new JTextField("Lalala");
		leTitre = new JLabel(parEvt.getChNom());
		
		laImage = new JLabel(new ImageIcon("images/blank.png"));
		
		this.add(laImage, BorderLayout.WEST);
		this.add(leTitre, BorderLayout.NORTH);
		this.add(leTexte);
		
		JPanel card0 = new JPanel();
		
		
		}
	private void createCard()
		{
		
		}
	}