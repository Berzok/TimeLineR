package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modele.*;



public class Controleur implements ActionListener
	{
	static Timeline chTimeline;
	FenetreMere chFenetreMere;
	PanelDetailsEvenement chPanelDetailsEvenement;
	PanelEvenement chPanelEvenement;
	PanelFormulaire chPanelFormulaire;
	PanelTimeline chPanelTimeline;
	static modele.Date chDate;
	
	public Controleur(FenetreMere parFenetre){
		chFenetreMere = parFenetre;
	}
	
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
			chPanelTimeline.timeLine.setValueAt(leEvent.getChNom(), chPanelFormulaire.getImportance()-1, chPanelFormulaire.getCol());
			System.out.println("URL: " + leEvent.getChImageURL());
			try {
				LectureEcriture.copierFichier(new File(leEvent.getChImageURL()), new File("images/"+leEvent.getChNom()+".png"));
				leEvent.setImageURL("images/"+leEvent.getChNom()+".png");
				System.out.println("URL: " + leEvent.getChImageURL());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
	
	
	public void finaliserControleur(){
		chPanelEvenement.enregistreEcouteur(this);
		}
	}