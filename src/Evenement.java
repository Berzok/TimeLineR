
public class Evenement
	{
	private Date chDate;
	private String chNom;
	private String chLieu;
	static private int Nombre = 0;
	public Evenement(Date parD, String parN, String parL)
		{
		chDate = parD;
		chNom = parN;
		chLieu = parL;
		Nombre++;
		}
	public void afficher()
		{
		System.out.println(chDate + " " + chNom + " " + chLieu);
		}
	public void modifier()
		{
		chDate = new Date();
		chNom = Clavier.lireString();
		chLieu = Clavier.lireString();
		}
	public static void main(String[] args)
		{
		Evenement today = new Evenement(new Date(), Clavier.lireString(), Clavier.lireString());
		today.afficher();
		today.modifier();
		}
	}