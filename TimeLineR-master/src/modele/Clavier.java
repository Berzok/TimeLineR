package modele;
// auteur : Claude Delannoy - Programmer en Java, �ditions Eyrolles

import java.io.*;
import java.util.concurrent.SynchronousQueue;

public class Clavier {
	
	public static String lireString (){
		String ligneLue = new String();
		try {
			InputStreamReader lecteur = new InputStreamReader(System.in);
			BufferedReader bufferEntree = new BufferedReader (lecteur);
			ligneLue = bufferEntree.readLine();
		} // try
		catch (IOException parExc) {
			System.exit(0);
		}  // catch
		return ligneLue;
	}  // lireString

	public static int lireInt () {
		int intLu = 0;
		try { 
			String ligneLue = lireString();
			intLu = Integer.parseInt (ligneLue);
		} // try
		catch (NumberFormatException parExc) {
			System.err.println ("Erreur dans la saisie");
			System.exit(0);
		}  // catch
		return intLu;
	}  // lireInt

	public static float lireFloat () {
		float floatLu = 0;
		try {
			String ligneLue = lireString();
			floatLu = Float.parseFloat (ligneLue);
		} // try
		catch (NumberFormatException parExc) {
			System.err.println ("Erreur dans la saisie");
			System.exit(0);
		}  // catch
		return floatLu;
	}  // lireFloat

	public static void ecrireFichier(Object objet) {
		File fichier = new File("C");
		ObjectOutputStream fluxOut;
		try {
			fluxOut = new ObjectOutputStream(new FileOutputStream("data" + File.separator + "fichier.obj"));
			fluxOut.writeObject(objet);
			fluxOut.flush();
			fluxOut.close();
		}//try

		catch(IOException parException){
			System.out.println("Erreur lors de l'ecriture");
		}//catch
	}
} // class Clavier
