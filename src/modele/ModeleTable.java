package modele;

import javax.swing.table.DefaultTableModel;


public class ModeleTable extends DefaultTableModel
	{
	public ModeleTable(Timeline parTimeline)
		{
		if(parTimeline.equals(null))
			new ModeleTable();
		
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
		
		}
	}