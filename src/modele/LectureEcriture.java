package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;

// TODO: Auto-generated Javadoc
/**
 * The Class LectureEcriture.
 */
public class LectureEcriture
	{
	
	/**
	 * Lecture.
	 *
	 * @param parFichier the par fichier
	 * @return the object
	 */
	public static Object lecture (File parFichier)
		{
		ObjectInputStream flux ;
		Object objetLu = null;
		// Ouverture du fichier en mode lecture
		
		try
			{
			flux = new ObjectInputStream(new FileInputStream (parFichier));
			objetLu = (Object)flux.readObject ();
			flux.close ();
			}
		catch (ClassNotFoundException parException)
			{
			System.err.println (parException.toString ());
			System.exit (1);
			}
		catch (IOException parException) 
			{
			System.err.println ("Erreur lecture du fichier " + parException.toString ());
			System.exit (1);
			}
		
		return objetLu ;
		}  // lecture ()
	
	
		/**
		 * Ecriture.
		 *
		 * @param parFichier the par fichier
		 * @param parObjet the par objet
		 */
		public static void ecriture (File parFichier, Object parObjet)
			{
			ObjectOutputStream flux = null;
			// 	Ouverture du fichier en mode écriture
			try
				{
				flux = new ObjectOutputStream (new FileOutputStream (parFichier));
				flux.writeObject (parObjet);
				flux.flush ();
				flux.close ();
				}
			catch (IOException parException)
				{
				System.err.println ("Probleme a l’ecriture\n" + parException.toString ());
				System.exit (1);
				}
			} //  ecriture ()
		
		/**
		 * Copier fichier.
		 *
		 * @param source the source
		 * @param dest the dest
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static void copierFichier(File source, File dest) throws IOException {
		    FileChannel sourceChannel = null;
		    FileChannel destChannel = null;
		    try {
		        sourceChannel = new FileInputStream(source).getChannel();
		        destChannel = new FileOutputStream(dest).getChannel();
		        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		       }finally{
		           sourceChannel.close();
		           destChannel.close();
		   }
		}
	}