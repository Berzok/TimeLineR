package modele;

import javax.swing.table.DefaultTableModel;


public class ModeleTable extends DefaultTableModel
	{
	public ModeleTable(Timeline parTimeline)
		{
		this.finaliserTable();
		}
	public ModeleTable()
		{
		String[] defautColonnes;
		for (int i = 1950 ; i < 2019 ; i++) {
			defautColonnes[i] = i.toString();
		}
		//String[] defautColonnes = {"1", "2", "3", "4", "5", "6", "7"};
		this.setColumnIdentifiers(defautColonnes);
		this.setColumnCount(i);
		this.setRowCount(4);
		
		
		
		this.finaliserTable();
		
		}
	private void finaliserTable()
		{
		
		}
	}