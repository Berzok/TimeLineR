/*
 * 
 */
package vue;
import modele.ModeleTable;
import modele.CellRenderer;
import modele.Timeline;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.HashMap;




// TODO: Auto-generated Javadoc
/**
 * The Class PanelTimeline.
 */
public class PanelTimeline extends JPanel
	{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The ch controleur. */
	Controleur chControleur;
	
	/** The la timeline. */
	Timeline laTimeline;
	
	/** The time line. */
	JTable timeLine;
	
	/** The le scroll. */
	JScrollPane leScroll;
	
	/** The ch header. */
	String[] chHeader;
	
	/** The used coords. */
	HashMap<Integer, Integer> usedCoords = new HashMap<Integer, Integer>();
	
	/**
	 * Instantiates a new panel timeline.
	 *
	 * @param parControleur the par controleur
	 * @throws ParseException the parse exception
	 */
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
		for(int i=0; i<3; i++)
			{
			timeLine.getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());			
			}
		
		
		
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
	    		int row = timeLine.rowAtPoint(e.getPoint());
	    	    int col = timeLine.columnAtPoint(e.getPoint());
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
	
	/**
	 * Actualiser timeline.
	 *
	 * @param parSave the par save
	 */
	public void actualiserTimeline(Integer parSave)
		{
		
		
//		for(Integer i=0; i<parSave; i++)
//			{
//			Evenement leEvent = (Evenement) LectureEcriture.lecture(new File("save/saveload"+i+".ser"));
//			timeLine.setValueAt(leEvent, leEvent.getChRow(), leEvent.getChCol());
//			}
		timeLine.repaint();
		}
	}