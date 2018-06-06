package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			chTimeline.ajout(chPanelFormulaire.getEvenement());
			chPanelFormulaire.execute_order_66();
			chTimeline.afficherContenu();
			}
		}
	
	
	public void finaliserControleur(){
		chPanelEvenement.enregistreEcouteur(this);
		}
	}