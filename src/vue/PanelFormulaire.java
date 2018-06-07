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



@SuppressWarnings("serial")
public class PanelFormulaire extends JDialog implements ActionListener
	{
	public PanelFils lePanel;
	private Controleur leControleur;
	private Evenement chEvenement;
	private Integer chAnnee;
	private Integer chCol;
	private Integer chRow;
	
	class PanelFils extends JPanel implements ActionListener
		{
		private JTextArea chTitreEvent;
		private JButton chImageBouton;
		private String chEventImage;
		private JComboBox<String> chImportance;
		private JTextArea chDescEvent;
		public JButton chValidation = new JButton("Valider");
		
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
	 * @throws ParseException 
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
	
	public Integer getRow()
		{
		return chRow;
		}
	public Integer getCol(){
		return chCol;
	}
	public String getTitre(){
		return this.lePanel.chTitreEvent.getText();
		}
	public Date getDate(){
		return new Date(1, 1, chAnnee);
//		return new Date(1, 1, Integer.parseInt(this.lePanel.chDateEvent.getText()));
		}
	public String getDesc(){
		return this.lePanel.chDescEvent.getText();
		}
	public Integer getImportance(){
		return this.lePanel.chImportance.getSelectedIndex()+1;
		}
	public String getImageURl(){
		return this.lePanel.chEventImage;
	}

	
	public void actionPerformed(ActionEvent parEvent){
		}
	public void execute_order_66(){
		this.dispose();
	}
}
