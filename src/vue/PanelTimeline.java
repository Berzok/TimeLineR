package vue;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.ParseException;

import modele.Agenda;
import modele.Date;
import modele.Evenement;


public class PanelTimeline extends JPanel
	{
	Controleur chControleur;
	Agenda leAgenda;
	JTable timeLine;
	public PanelTimeline() throws ParseException
		{
		this.setLayout(new GridLayout(0, 1));
		leAgenda = new Agenda();
		leAgenda.ajout(new Evenement(new Date(5, 7, 1741), "Tourte", "Morrowind"));
		leAgenda.ajout(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));
		leAgenda.afficherContenu();
		timeLine = new JTable(4, 10);
		JScrollPane leScroll = new JScrollPane(timeLine);
		this.add(leScroll, BorderLayout.CENTER);
		}
	}