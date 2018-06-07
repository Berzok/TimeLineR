/*
 * 
 */
package modele;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

// TODO: Auto-generated Javadoc
/**
 * The Class CellRenderer.
 */
public class CellRenderer extends DefaultTableCellRenderer
{
	
	/** The ch current evt. */
	private static ArrayList<Evenement> chCurrentEvt = new ArrayList<Evenement>();
 
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	@Override
    public Component getTableCellRendererComponent(JTable timeLine, Object laImage, boolean isSelected, boolean hasFocus, int row, int column)
    	{
        JLabel leLabel = new JLabel();
 
        if (laImage!=null)
        	{
        	leLabel.setHorizontalAlignment(JLabel.CENTER);
        	leLabel.setIcon(new ImageIcon(chCurrentEvt.get(chCurrentEvt.size()-1).getChImageURL()));
        	}
 
        return leLabel;
    	}
	
	/**
	 * Sets the evenement.
	 *
	 * @param parEvent the new evenement
	 */
	public static void setEvenement(Evenement parEvent){
		chCurrentEvt.add(parEvent);
	}
	
	}