/*
 * 
 */
package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


// TODO: Auto-generated Javadoc
/**
 * The Class FenetreMere.
 */
@SuppressWarnings("serial")
public class FenetreMere extends JFrame implements ActionListener{
	
	/** The le controleur. */
	public Controleur leControleur;
	
	/** The menu bar. */
	public JMenuBar menuBar = new JMenuBar();
	
	/** The menu timeline. */
	public JMenu menuTimeline = new JMenu("Timelines");
	
	/** The menu add. */
	public JMenu menuAdd = new JMenu("Ajouts");
	
	/** The add timeline. */
	public JMenuItem addTimeline = new JMenuItem("Ajouter une Timeline");
	
	/** The add event. */
	public JMenuItem addEvent = new JMenuItem("Ajouter un event � une Timeline");
	
	/** The timeline test 1. */
	public JMenuItem timelineTest1 = new JMenuItem("Timeline Test1");
	
	/** The timeline test 2. */
	public JMenuItem timelineTest2 = new JMenuItem("Timeline Test2");

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreMere frame = new FenetreMere();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 * @throws ParseException the parse exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public FenetreMere() throws ParseException, IOException {
		setTitle("Chronologie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(750, 450);
		this.setLayout(new GridLayout(2, 0));
		
		Controleur leControleur = new Controleur(this);
		
		PanelEvenement panelNord = new PanelEvenement(leControleur);
		PanelTimeline panelFrise = new PanelTimeline(leControleur);
		
		this.addTimeline.addActionListener(leControleur);
		this.addEvent.addActionListener(leControleur);
		this.timelineTest1.addActionListener(leControleur);
		this.timelineTest2.addActionListener(leControleur);
		
		
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

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
