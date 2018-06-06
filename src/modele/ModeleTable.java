package modele;

import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class ModeleTable extends DefaultTableModel
	{
	String[] defautColonnes;
	
	public ModeleTable(Timeline parTimeline)
		{
		this.finaliserTable(parTimeline);
		}
	public ModeleTable()
		{
		String[] defautColonnes = {"1", "2", "3", "4", "5", "6", "7"};
		this.setColumnIdentifiers(defautColonnes);
		this.setColumnCount(7);
		this.setRowCount(4);
		
		
		
		
		}
	
	private void finaliserTable(Timeline parTimeline)
		{
		defautColonnes = new String[parTimeline.getSize()];
		for(int i=0; i<defautColonnes.length; i++)
			{
			defautColonnes[i] = parTimeline.getEvenement(i).getChDate().getAnnee() + "";
			}
		this.setColumnIdentifiers(defautColonnes);
		this.setColumnCount(defautColonnes.length);
		this.setRowCount(4);
		System.out.println(defautColonnes.length);
		}
	}