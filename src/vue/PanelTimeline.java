package vue;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
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
		this.setLayout(new BorderLayout(0 , 0));
		
		this.setForeground(new Color(0, 0, 0));
		this.setBackground(getForeground());
		
		timeLine = new JTable();
		timeLine.setDefaultEditor(Object.class, null);
		timeLine.setModel(new ModeleTable());
		//    timeLine.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		timeLine.getTableHeader().setReorderingAllowed(false);
		this.add(timeLine, BorderLayout.CENTER);
		timeLine.setRowHeight(50);
    
		JScrollPane leScroll = new JScrollPane(timeLine);
	    leScroll.setPreferredSize(new Dimension(745, 150));
	    leScroll.setSize(745, 15);
	    leScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    leScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    this.add(leScroll);
	    }
	}