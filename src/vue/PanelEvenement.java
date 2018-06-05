package vue;
import modele.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.text.ParseException;
import java.util.TreeMap;

import javax.swing.*;


public class PanelEvenement extends JPanel
	{
	Controleur chControleur;
	Timeline laTimeline;
	TreeMap<Evenement, PanelDetailsEvenement> treeTon = new TreeMap<>();
	PanelDetailsEvenement lePanelDetails;
	JButton boutonPrevious = new JButton("<<");
	JButton boutonNext = new JButton(">>");
	public PanelEvenement() throws ParseException, IOException
		{
		
		this.setLayout(new GridLayout(0, 3));
		this.setForeground(new Color(0, 0, 0));
		this.setBackground(getForeground());
		
		
		laTimeline = new Timeline();
		laTimeline.ajout(new Evenement(new Date(5, 7, 1741), "Tourte", "Morrowind"));
		laTimeline.ajout(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));

		lePanelDetails = new PanelDetailsEvenement(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));
		lePanelDetails.setLayout(new CardLayout());
		
		this.add(boutonPrevious, BorderLayout.WEST);
		this.add(lePanelDetails);
		this.add(boutonNext, BorderLayout.EAST);
		}
	
	protected void createPanel(Evenement parEvt) throws IOException
		{
		treeTon.put(parEvt, new PanelDetailsEvenement(parEvt));
		}
	
	public void enregistreEcouteur(Controleur controleur) {
		// TODO Auto-generated method stub
		
	}
	}