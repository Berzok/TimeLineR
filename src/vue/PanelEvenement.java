package vue;
import modele.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.util.TreeMap;

import javax.swing.*;


@SuppressWarnings("serial")
public class PanelEvenement extends JPanel
	{
	Controleur chControleur;
	Timeline laTimeline;
	TreeMap<Evenement, PanelDetailsEvenement> treeTon = new TreeMap<>();
	PanelDetailsEvenement lePanelDetails;
	JButton boutonPrevious = new JButton("<<");
	JButton boutonNext = new JButton(">>");
	public PanelEvenement(Controleur parControleur) throws ParseException, IOException
		{
		chControleur = parControleur;
		
		chControleur.chPanelEvenement = this;
		
		this.setForeground(new Color(0, 0, 0));
		this.setBackground(getForeground());
		
		
		laTimeline = this.creerTimelineTest();
		laTimeline.afficherContenu();
		
		
		lePanelDetails = new PanelDetailsEvenement(laTimeline.getEvenement(0));
		
		chControleur.chPanelDetailsEvenement = lePanelDetails;
		
		this.add(boutonPrevious, BorderLayout.WEST);
		this.add(lePanelDetails, BorderLayout.CENTER);
		this.add(boutonNext, BorderLayout.EAST);
		}
	
	protected void createPanel(Evenement parEvt) throws IOException
		{
		treeTon.put(parEvt, new PanelDetailsEvenement(parEvt));
		}
	
	public Timeline creerTimelineTest()
		{
		Timeline laTimeline = new Timeline();
		laTimeline.ajout(laTimeline.getSize(), new Evenement("Nouvel an", new Date(1, 1, 1900), "Début du XXème siècle", 0));
		laTimeline.ajout(laTimeline.getSize(), new Evenement("Date au pif", new Date(14, 6, 1956), "14 juin de l'année 1956", 1));
		laTimeline.ajout(laTimeline.getSize(), new Evenement("Réveillon", new Date(31, 12, 1999), "Fin du XXème siècle", 1));
		Controleur.chTimeline = laTimeline;
		return laTimeline;
		}
	
	public void enregistreEcouteur(Controleur controleur)
		{
		// TODO Auto-generated method stub
		}
	}