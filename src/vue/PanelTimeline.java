package vue;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.ParseException;

import modele.Date;
import modele.Evenement;
import modele.ModeleTable;
import modele.Timeline;


public class PanelTimeline extends JPanel
	{
	Controleur chControleur;
	Timeline leAgenda;
	JTable timeLine;
	public PanelTimeline() throws ParseException
		{
		this.setLayout(new GridLayout());
		leAgenda = new Timeline();
		leAgenda.ajout(new Evenement(new Date(5, 7, 1741), "Tourte", "Morrowind"));
		leAgenda.ajout(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));
		leAgenda.afficherContenu();
		
		
		timeLine = new JTable();
		timeLine.setModel(new ModeleTable());
//		timeLine.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		timeLine.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane leScroll = new JScrollPane(timeLine);
		
		this.add(leScroll, BorderLayout.CENTER);
		}
	}