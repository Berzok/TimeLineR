package modele;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet ;


// TODO: Auto-generated Javadoc
/**
 * The Class Timeline.
 */
public class Timeline implements Serializable, Comparable<Evenement> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The map timeline. */
	private HashMap<Integer, Evenement> mapTimeline;
	
	/**
	 * Instantiates a new timeline.
	 */
	// Question 1, 5
	public Timeline() {
		mapTimeline = new HashMap<Integer, Evenement>();
	}
	
	/**
	 * Instantiates a new timeline.
	 *
	 * @param TreesetEvt the treeset evt
	 */
	@SuppressWarnings("unchecked")
	public Timeline(TreeSet<Evenement> TreesetEvt) {
		for(int i = 0 ; i < TreesetEvt.size() ; i ++) {
			mapTimeline.put(i, ((List<Evenement>) TreesetEvt).get(i));
		}
	}
	
	/**
	 * Ajout.
	 *
	 * @param parEvt the par evt
	 */
	// Question 1, 5
	public void ajout(Evenement parEvt) {
		mapTimeline.put(mapTimeline.size(), parEvt);
	}
	
	/**
	 * Ajout.
	 *
	 * @param key the key
	 * @param parEvt the par evt
	 */
	public void ajout(Integer key, Evenement parEvt){
		mapTimeline.put(key, parEvt);
	}
	
	/**
	 * Gets the evenement.
	 *
	 * @param key the key
	 * @return the evenement
	 */
	public Evenement getEvenement(Integer key){
		return mapTimeline.get(key);
	}
	
	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public HashMap<Integer, Evenement> getMap(){
		return mapTimeline;
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public Integer getSize(){
		return this.mapTimeline.size();
	}
	
	
	
	
	/**
	 * Gets the key.
	 *
	 * @param parEvt the par evt
	 * @return the key
	 */
	public Integer getKey(Evenement parEvt)
		{
		for(Integer key : mapTimeline.keySet())
			{
			if(mapTimeline.get(key).equals(parEvt))
				{
				return key;
				}
			}
		return 1;
		}
	
	
	/**
	 * Gets the max poids event.
	 *
	 * @return the max poids event
	 */
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
	
	/**
 * Verifie poids.
 *
 * @param key the key
 * @param timeline the timeline
 */
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
	
    /**
	 * Afficher contenu.
	 */
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
	
	/**
 * To string.
 *
 * @param parIndice the par indice
 * @return the string
 */
	public String toString(int parIndice)
		{
		String leString =  "Le "+ this.mapTimeline.get(parIndice).getChDate() + ", " + this.mapTimeline.get(parIndice).getChNom() + " à " + this.mapTimeline.get(parIndice).getChPoids();
		return leString;
		}
	
	public static Timeline generateTimeline(Integer n)
		{
		Timeline nouvelleTimeline = new Timeline();
		Evenement eventUn = new Evenement("Naissance", new Date(7, 1, 1964), "Jour de la naissance de Nicolas Cage, un dieu divin !", 1);
		eventUn.setImageURL("images/Naissance.png");
		eventUn.setChCol(0);
		
		Evenement eventDeux = new Evenement("Fashion", new Date(7, 1, 1964), "Nicolas Cage se lance à l'attaque du monde de la mode !", 2);
		eventDeux.setImageURL("images/Fashion.jpg");
		eventDeux.setChCol(1);
		
		
		Evenement eventTrois = new Evenement("Capillarité", new Date(7, 1, 1964), "Nicolas Cage devient à moitié aigle et se prépare à prendre son envol !", 1);
		eventTrois.setImageURL("images/cheveux.jpg");
		eventTrois.setChCol(2);
		
		
		Evenement eventQuatre = new Evenement("Jedi", new Date(7, 1, 1964), "Après avoir enfin maîtrisé la Force, Nicolas Cage devint le plus grand des chevaliers Jedi", 2);
		eventQuatre.setImageURL("images/jedi.png");
		eventQuatre.setChCol(3);
		
		
		
		nouvelleTimeline.ajout(eventUn);
		nouvelleTimeline.ajout(eventDeux);
		nouvelleTimeline.ajout(eventTrois);
		nouvelleTimeline.ajout(eventQuatre);
		
		
		return nouvelleTimeline; 
		}
	


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Evenement o)
		{
		// TODO Auto-generated method stub
		return 0;
		}
	}






