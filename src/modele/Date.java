package modele;
import java.util.GregorianCalendar;
import java.io.Serializable;
import java.util.Calendar;
 
// TODO: Auto-generated Javadoc
/**
 * The Class Date.
 */
@SuppressWarnings("serial")
public class Date implements Comparable <Date>, Serializable
	{
	
	/** The jour. */
	private int jour;
	
	/** The mois. */
	private int mois;
	
	/** The annee. */
	private int annee;
	
	/** The jour semaine. */
	private int jourSemaine ;  
   
	/**
	 * Instantiates a new date.
	 */
	public Date ()   { 
		GregorianCalendar dateAuj = new GregorianCalendar ();
		annee = dateAuj.get (Calendar.YEAR);
		mois = dateAuj.get (Calendar.MONTH)+1; // janvier = 0, fevrier = 1...
		jour = dateAuj.get (Calendar.DAY_OF_MONTH);
		jourSemaine = dateAuj.get (Calendar.DAY_OF_WEEK);
	}
  
  /**
   * Instantiates a new date.
   *
   * @param parJour the par jour
   * @param parMois the par mois
   * @param parAnnee the par annee
   */
  public Date (int parJour, int parMois, int parAnnee)   {   
	jour = parJour;
	mois = parMois;
	annee = parAnnee; 
	GregorianCalendar date = new GregorianCalendar (annee,mois-1,jour);
	jourSemaine = date.get (Calendar.DAY_OF_WEEK);				
  } 
   
  /**
   * retourne 0 si this et parDate sont gales, 
   * -1 si this prde parDate,
   *  1 si parDate prde this.
   *
   * @param parDate the par date
   * @return the int
   */
  public int compareTo (Date parDate) {
    if (annee < parDate.annee)
		return -1;
	if (annee > parDate.annee)
		return 1;
	// les annes sont =
	if (mois < parDate.mois)
		return -1;
	if (mois > parDate.mois)
		return 1;
	// les mois sont =
	if (jour < parDate.jour)
		return -1;
	if (jour > parDate.jour)
		return 1;
	return 0;	
  }
 
  /**
   * Date du lendemain.
   *
   * @return the date
   */
  public Date dateDuLendemain ()   {	
    if (jour < dernierJourDuMois(mois,annee))
		     return  new Date (jour+1,mois,annee);
		else if (mois < 12)
				return new Date (1,mois+1,annee);
			 else return new Date (1,1,annee+1);	
  }  
  
  /**
   * Date de la veille.
   *
   * @return the date
   */
  public Date dateDeLaVeille () {    
	if (jour > 1)
			return  new Date (jour-1,mois,annee);
	else if (mois > 1)
			   return new Date (Date.dernierJourDuMois(mois-1, annee),mois-1,annee);
		 else return  new Date (31,12,annee-1);
  }	 
  
  /**
   * Dernier jour du mois.
   *
   * @param parMois the par mois
   * @param parAnnee the par annee
   * @return the int
   */
  public static int dernierJourDuMois (int parMois, int parAnnee) {
		switch (parMois) {
			 case 2 : if (estBissextile (parAnnee))  return 29 ; else return 28 ;  
			 case 4 : 	 case 6 : 	 case 9 : 	 case 11 : return 30 ;
			 default : return 31 ;
			}  // switch
	  } 
	  
  /**
   * Est bissextile.
   *
   * @param parAnnee the par annee
   * @return true, if successful
   */
  private static boolean estBissextile(int parAnnee) {
			return parAnnee % 4 == 0 && (parAnnee % 100 != 0 || parAnnee % 400 == 0);
	  }
    
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString () {
    String chaine = new String();
    switch (jourSemaine) {
		 case 1: chaine = "dimanche"; break;
		 case 2: chaine = "lundi"; break;
		 case 3: chaine = "mardi"; break;
		 case 4: chaine = "mercredi"; break;
		 case 5: chaine = "jeudi"; break;
		 case 6: chaine = "vendredi"; break;
		 case 7: chaine = "samedi"; break;
		}
	chaine += " " + jour + " ";
	switch (mois) {
		 case 1: chaine += "janvier"; break;
		 case 2: chaine += "février"; break;
		 case 3: chaine += "mars"; break;
		 case 4: chaine += "avril"; break;
		 case 5: chaine += "mai"; break;
		 case 6: chaine += "juin"; break;
		 case 7: chaine += "juillet"; break;
		 case 8: chaine += "août"; break;
		 case 9: chaine += "septembre"; break;
		 case 10: chaine += "octobre"; break;
		 case 11: chaine += "novembre"; break;
		 case 12: chaine += "décembre"; break;
		}	
	return chaine;
  }  


/**
 * Gets the annee.
 *
 * @return the annee
 */
public int getAnnee() { 
	return annee;
}

/**
 * Gets the jour.
 *
 * @return the jour
 */
public int getJour() { 
	return jour;
}

/**
 * Gets the mois.
 *
 * @return the mois
 */
public int getMois() { 
	return mois;
}

/**
 * Gets the jour semaine.
 *
 * @return the jour semaine
 */
public int getJourSemaine () {
	return jourSemaine;
}

/**
 * retourne la date du premier jour de la semaine contenant this .
 *
 * @return the date
 */
public Date datePremierJourSemaine () {
	Date datePrem = this;	 
	while (datePrem.getJourSemaine()!=2) {
		datePrem = datePrem.dateDeLaVeille();
	}
	return datePrem;
}

/**
 * Checks if is today.
 *
 * @return true, if is today
 */
public boolean isToday() {
	return new Date().compareTo(this) == 0;
}
}  // class Date