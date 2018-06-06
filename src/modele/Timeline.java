package modele;
import java.io.Serializable;
import java.util.ArrayList ;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet ;

import javax.swing.event.TreeSelectionEvent;


public class Timeline implements Serializable, Comparable<Evenement> {
	private TreeSet<Evenement> arbreEvts;
	private HashMap<Integer, Evenement> mapTimeline;
	
	// Question 1, 5
	public Timeline() {
		arbreEvts = new TreeSet<Evenement>() ;
		mapTimeline = new HashMap<Integer, Evenement>();
	}
	
	public Timeline(TreeSet<Evenement> TreesetEvt) {
		for(int i = 0 ; i < TreesetEvt.size() ; i ++) {
			mapTimeline.put(i, ((List<Evenement>) TreesetEvt).get(i));
		}
	}
	
	// Question 1, 5
	public void ajout(int key , Evenement parEvt) {
		mapTimeline.put(key, parEvt);
	}
	
	public Evenement getEvenement(Integer key){
		return mapTimeline.get(key);
	}
	
	public Integer getSize(){
		return this.mapTimeline.size();
	}
	
//	// Question 2
//	public int compareTo( int key , Timeline timeline) {
//		for(int i ; )
//			if(timeline.get(key).getPoids() == timeline2.get(key).getPoids())
//				Evenement nEvt = new Evenement(timeline2.get(key).getDate, timeline2.get(key).getNom, timeline2.get(key).getPoids - 1);
//				timeline2.put(key, nEvt);
//	}
	
	// Question 2
	public void verifiePoids( int key , Timeline timeline) {
		for(int i = 0 ; i < timeline.mapTimeline.size() ; i++)
			if(timeline.mapTimeline.get(key).getChDate() == timeline.mapTimeline.get(i).getChDate()) {
				if(timeline.mapTimeline.get(key).getPoids() == timeline.mapTimeline.get(i).getPoids()) {
					Evenement nEvt = new Evenement(timeline.mapTimeline.get(key).getChDate(), timeline.mapTimeline.get(key).getChNom(), timeline.mapTimeline.get(key).getChDesc(), timeline.mapTimeline.get(key).getPoids() - 1);
					timeline.mapTimeline.put(key, nEvt);
				}
			}
	}
	
	
	// Question 3
//	public int nbExpose() {
//		int iter = 0 ;// le nombre de fois où il y a "exposé" dans le titre
//		for(int index = 0 ; index < this.listEvts.size() ; index++) {
//			if(this.listEvts.get(index).getChNom().contains("exposé"))
//				iter++ ;
//		}
//		return iter;
//	}
	
    public void afficherContenu()
    	{
    	System.out.println(this.mapTimeline.get(1).getChDate());
    	for(int i=1; i<this.mapTimeline.size(); i++)
    		{
    		System.out.println("Le "+ this.mapTimeline.get(i).getChDate() + ", " + this.mapTimeline.get(i).getChNom());
    		}
    	}
	
//	// Question 4
//	public int nbEvtEnregistre(Timeline parTimeline) {
//		int nbEvts = 0 ;
//		Iterator<Evenement> iter = this.arbreEvts.iterator();
//		while(iter.hasNext())
//			if (iter.next().getChDate().compareTo(parTimeline)==0)
//				nbEvts++ ;
//		return nbEvts ;
//	}
	
	public String toString(int parIndice)
		{
		String leString =  "Le "+ this.mapTimeline.get(parIndice).getChDate() + ", " + this.mapTimeline.get(parIndice).getChNom() + " à " + this.mapTimeline.get(parIndice).getChPoids();
		return leString;
		}

	@Override
	public int compareTo(Evenement o)
		{
		// TODO Auto-generated method stub
		return 0;
		}
	}






