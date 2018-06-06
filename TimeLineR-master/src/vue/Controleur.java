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
	@Override
	public void actionPerformed(ActionEvent parEvent)
		{
	        if (parEvent.getActionCommand().equals("Valider")) {
	            Evenement evt = PanelFormulaire.getEvenement();
	            chTimeline.ajout(chTimeline.getSize() +1, evt);
	            // mise à jour de la JTable
	            chPanelTimeline.ajoutEvenement(evt);
	            // ecriture de l'evenement dans le fichier
	            LectureEcriture.ecriture(fichier, chTimeline);// ICI
	            // les champs du formulaires sonr re-initialisés
	            chPanelFormulaire.reset();
	        }
		if(parEvent.getSource().getClass().equals(chPanelTimeline))
			{
			
			}
		}
	
	private void synchroTimelines()
		{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for(int i=0; i<chTimeline.getSize(); i++)
						{
						
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		}
	
	
	public void finaliserControleur(){
		chPanelTimeline.enregistreEcouteur(this);
		chPanelEvenement.enregistreEcouteur(this);
		}
	}