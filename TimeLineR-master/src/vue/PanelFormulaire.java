package vue;
import modele.*;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import modele.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;



@SuppressWarnings("serial")
public class PanelFormulaire extends JDialog implements ActionListener
	{
	private PanelFils lePanel;
	private Controleur leControleur;
	
	private class PanelFils extends JPanel implements ActionListener
		{
		private Evenement chEvenement;
		private JTextArea chTitreEvent;
		private JTextArea chDateEvent;
		private JLabel chLabelDate = new JLabel();
		private JButton chValidation = new JButton("Valider");
		
		public PanelFils()
			{
			
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
			
			
			JLabel titreEvent = new JLabel("Titre");
			titreEvent.setFont(new Font("Tahoma", Font.BOLD, 13));
			add(titreEvent);
			chTitreEvent = new JTextArea();
			chTitreEvent.setColumns(30);
			add(chTitreEvent);
			
			
			add(Box.createRigidArea(new Dimension(5,0)));
			
			
			add(Box.createRigidArea(new Dimension(0,2)));
			JLabel labelDebut = new JLabel("Ann\u00E9e");
			labelDebut.setFont(new Font("Tahoma", Font.BOLD, 12));
			add(labelDebut);			
			chDateEvent = new JTextArea();
			chDateEvent.setColumns(10);
			add(chDateEvent);
			add(Box.createRigidArea(new Dimension(0,2)));
			
			
			add(Box.createRigidArea(new Dimension(5,0)));
			
			
			JLabel descriptionEvent = new JLabel("Description");
			descriptionEvent.setFont(new Font("Tahoma", Font.BOLD, 12));
			add(descriptionEvent);
			
			JTextArea textArea = new JTextArea("");
			add(textArea);
			
			
			
			add(Box.createRigidArea(new Dimension(0,10)));
			add(Box.createRigidArea(new Dimension(5,0)));
			
			chValidation.setBackground(new Color(222, 184, 135));
			add(chValidation);
			}
		
		
		@Override
		public void actionPerformed(ActionEvent arg0)
			{
			
			}
		
		}
	
	
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public PanelFormulaire(Controleur parControleur) throws ParseException
		{
		this.setModal(true);
		this.setTitle("Ajouter un évènement");
		this.setSize(400, 200);
		setBackground(new Color(0, 0, 0));
		setForeground(getBackground());
		leControleur = parControleur;
		Date today = new Date();
		
		
		lePanel = new PanelFils();
		add(lePanel);
		
		}
	
	
	
	public modele.Date getDate()
		{
		return chDate;
		}
	public void setDate(modele.Date parDate)
		{
		chDate = parDate;
		this.revalidate();
		this.repaint();
		chLabelDate.setText(chDate.toString());
		}
	
	public void reset()
		{
		chLieuEvent.setText(null);
		chTitreEvent.setText(null);
		}
	
	public static Evenement getEvenement()
		{
		chEvenement = new Evenement(new modele.Date(2, 8, 1741), chLieuEvent.getText(), chTitreEvent.getText());
		return chEvenement;
		}
	public void actionPerformed(ActionEvent parEvent)
		{
		
		}


	public void enregistreEcouteur(Controleur controleur)
		{
		chBoutonAjout.addActionListener(controleur);
		}
}
