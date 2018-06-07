package modele;

import java.io.Serializable;

import javax.swing.JButton;


// TODO: Auto-generated Javadoc
/**
 * The Class Evenement.
 */
public class Evenement implements Serializable
	{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The ch date. */
	private Date chDate;
	
	/** The ch nom. */
	private String chNom;
	
	/** The ch poids. */
	private Integer chPoids;
	
	/** The ch desc. */
	private String chDesc;
	
	/** The ch row. */
	private Integer chRow;
	
	/** The ch col. */
	private Integer chCol;
	
	/** The ch image URL. */
	private String chImageURL;
	
	/**
	 * Instantiates a new evenement.
	 *
	 * @param parNom the par nom
	 * @param parDate the par date
	 * @param parDesc the par desc
	 * @param parPoids the par poids
	 */
	public Evenement(String parNom, Date parDate, String parDesc, Integer parPoids)
		{
		this.chDate = parDate;
		this.chNom = parNom;
		this.chDesc = parDesc;
		this.chPoids = parPoids;
		
		}//Constructeur
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return chDate + " " + chNom + " " + chPoids;
	}//toString
	
	/**
	 * Gets the ch date.
	 *
	 * @return the ch date
	 */
	public Date getChDate(){
		return this.chDate;
	}//Accesseur Date
	
	/**
	 * Gets the ch nom.
	 *
	 * @return the ch nom
	 */
	public String getChNom(){
		return this.chNom;
	}//Accesseur Nom
	
	/**
	 * Gets the ch desc.
	 *
	 * @return the ch desc
	 */
	public String getChDesc(){
		return this.chDesc;
	}
	
	/**
	 * Gets the ch poids.
	 *
	 * @return the ch poids
	 */
	public Integer getChPoids(){
		return this.chPoids;
	}//Accesseur Lieu
	
	/**
	 * Gets the ch row.
	 *
	 * @return the ch row
	 */
	public Integer getChRow(){
		return this.chRow;
	}
	
	/**
	 * Gets the ch col.
	 *
	 * @return the ch col
	 */
	public Integer getChCol(){
		return this.chCol;
	}
	
	/**
	 * Gets the ch image URL.
	 *
	 * @return the ch image URL
	 */
	public String getChImageURL(){
		return this.chImageURL;
	}
	
	/**
	 * Sets the ch date.
	 *
	 * @param parDate the new ch date
	 */
	public void setChDate(Date parDate){
		this.chDate = parDate;
	}
	
	/**
	 * Sets the ch nom.
	 *
	 * @param parNom the new ch nom
	 */
	public void setChNom(String parNom){
		this.chNom = parNom;
	}
	
	/**
	 * Sets the ch lieu.
	 *
	 * @param parPoids the new ch lieu
	 */
	public void setChLieu(Integer parPoids){
		this.chPoids = parPoids;
	}
	
	/**
	 * Sets the ch row.
	 *
	 * @param parRow the new ch row
	 */
	public void setChRow(Integer parRow){
		this.chRow = parRow;
	}
	
	/**
	 * Sets the ch col.
	 *
	 * @param parCol the new ch col
	 */
	public void setChCol(Integer parCol){
		this.chCol = parCol;
	}
	
	/**
	 * Sets the image URL.
	 *
	 * @param parURL the new image URL
	 */
	public void setImageURL(String parURL){
		this.chImageURL = parURL;
	}
	
//	public static Evenement lireEvenement() throws ExceptionDate{
//		System.out.println("Entrer Date");
//		Date d1 = Date.lireDate();
//		System.out.println("Entrer nom");
//		String Nom = Clavier.lireString();
//		System.out.println("Entrer lieu");
//		String Lieu = Clavier.lireString();
//		Evenement E = new Evenement(d1, Nom, Lieu);
//		return E;
//	}//lireEvenement
	
	/**
 * Compar to.
 *
 * @param parEvent the par event
 * @return the int
 */
public int comparTo(Evenement parEvent)
		{
		if(this.chNom.compareTo(parEvent.chNom)!=0)
				return this.chNom.compareTo(parEvent.chNom);//les noms sont identiques
		return this.chPoids.compareTo(parEvent.chPoids);
		}//comparTo

	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public JButton getSource()
		{
		// TODO Auto-generated method stub
		return null;
		}

	/**
	 * Gets the poids.
	 *
	 * @return the poids
	 */
	public int getPoids()
		{
		return this.chPoids;
		}
	
}//Evenement
