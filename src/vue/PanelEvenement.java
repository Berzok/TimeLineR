package vue;
import modele.*;

import java.awt.GridLayout;
import java.text.ParseException;
import javax.swing.*;


public class PanelEvenement extends JPanel
	{
	Controleur chControleur;
	Agenda leAgenda;
	PanelFormulaire lePanel1;
	PanelDetailsEvenement lePanelDetails;
	JButton boutonPrevious = new JButton("<<");
	JButton boutonNext = new JButton(">>");
	public PanelEvenement() throws ParseException
		{
		this.setLayout(new GridLayout(0, 3));
		lePanelDetails = new PanelDetailsEvenement();
		leAgenda = new Agenda();
		leAgenda.ajout(new Evenement(new Date(5, 7, 1741), "Tourte", "Morrowind"));
		leAgenda.ajout(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));
		this.add(boutonPrevious);
		this.add(lePanelDetails);
		this.add(boutonNext);
		}
	}