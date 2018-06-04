package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class FenetreAgenda extends JFrame {
	
	public JMenuBar menuBar = new JMenuBar();
	public JMenu menuTimeline = new JMenu("Timelines");
	public JMenu menuAdd = new JMenu("Ajouts");
	public JMenuItem addTimeline = new JMenuItem("Ajouter une Timeline");
	public JMenuItem addEvent = new JMenuItem("Ajouter un event à une Timeline");
	public JMenuItem timelineTest1 = new JMenuItem("Timeline Test1");
	public JMenuItem timelineTest2 = new JMenuItem("Timeline Test2");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAgenda frame = new FenetreAgenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public FenetreAgenda() throws ParseException {
		setTitle("Chronologie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(750, 400);
		this.setLayout(new GridLayout(2, 0));
		PanelEvenement panelNord = new PanelEvenement();
		PanelTimeline panelFrise = new PanelTimeline();		
		this.add(panelNord, BorderLayout.NORTH);
		this.add(panelFrise, BorderLayout.SOUTH);
		
 		this.add(panelFrise, BorderLayout.SOUTH);
 		this.menuTimeline.add(timelineTest1);
		this.menuTimeline.add(timelineTest2);
		this.menuAdd.add(addTimeline);
		this.menuAdd.add(addEvent);
		this.menuBar.add(menuTimeline);
		this.menuBar.add(menuAdd);
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		
	}
}
