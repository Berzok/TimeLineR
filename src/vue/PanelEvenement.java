package vue;
import modele.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.ParseException;
import javax.swing.*;


public class PanelEvenement extends JPanel
	{
	Controleur chControleur;
	Timeline laTimeline;
	PanelFormulaire lePanel1;
	PanelDetailsEvenement lePanelDetails;
	JButton boutonPrevious = new JButton("<<");
	JButton boutonNext = new JButton(">>");
	public PanelEvenement() throws ParseException
		{
		this.setLayout(new GridLayout(0, 3));
		this.setForeground(new Color(0, 0, 0));
		this.setBackground(getForeground());
		lePanelDetails = new PanelDetailsEvenement();
		laTimeline = new Timeline();
		laTimeline.ajout(new Evenement(new Date(5, 7, 1741), "Tourte", "Morrowind"));
		laTimeline.ajout(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));
		this.add(boutonPrevious);
		this.add(lePanelDetails);
		this.add(boutonNext);
		}
	public void enregistreEcouteur(Controleur controleur) {
		// TODO Auto-generated method stub
		
	}
	}