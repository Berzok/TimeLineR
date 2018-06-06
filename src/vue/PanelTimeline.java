package vue;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import modele.Date;
import modele.Evenement;
import modele.ModeleTable;
import modele.Timeline;


@SuppressWarnings("serial")
public class PanelTimeline extends JPanel
	{
	Controleur chControleur;
	Timeline laTimeline;
	JTable timeLine;
	JScrollPane leScroll;
	public PanelTimeline(Controleur parControleur) throws ParseException
    	{
		chControleur = parControleur;
		chControleur.chPanelTimeline = this;
		laTimeline = Controleur.chTimeline;
		
		
		this.setLayout(new BorderLayout(0 , 0));
		
		this.setForeground(new Color(0, 0, 0));
		this.setBackground(getForeground());
		
		timeLine = new JTable();
		timeLine.setDefaultEditor(Object.class, null);
		timeLine.setModel(new ModeleTable(Controleur.chTimeline));
		//    timeLine.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		timeLine.getTableHeader().setReorderingAllowed(false);
		this.add(timeLine, BorderLayout.CENTER);
		timeLine.setRowHeight(50);
		
		leScroll = new JScrollPane(timeLine);
	    leScroll.setPreferredSize(new Dimension(745, 150));
	    leScroll.setSize(745, 15);
	    leScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    leScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    this.add(leScroll);
	    
	    
	    
	    timeLine.addMouseListener(new MouseAdapter()
	    	{
	    	@Override
	    	public void mouseClicked(MouseEvent e)
	    		{
	    		int row = timeLine.rowAtPoint(e.getPoint());
	    	    int col = timeLine.columnAtPoint(e.getPoint());
	    	    if (row >= 0 && col >= 0)
	    	        {
	    	    	laTimeline.ajout(3, new Evenement(new Date(), "Oui", "Bonjour bonjour", 1));
	    	    	laTimeline.afficherContenu();
	    	    	timeLine.setValueAt(col + "" + row, row, col);
	    	        System.out.println("Colonne: " + col);
	    	        System.out.println("Ligne: " + row);
	    	        System.out.println("Colonnes JTabel: " + timeLine.getColumnCount());
	    			if(timeLine.getColumnCount() < laTimeline.getSize())
	    				{
	    				timeLine.setModel(new ModeleTable(Controleur.chTimeline));
	    				}
	    			timeLine.revalidate();
	    			timeLine.repaint();
	    	        }
	    		}
	    	});
	    
	    this.actualiserTimeline(timeLine, Controleur.chTimeline);
	    
	    }
	
	public void actualiserTimeline(JTable timeLine, Timeline laTimeline)
		{
		
		}
	}