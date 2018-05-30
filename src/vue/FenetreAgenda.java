package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FenetreAgenda extends JFrame {

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
	}
}
