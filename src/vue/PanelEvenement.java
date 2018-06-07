/*
 * 
 */
package vue;
import modele.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.util.TreeMap;

import javax.swing.*;


// TODO: Auto-generated Javadoc
/**
 * The Class PanelEvenement.
 */
@SuppressWarnings("serial")
public class PanelEvenement extends JPanel
	{
	
	/** The ch controleur. */
	Controleur chControleur;
	
	/** The la timeline. */
	Timeline laTimeline;
	
	/** The tree ton. */
	TreeMap<Evenement, PanelDetailsEvenement> treeTon = new TreeMap<>();
	
	/** The le panel details. */
	PanelDetailsEvenement lePanelDetails;
	
	/** The bouton previous. */
	JButton boutonPrevious = new JButton("<<");
	
	/** The bouton next. */
	JButton boutonNext = new JButton(">>");
	
	/**
	 * Instantiates a new panel evenement.
	 *
	 * @param parControleur the par controleur
	 * @throws ParseException the parse exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
	
	/**
	 * Creates the panel.
	 *
	 * @param parEvt the par evt
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void createPanel(Evenement parEvt) throws IOException
		{
		treeTon.put(parEvt, new PanelDetailsEvenement(parEvt));
		}
	
	/**
	 * Creer timeline test.
	 *
	 * @return the timeline
	 */
	public Timeline creerTimelineTest()
		{
		Timeline laTimeline = new Timeline();
		laTimeline.ajout(new Evenement("Nouvel an", new Date(1, 1, 1900), "Début du XXème siècle", 0));
		laTimeline.ajout(new Evenement("Date au pif", new Date(14, 6, 1956), "14 juin de l'année 1956", 1));
		laTimeline.ajout(new Evenement("Réveillon", new Date(31, 12, 1999), "Fin du XXème siècle", 1));
		Controleur.chTimeline = laTimeline;
		return laTimeline;
		}
	
	/**
	 * Enregistre ecouteur.
	 *
	 * @param controleur the controleur
	 */
	public void enregistreEcouteur(Controleur controleur)
		{
		// TODO Auto-generated method stub
		}
	}