package Modele;

import java.util.Collection;

import javax.swing.table.DefaultTableModel;

public class ModeleTable extends DefaultTableModel   {
	public ModeleTable (Date parDate, Timeline parTimeline) {
		this.setColumnCount(7);
		this.setRowCount(15);
		String[] abrJour = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
		Date date = parDate.datePremierJourSemaine();//A faire dans la classe Date
		for (int i = 0; i < 7; i++){
			abrJour[i] += " " + date.getJour();
			date = date.dateDuLendemain();
		}
		this.setColumnIdentifiers(abrJour);//les évênements de la semaine
		Collection<Evenement> evtsSemaine = parTimeline.getEvenementSemaine(parDate);//A faire dans la classe Agenda
		if (evtsSemaine != null){
			for(Evenement evts : evtsSemaine){
				ajoutEvenement(evts);//A ecrire
			}
		}
	}
	
	public void ajoutEvenement(Evenement parEvt){
		int indiceColonne = parEvt.getChDate().getJourSemaine();
		int indiceLigne = 0;
		while(indiceLigne < 15 && getValueAt(indiceLigne, indiceColonne) != null){
			indiceLigne++;
		}
		setValueAt(parEvt, indiceLigne, indiceColonne);
	}
	
	public boolean isCellEditable (int indiceLigne, int indiceColonne) {
		return false;
	}
	public Class getColumnClass (int parNum) {
		return Evenement.class;
	}
}