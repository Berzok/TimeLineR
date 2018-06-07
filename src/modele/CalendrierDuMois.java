package modele;
import java.util.TreeSet;
import java.util.Collection;

// TODO: Auto-generated Javadoc
/**
 * The Class CalendrierDuMois.
 */
public class CalendrierDuMois
	{
	
	/** The dates. */
	private Collection <Date> dates;
	
	/**
	 * Instantiates a new calendrier du mois.
	 *
	 * @param mois the mois
	 * @param annee the annee
	 */
	public CalendrierDuMois ( int mois, int annee)
		{
		dates = new TreeSet <Date> ();
		Date date = new Date (1,mois,annee);
		int indiceJour = date.getJourSemaine() == 1 ? 6 : date.getJourSemaine()-2;
		for (int x = indiceJour ; x>=0 ; x--)
			{
			dates.add(date);	    	
			date = date.dateDeLaVeille();
			}    
		date = new Date (2,mois,annee);
		indiceJour = indiceJour+1 % 7 ;
		while (date.getMois () == mois)
			{
			while(indiceJour<7)
				{
				dates.add(date);
				date = date.dateDuLendemain();
				indiceJour++ ;
				}
			indiceJour=0;
			}
		}
  
	/**
	 * Gets the dates.
	 *
	 * @return the dates
	 */
	public Collection <Date> getDates()
		{
		return dates;
		}
	}