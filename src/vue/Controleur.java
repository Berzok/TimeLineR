/*
 * 
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modele.*;



// TODO: Auto-generated Javadoc
/**
 * The Class Controleur.
 */
public class Controleur implements ActionListener
	{
	
	/** The ch timeline. */
	static Timeline chTimeline;
	
	/** The ch fenetre mere. */
	FenetreMere chFenetreMere;
	
	/** The ch panel details evenement. */
	PanelDetailsEvenement chPanelDetailsEvenement;
	
	/** The ch panel evenement. */
	PanelEvenement chPanelEvenement;
	
	/** The ch panel formulaire. */
	PanelFormulaire chPanelFormulaire;
	
	/** The ch panel timeline. */
	PanelTimeline chPanelTimeline;
	
	/** The ch date. */
	static modele.Date chDate;
	
	/**
	 * Instantiates a new controleur.
	 *
	 * @param parFenetre the par fenetre
	 */
	public Controleur(FenetreMere parFenetre){
		chFenetreMere = parFenetre;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent parEvent)
		{
		Object laSource = parEvent.getSource();
		
		/**
		 * Lorsque l'utilisateur clique sur le bouton de validation du formulaire d'ajout, on créé l'évènement
		 * correspondant en fonction des données saisies, puis on l'ajoute à la Timeline actuelle, et on l'ajoute
		 * sur la frise.
		 */
		if(laSource.equals(chPanelFormulaire.lePanel.chValidation))
			{
			Evenement leEvent;
			Integer key = chTimeline.getKey(chPanelFormulaire.getEvenement());
			leEvent = chPanelFormulaire.getEvenement();
			leEvent.setChRow(leEvent.getChPoids());
			leEvent.setChCol(chPanelFormulaire.getCol());
			chTimeline.ajout(key, leEvent);
			try {
				LectureEcriture.copierFichier(new File(leEvent.getChImageURL()), new File("images/"+leEvent.getChNom()+".png"));
				leEvent.setImageURL("images/"+leEvent.getChNom()+".png");
				}
			catch (IOException e)
				{
				e.printStackTrace();
				}
			CellRenderer.setEvenement(leEvent);
			chPanelTimeline.timeLine.setValueAt(new ImageIcon(leEvent.getChImageURL()), chPanelFormulaire.getImportance()-1, chPanelFormulaire.getCol());
			chPanelFormulaire.execute_order_66();
			LectureEcriture.ecriture(new File("save/saveload0.ser"), chTimeline);
			}
		
		
		
		/**
		 * 
		 */
		if(laSource.equals(chFenetreMere.addEvent) || laSource.equals(chFenetreMere.addTimeline))
			{
			
			}
		
		if(laSource.equals(chFenetreMere.timelineTest1) || laSource.equals(chFenetreMere.timelineTest2))
			{
			
			}
		}
	
	
	/**
	 * Finaliser controleur.
	 */
	public void finaliserControleur(){
		chPanelEvenement.enregistreEcouteur(this);
		}
	}