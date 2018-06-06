package modele;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet ;


@SuppressWarnings("serial")
public class Timeline implements Serializable, Comparable<Evenement> {
	private HashMap<Integer, Evenement> mapTimeline;
	
	// Question 1, 5
	public Timeline() {
		mapTimeline = new HashMap<Integer, Evenement>();
	}
	
	@SuppressWarnings("unchecked")
	public Timeline(TreeSet<Evenement> TreesetEvt) {
		for(int i = 0 ; i < TreesetEvt.size() ; i ++) {
			mapTimeline.put(i, ((List<Evenement>) TreesetEvt).get(i));
		}
	}
	
	// Question 1, 5
	public void ajout(Evenement parEvt) {
		mapTimeline.put(mapTimeline.size(), parEvt);
	}
	
	public Evenement getEvenement(Integer key){
		return mapTimeline.get(key);
	}
	
	public Integer getSize(){
		return this.mapTimeline.size();
	}
	
	public Integer getSameEvents(){
		Integer nombre = 0;
		Evenement[] valeur = mapTimeline.values().toArray(new Evenement[mapTimeline.size()]);
		for(int i=0; i<valeur.length; i++)
			{
			for(int j=i+1; j<valeur.length; j++)
				{
				if(valeur[i]==valeur[j])
					{
					nombre++;
					}
				}
			}
		return nombre;
	}
	
	public Integer getMaxPoidsEvent(){
		Integer nombre = 0;
		Evenement[] valeur = mapTimeline.values().toArray(new Evenement[mapTimeline.size()]);
		for(int i=0; i<valeur.length; i++)
			{
			if(valeur[i].getChPoids()>nombre)
				{
				nombre = valeur[i].getChPoids();
				}
			}
		return nombre;
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
					Evenement nEvt = new Evenement(timeline.mapTimeline.get(key).getChNom(), timeline.mapTimeline.get(key).getChDate(), timeline.mapTimeline.get(key).getChDesc(), timeline.mapTimeline.get(key).getPoids() - 1);
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






