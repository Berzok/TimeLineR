package vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.*;



public class Controleur implements ActionListener
	{
	static Timeline chTimeline;
	PanelDetailsEvenement chPanelDetailsEvenement;
	PanelEvenement chPanelEvenement;
	PanelFormulaire chPanelFormulaire;
	PanelTimeline chPanelTimeline;
	static modele.Date chDate;
	
	public Controleur()
		{
		
		}
	public void changerDateFormulaire(modele.Date parDate)
		{
		System.out.println("Controleur ok");
		chPanelFormulaire.setDate(parDate);
		}
	public void actionPerformed(ActionEvent parEvent)
		{
		if(parEvent.getSource().equals(chPanelFormulaire.lePanel.chValidation))
			{
			System.out.println("trouvé");
			}
		}
	
	
	public void finaliserControleur(){
		chPanelEvenement.enregistreEcouteur(this);
		}
	}