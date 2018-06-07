package modele;
// auteur : Claude Delannoy - Programmer en Java, �ditions Eyrolles

import java.io.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Clavier.
 */
public class Clavier {
	
  /**
   * Lire string.
   *
   * @return the string
   */
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

/**
 * Lire int.
 *
 * @return the int
 */
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

/**
 * Lire float.
 *
 * @return the float
 */
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

} // class Clavier
