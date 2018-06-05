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
		String[] defautColonnes = {"1", "2", "3", "4", "5", "6", "7"};
		this.setColumnIdentifiers(defautColonnes);
		this.setColumnCount(7);
		this.setRowCount(4);
		
		
		
		this.finaliserTable();
		
		}
	private void finaliserTable()
		{
		
		}
	}