package modele;

import javax.swing.JButton;


public class Evenement{
	private Date chDate;
	private String chNom;
	private Integer chPoids;
	private String chDesc;
	
	public Evenement(Date parDate, String parNom, int parPoids, String parDesc)
		{
		this.chDate = parDate;
		this.chNom = parNom;
		this.chPoids = parPoids;
		this.chDesc = parDesc;
		
		}//Constructeur
	
	public String toString(){
		return chDate + " " + chNom + " " + chPoids;
	}//toString
	
	public Date getChDate(){
		return this.chDate;
	}//Accesseur Date
	
	public String getChNom(){
		return this.chNom;
	}//Accesseur Nom
	
	public Integer getChPoids(){
		return this.chPoids;
	}//Accesseur Lieu
	
	public void setChDate(Date parDate){
		this.chDate = parDate;
	}
	
	public void setChNom(String parNom){
		this.chNom = parNom;
	}
	
	public void setChLieu(Integer parPoids){
		this.chPoids = parPoids;
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
	
	public int comparTo(Evenement parEvent)
		{
		if(this.chNom.compareTo(parEvent.chNom)!=0)
				return this.chNom.compareTo(parEvent.chNom);//les noms sont identiques
		return this.chPoids.compareTo(parEvent.chPoids);
		}//comparTo

	public JButton getSource()
		{
		// TODO Auto-generated method stub
		return null;
		}

	public int getPoids()
		{
		return this.chPoids;
		}
	
}//Evenement
