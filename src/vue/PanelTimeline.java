package vue;
import modele.Evenement;
import modele.LectureEcriture;
import modele.ModeleTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import modele.Timeline;



public class PanelTimeline extends JPanel
	{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Timeline> laSave = new ArrayList<Timeline>();
	ArrayList<File> lesSaves = new ArrayList<File>();
	Controleur chControleur;
	Timeline laTimeline;
	JTable timeLine;
	JScrollPane leScroll;
	String[] chHeader;
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
	    
	    chHeader = ModeleTable.getTableHeader();
	    
	    timeLine.addMouseListener(new MouseAdapter()
	    	{
	    	@Override
	    	public void mouseClicked(MouseEvent e)
	    		{
	    		System.out.println("Il y a " + timeLine.getColumnCount() + " colonnes");
	    		int row = timeLine.rowAtPoint(e.getPoint());
	    	    int col = timeLine.columnAtPoint(e.getPoint());
	    	    System.out.println("Il y a " + col + " colonnes");
	    	    if (row >= 0 && col >= 0)
	    	        {
	    			PanelFormulaire formulaire;
					try
						{
						formulaire = new PanelFormulaire(chControleur, chHeader, col, row);
						formulaire.setVisible(true);
						}
					catch (ParseException e1)
						{
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
	    			timeLine.revalidate();
	    			timeLine.repaint();
	    	        }
	    		}
	    	});
	    
	    }
	
	public void actualiserTimeline(Integer parSave)
		{
		for(Integer i=0; i<parSave; i++)
			{
			lesSaves.add(new File("save/saveload"+i+".ser"));
			}
		timeLine.repaint();
		}
	}