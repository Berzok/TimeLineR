package vue;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;


public class PanelDetailsEvenement extends JPanel
	{
	Integer compteur = 0;
	JPanel cards;
	public PanelDetailsEvenement()
		{
		this.setLayout(new CardLayout());
		cards = new JPanel();
		cards.setBackground(new Color(80, 40, 120));
		
		
		
		JPanel card0 = new JPanel();
		this.add(cards);
		}
	}