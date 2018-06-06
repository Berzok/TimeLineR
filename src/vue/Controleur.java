package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import modele.*;



public class Controleur implements ActionListener
	{
	static Timeline chTimeline;
	PanelDetailsEvenement chPanelDetailsEvenement;
	PanelEvenement chPanelEvenement;
	PanelFormulaire chPanelFormulaire;
	PanelTimeline chPanelTimeline;
	static modele.Date chDate;
	
	public Controleur(){
	}
	
	public void actionPerformed(ActionEvent parEvent)
		{
		if(parEvent.getSource().equals(chPanelFormulaire.lePanel.chValidation))
			{
			Evenement leEvent;
			Integer key = chTimeline.getKey(chPanelFormulaire.getEvenement());
			leEvent = chPanelFormulaire.getEvenement();
			System.out.println(key);
			chTimeline.ajout(key, leEvent);
			chPanelTimeline.timeLine.setModel(new ModeleTable(Controleur.chTimeline));
			System.out.println("Colonne: " + chPanelFormulaire.getCol());
			chPanelTimeline.timeLine.setValueAt(leEvent.getChNom(), chPanelFormulaire.getImportance()-1, chPanelFormulaire.getCol());
			chPanelFormulaire.execute_order_66();
			LectureEcriture.ecriture(new File("save/saveload.ser"), chTimeline);
			}
		}
	
	
	public void finaliserControleur(){
		chPanelEvenement.enregistreEcouteur(this);
		}
	}