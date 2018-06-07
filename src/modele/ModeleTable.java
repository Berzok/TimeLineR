package modele;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class ModeleTable extends DefaultTableModel
	{
	static String[] defautColonnes;
	
	public ModeleTable(Timeline parTimeline)
		{
		this.finaliserTable(parTimeline);
		}
	public ModeleTable()
		{
		String[] defautColonnes = {"1", "2", "3", "4", "5", "6", "7"};
		this.setColumnIdentifiers(defautColonnes);
		this.setColumnCount(7);
		this.setRowCount(3);
		
		
		
		
		}
	
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
	
	
	public Class<?> getColumnClass (int parIndex){
		return String.class;
		}
	
	public static String[] getTableHeader(){
		return defautColonnes;
		}
	}