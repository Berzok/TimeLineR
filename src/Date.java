
public class Date
	{
	private int chJour;
	private int chMois;
	private int chYear;
	public Date()
		{
		System.out.print("Jour: ");
		int leJour = Clavier.lireInt();
		System.out.print("Mois: ");
		int leMois = Clavier.lireInt();
		System.out.print("Year: ");
		int leYear = Clavier.lireInt();
		Date d = new Date(leJour, leMois, leYear);
		}
	public Date (int parJour, int parMois, int parYear)
		{
		this.chJour=parJour;
		this.chMois=parMois;
		this.chYear=parYear;
		}
	public String toString()
		{
		return chJour +"/"+ chMois +"/"+ chYear;
		}
	public boolean estValide()
		{
		if(chYear < 1583 || chMois < 1 || this.chMois>12 || this.chJour<1 || this.chJour>31)
			return false;
		if(this.chYear%4==0 && this.chYear%100!=0)
			if(this.chMois==2)
				if(this.chJour>29)
					return false;
				if(this.chJour<=29)
					return true;
		return true;
		}
	public static Date lireDate()
		{
		System.out.print("Jour: ");
		int leJour = Clavier.lireInt();
		System.out.print("Mois: ");
		int leMois = Clavier.lireInt();
		System.out.print("Year: ");
		int leYear = Clavier.lireInt();
		Date d = new Date(leJour, leMois, leYear);
		return d;
		}
	}
