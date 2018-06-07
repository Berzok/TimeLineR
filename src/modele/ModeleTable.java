package modele;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;


// TODO: Auto-generated Javadoc
/**
 * The Class ModeleTable.
 */
@SuppressWarnings("serial")
public class ModeleTable extends DefaultTableModel
	{
	
	/** The defaut colonnes. */
	static String[] defautColonnes;
	
	
	/**
	 * Instantiates a new modele table.
	 *
	 * @param parTimeline the par timeline
	 * @param beTrueOrNotToBeTrue the be true or not to be true
	 */
	public ModeleTable(Timeline parTimeline, Boolean beTrueOrNotToBeTrue)
		{
		this.finaliserTable(parTimeline);
		}


	/**
	 * Instantiates a new modele table.
	 *
	 * @param parTimeline the par timeline
	 */
	public ModeleTable(Timeline parTimeline)
		{
		this.finaliserTable(parTimeline);
		}
	
	/**
	 * Instantiates a new modele table.
	 */
	public ModeleTable()
		{
		String[] defautColonnes = {"1", "2", "3", "4", "5", "6", "7"};
		this.setColumnIdentifiers(defautColonnes);
		this.setColumnCount(7);
		this.setRowCount(3);
		
		
		
		
		}
	
	/**
	 * Finaliser table.
	 *
	 * @param parTimeline the par timeline
	 */
	private void finaliserTable(Timeline parTimeline)
		{
		defautColonnes = new String[parTimeline.getSize()];
		for(int i=0; i<defautColonnes.length; i++)
			{
			defautColonnes[i] = parTimeline.getEvenement(i).getChDate().getAnnee() + "";
			}
		ArrayList<Integer> valeur = new ArrayList<Integer>();
		ArrayList<String> valeur2 = new ArrayList<String>();
		for(int i=0; i<defautColonnes.length; i++)
			{
			valeur.add(Integer.parseInt(defautColonnes[i]));
			}
		Collections.sort(valeur);
		
		for (Integer i: valeur)
			{
		    valeur2.add(String.valueOf(i));
			}
		String[] defautColonnes = valeur2.toArray(new String[valeur2.size()]);
		this.setColumnIdentifiers(defautColonnes);
		this.setColumnCount(defautColonnes.length);
		this.setRowCount(4);
		}
	
	
	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	public Class<?> getColumnClass (int parIndex){
		return String.class;
		}
	
	/**
	 * Gets the table header.
	 *
	 * @return the table header
	 */
	public static String[] getTableHeader(){
		return defautColonnes;
		}
	}