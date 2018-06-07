/*
 * 
 */
package vue;

import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import modele.CellRenderer;
import modele.Evenement;


// TODO: Auto-generated Javadoc
/**
 * The Class PanelDetailsEvenement.
 */
@SuppressWarnings("serial")
public class PanelDetailsEvenement extends JPanel
	{
	
	/** The le texte. */
	private JTextArea leTexte;
	
	/** The le titre. */
	private JLabel leTitre;
	
	/** The la image. */
	private JLabel laImage;
	
	/**
	 * Instantiates a new panel details evenement.
	 *
	 * @param parEvt the par evt
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public PanelDetailsEvenement(Evenement parEvt) throws IOException
		{
		JPanel lePanel = new JPanel();
		JPanel lePanel2 = new JPanel();
		
		this.setLayout(new GridLayout(1, 0));
		lePanel.setLayout(new GridLayout(0, 1));
		lePanel2.setLayout(new BoxLayout(lePanel2, BoxLayout.PAGE_AXIS));
		
		
		leTexte = new JTextArea(parEvt.getChDesc());
		leTexte.setEditable(false);
		leTitre = new JLabel(parEvt.getChNom());
		laImage = new JLabel(new ImageIcon("images/blank.png"));
		
		
		lePanel.add(leTitre);
		lePanel.add(leTexte);
		this.add(laImage);
		this.add(lePanel);
		
		}
	
	/**
	 * Actualiser.
	 *
	 * @param parEvent the par event
	 */
	public void actualiser(Evenement parEvent){
		leTitre.setText(parEvent.getChNom());
		leTexte.setText(parEvent.getChDesc());
		laImage.setIcon(new ImageIcon(parEvent.getChImageURL()));
	}
	
	}