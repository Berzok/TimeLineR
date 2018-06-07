/*
 * 
 */
package vue;
import modele.*;
import javax.swing.JPanel;
import java.awt.Color;
import java.text.ParseException;
import modele.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JButton;



// TODO: Auto-generated Javadoc
/**
 * The Class PanelFormulaire.
 */
@SuppressWarnings("serial")
public class PanelFormulaire extends JDialog implements ActionListener
	{
	
	/** The le panel. */
	public PanelFils lePanel;
	
	/** The le controleur. */
	private Controleur leControleur;
	
	/** The ch evenement. */
	private Evenement chEvenement;
	
	/** The ch annee. */
	private Integer chAnnee;
	
	/** The ch col. */
	private Integer chCol;
	
	/** The ch row. */
	private Integer chRow;
	
	/**
	 * The Class PanelFils.
	 */
	class PanelFils extends JPanel implements ActionListener
		{
		
		/** The ch titre event. */
		private JTextArea chTitreEvent;
		
		/** The ch image bouton. */
		private JButton chImageBouton;
		
		/** The ch event image. */
		private String chEventImage;
		
		/** The ch importance. */
		private JComboBox<String> chImportance;
		
		/** The ch desc event. */
		private JTextArea chDescEvent;
		
		/** The ch validation. */
		public JButton chValidation = new JButton("Valider");
		
		/**
		 * Instantiates a new panel fils.
		 */
		public PanelFils()
			{
			
			this.setLayout(new GridLayout(0, 1));
			this.setBorder(BorderFactory.createEmptyBorder(14, 14, 14, 14));
			
			
			JLabel titreEvent = new JLabel("Titre");
			titreEvent.setFont(new Font("Tahoma", Font.BOLD, 13));
			add(titreEvent);
			chTitreEvent = new JTextArea();
			chTitreEvent.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			chTitreEvent.setColumns(70);
			add(chTitreEvent);
			
			
//			JLabel labelDebut = new JLabel("Ann\u00E9e");
//			labelDebut.setFont(new Font("Tahoma", Font.BOLD, 12));
//			add(labelDebut);			
//			chDateEvent = new JTextArea();
//			chDateEvent.setColumns(70);
//			add(chDateEvent);
			
			
			chImageBouton = new JButton("Ajouter une image");
			chImageBouton.addActionListener(this);
			add(chImageBouton);
			
			
			
			JLabel labelImportance = new JLabel("Importance: ");
			labelImportance.setFont(new Font("Tahoma", Font.BOLD, 12));
			String[] laListe = {"1", "2", "3", "4", "5"};
			chImportance = new JComboBox<String>(laListe);
			chImportance.setSelectedIndex(chRow);
			add(labelImportance);
			add(chImportance);
			
			
			JLabel descriptionEvent = new JLabel("Description");
			descriptionEvent.setFont(new Font("Tahoma", Font.BOLD, 12));
			add(descriptionEvent);
			
			chDescEvent = new JTextArea("");
			chDescEvent.setRows(10);
			chDescEvent.setColumns(70);
			chDescEvent.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			add(chDescEvent);
			
			
			
			add(Box.createRigidArea(new Dimension(0,10)));
			add(Box.createRigidArea(new Dimension(0,10)));
			chValidation.setBackground(new Color(222, 184, 135));
			chValidation.addActionListener(leControleur);
			add(chValidation);
			}
		
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent parEvent)
			{
			if(parEvent.getSource().equals(chImageBouton))
				{
				JFileChooser fileSelect = new JFileChooser();
				fileSelect.setCurrentDirectory(new File(System.getProperty("user.home")));
				int leResultat = fileSelect.showOpenDialog(this);
				if (leResultat == JFileChooser.APPROVE_OPTION)
					{
				    File laImage = fileSelect.getSelectedFile();
				    try
				    	{
						chEventImage = laImage.getCanonicalPath();
				    	}
				    catch (IOException e)
				    	{
						e.printStackTrace();
				    	}
					}
				}
			}
		
		}
	
	
	/**
	 * Create the panel.
	 *
	 * @param parControleur the par controleur
	 * @param parHeader the par header
	 * @param parCol the par col
	 * @param parRow the par row
	 * @throws ParseException the parse exception
	 */
	public PanelFormulaire(Controleur parControleur, String[] parHeader, Integer parCol, Integer parRow) throws ParseException
		{
		this.setModal(true);
		this.setTitle("Ajouter un évènement");
		this.setSize(400, 400);
		setBounds(250, 250, 450, 300);
		setBackground(new Color(0, 0, 0));
		setForeground(getBackground());
		leControleur = parControleur;
		leControleur.chPanelFormulaire = this;
		
		chCol = parCol;
		chRow = parRow;
		chAnnee = Integer.parseInt(parHeader[parCol]);
		
		
		System.out.println("Colonne: " + parCol);
		System.out.println("Ligne:   " + parRow);
		
		lePanel = new PanelFils();
		add(lePanel);
		
		}
	
	
	
	/**
	 * Gets the evenement.
	 *
	 * @return the evenement
	 */
	public Evenement getEvenement()
		{
		String titre = getTitre();
		Date date = getDate();
		String desc = getDesc();
		Integer importance = getImportance();
		chEvenement = new Evenement(titre, date, desc, importance);
		chEvenement.setImageURL(this.lePanel.chEventImage);
		return chEvenement;
		}
	
	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public Integer getRow()
		{
		return chRow;
		}
	
	/**
	 * Gets the col.
	 *
	 * @return the col
	 */
	public Integer getCol(){
		return chCol;
	}
	
	/**
	 * Gets the titre.
	 *
	 * @return the titre
	 */
	public String getTitre(){
		return this.lePanel.chTitreEvent.getText();
		}
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate(){
		return new Date(1, 1, chAnnee);
//		return new Date(1, 1, Integer.parseInt(this.lePanel.chDateEvent.getText()));
		}
	
	/**
	 * Gets the desc.
	 *
	 * @return the desc
	 */
	public String getDesc(){
		return this.lePanel.chDescEvent.getText();
		}
	
	/**
	 * Gets the importance.
	 *
	 * @return the importance
	 */
	public Integer getImportance(){
		return this.lePanel.chImportance.getSelectedIndex()+1;
		}
	
	/**
	 * Gets the image U rl.
	 *
	 * @return the image U rl
	 */
	public String getImageURl(){
		return this.lePanel.chEventImage;
	}

	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent parEvent){
		}
	
	/**
	 * Execute order 66.
	 */
	public void execute_order_66(){
		this.dispose();
	}
}
