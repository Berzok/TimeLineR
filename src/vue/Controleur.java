package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import modele.*;



public class Controleur implements ActionListener
	{
	static Integer laSave = 0;
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
			leEvent.setChRow(leEvent.getChPoids());
			leEvent.setChCol(chPanelFormulaire.getCol());
			chTimeline.ajout(key, leEvent);
			System.out.println("Poids max: " + chTimeline.getMaxPoidsEvent());
			System.out.println("Poids event: " + leEvent.getChPoids());
			if(leEvent.getChPoids()>=chTimeline.getMaxPoidsEvent())
				{
				System.out.println("If conditions remplies");
				chPanelTimeline.timeLine.setModel(new ModeleTable(Controleur.chTimeline));
				}
			chPanelTimeline.timeLine.setValueAt(leEvent.getChNom(), chPanelFormulaire.getImportance()-1, chPanelFormulaire.getCol());
			chPanelFormulaire.execute_order_66();
			LectureEcriture.ecriture(new File("save/saveload"+laSave+".ser"), chTimeline);
			chPanelTimeline.actualiserTimeline(laSave);
			laSave++;
			}
		}
	
	
	public void finaliserControleur(){
		chPanelEvenement.enregistreEcouteur(this);
		}
	}