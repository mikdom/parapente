import java.io.*;

/**
 * Classe permettant d'�crire et lire dans un fichier. Elle permet d'�crire les
 * diff�rents types primitifs (byte, short, ...) + des objets ( String, tableau
 * ou tout autre objet qui impl�mente l'interface java.io.Serializable). Les
 * m�thodes de cette classe peuvent lancer des exceptions. (fin de fichier,
 * erreur de lecture ou �criture, etc.) Pour cr�er un fichier : il faut appeler
 * le constructeur en lui passant en param�tre une String sp�cifiant le chemin
 * d'acc�s et le nom du fichier. Ensuite, il faut l'ouvrir en �criture. Enfin,
 * on peut y �crire les donn�es. Lors de l'�criture dans un fichier existant, le
 * contenu est �cras� et remplac� par la(es) donn�e(s) �crite(s). Pour lire un
 * fichier existant, il faut cr�er un objet de la classe Fichier, en lui
 * renseignant le chemin d'acc�s et le nom du fichier. Ensuite, il faut l'ouvrir
 * en lecture. Enfin, il peut �tre lu, enregistrement par enregistrement. Si la
 * fin du fichier est rencontr�e, une exception de type "java.io.EOFException"
 * est lanc�e. Le fichier doit �tre ferm� en utilisant la m�thode "fermer()".
 * 
 * @author O.Legrand
 * @version 1.0
 */
public class Fichier {

	private ObjectOutputStream out; // objet servant � l'�criture dans le stream
	private ObjectInputStream in; // objet servant � la lecture dans le stream
	private String nomFichier; // contient le nom complet du fichier. (
								// path+nom)

	/**
	 * constructeur de la classe Fichier.
	 * 
	 * @param nomFichier
	 *            String sp�cifiant le chemin d'acc�s et le nom du fichier.
	 *            Exemple : "C:/java/dossier/donnees.dat" ('/' obligatoire et
	 *            non '\')
	 */
	public Fichier(String nomFichier) {
		this.nomFichier = nomFichier;
		in = null;
		out = null;
	}

	/**
	 * ouverture du fichier en �criture
	 * 
	 * @throws java.io.IOException
	 *             si erreur lors de l'ouverture en �criture.
	 */
	public void ouvrirEnEcriture() throws java.io.IOException {
		if (out != null || in != null) {
			throw new java.io.IOException("fichier d�j� ouvert");
		}
		out = new ObjectOutputStream(new FileOutputStream(nomFichier));
	}

	/**
	 * ouverture du fichier en lecture
	 * 
	 * @throws java.io.IOException
	 *             si erreur lors de l'ouverture en lecture.
	 */
	public void ouvrirEnLecture() throws java.io.IOException {
		if (out != null || in != null) {
			throw new java.io.IOException("fichier d�j� ouvert");
		}
		in = new ObjectInputStream(new FileInputStream(nomFichier));
	}

	/**
	 * �criture d'un r�el de type float dans le fichier.
	 * 
	 * @param r�el
	 *            le nombre r�el � �crire dans le fichier.
	 * @throws java.io.IOException
	 *             si erreur lors de l'�criture.
	 */
	public void ecrireFloat(float reel) throws java.io.IOException {
		out.writeFloat(reel);
	}

	/**
	 * lecture d'un r�el de type float dans le fichier.
	 * 
	 * @return le nombre r�el lu dans le fichier.
	 * @throws java.io.EOFException
	 *             si fin de fichier rencontr�e.
	 * @throws java.io.IOException
	 *             si erreur lors de la lecture.
	 */
	public float lireFloat() throws java.io.EOFException, java.io.IOException {
		return in.readFloat();
	}

	/**
	 * �criture d'un r�el de type double dans le fichier.
	 * 
	 * @param r�el
	 *            le nombre r�el � �crire dans le fichier.
	 * @throws java.io.IOException
	 *             si erreur lors de l'�criture.
	 */
	public void ecrireDouble(double reel) throws java.io.IOException {
		out.writeDouble(reel);
	}

	/**
	 * lecture d'un r�el de type double dans le fichier.
	 * 
	 * @return le nombre r�el lu dans le fichier.
	 * @throws java.io.EOFException
	 *             si fin de fichier rencontr�e.
	 * @throws java.io.IOException
	 *             si erreur lors de la lecture.
	 */
	public double lireDouble() throws java.io.EOFException, java.io.IOException {
		return in.readDouble();
	}

	/**
	 * �criture d'un entier de type byte dans le fichier.
	 * 
	 * @param entier
	 *            le nombre entier � �crire dans le fichier.
	 * @throws java.io.IOException
	 *             si erreur lors de l'�criture.
	 */
	public void ecrireByte(byte entier) throws java.io.IOException {
		out.writeByte(entier);
	}

	/**
	 * lecture d'un entier de type byte dans le fichier.
	 * 
	 * @return le nombre entier lu dans le fichier.
	 * @throws java.io.EOFException
	 *             si fin de fichier rencontr�e.
	 * @throws java.io.IOException
	 *             si erreur lors de la lecture.
	 */
	public byte lireByte() throws java.io.EOFException, java.io.IOException {
		return in.readByte();
	}

	/**
	 * �criture d'un entier de type short dans le fichier.
	 * 
	 * @param entier
	 *            le nombre entier � �crire dans le fichier.
	 * @throws java.io.IOException
	 *             si erreur lors de l'�criture.
	 */
	public void ecrireShort(short entier) throws java.io.IOException {
		out.writeShort(entier);
	}

	/**
	 * lecture d'un entier de type short dans le fichier.
	 * 
	 * @return le nombre entier lu dans le fichier.
	 * @throws java.io.EOFException
	 *             si fin de fichier rencontr�e.
	 * @throws java.io.IOException
	 *             si erreur lors de la lecture.
	 */
	public short lireShort() throws java.io.EOFException, java.io.IOException {
		return in.readShort();
	}

	/**
	 * �criture d'un entier de type int dans le fichier.
	 * 
	 * @param entier
	 *            le nombre entier � �crire dans le fichier.
	 * @throws java.io.IOException
	 *             si erreur lors de l'�criture.
	 */
	public void ecrireInt(int entier) throws java.io.IOException {
		out.writeInt(entier);
	}

	/**
	 * lecture d'un entier de type int dans le fichier.
	 * 
	 * @return le nombre entier lu dans le fichier.
	 * @throws java.io.EOFException
	 *             si fin de fichier rencontr�e.
	 * @throws java.io.IOException
	 *             si erreur lors de la lecture.
	 */
	public int lireInt() throws java.io.EOFException, java.io.IOException {
		return in.readInt();
	}

	/**
	 * �criture d'un entier de type long dans le fichier.
	 * 
	 * @param entier
	 *            le nombre entier � �crire dans le fichier.
	 * @throws java.io.IOException
	 *             si erreur lors de l'�criture.
	 */
	public void ecrireLong(long entier) throws java.io.IOException {
		out.writeLong(entier);
	}

	/**
	 * lecture d'un entier de type long dans le fichier.
	 * 
	 * @return le nombre entier lu dans le fichier.
	 * @throws java.io.EOFException
	 *             si fin de fichier rencontr�e.
	 * @throws java.io.IOException
	 *             si erreur lors de la lecture.
	 */
	public long lireLong() throws java.io.EOFException, java.io.IOException {
		return in.readLong();
	}

	/**
	 * �criture d'un bool�en dans le fichier.
	 * 
	 * @param bool�en
	 *            le bool�en � �crire dans le fichier.
	 * @throws java.io.IOException
	 *             si erreur lors de l'�criture.
	 */
	public void ecrireBoolean(boolean booleen) throws java.io.IOException {
		out.writeBoolean(booleen);
	}

	/**
	 * lecture d'un bool�en dans le fichier.
	 * 
	 * @return le bool�en lu dans le fichier.
	 * @throws java.io.EOFException
	 *             si fin de fichier rencontr�e.
	 * @throws java.io.IOException
	 *             si erreur lors de la lecture.
	 */
	public boolean lireBoolean() throws java.io.EOFException,
			java.io.IOException {
		return in.readBoolean();
	}

	/**
	 * �criture d'un objet dans le fichier. Rem.: la classe de cet objet doit
	 * impl�menter l'interface java.io.Serializable (cette interface ne poss�de
	 * aucun champ, ni aucune m�thode)
	 * 
	 * @param objet
	 *            l'objet � �crire dans le fichier.
	 * @throws java.io.IOException
	 *             si erreur lors de l'�criture.
	 */
	public void ecrireObjet(Object objet) throws java.io.IOException {
		out.writeObject(objet);
	}

	/**
	 * lecture d'un objet dans le fichier. Exemple : Etudiant �tudiant =
	 * (Etudiant) fichier.lireObjet();
	 * 
	 * @return l'objet lu dans le fichier.
	 * @throws java.io.EOFException
	 *             si fin de fichier rencontr�e.
	 * @throws java.io.IOException
	 *             si erreur lors de la lecture.
	 * @throws Exception
	 *             si autre erreur.
	 */
	public Object lireObjet() throws java.io.EOFException, java.io.IOException,
			Exception {
		return in.readObject();
	}

	/**
	 * �criture d'un caract�re dans le fichier.
	 * 
	 * @param caract�re
	 *            le caract�re � �crire dans le fichier.
	 * @throws java.io.IOException
	 *             si erreur lors de l'�criture.
	 */
	public void ecrireChar(char caractere) throws java.io.IOException {
		out.writeChar(caractere);
	}

	/**
	 * lecture d'un caract�re dans le fichier.
	 * 
	 * @return le caract�re lu dans le fichier.
	 * @throws java.io.EOFException
	 *             si fin de fichier rencontr�e.
	 * @throws java.io.IOException
	 *             si erreur lors de la lecture.
	 */
	public char lireChar() throws java.io.EOFException, java.io.IOException {
		return in.readChar();
	}

	/**
	 * fermeture du fichier.
	 * 
	 * @throws java.io.IOException
	 *             si erreur lors de la fermeture.
	 */
	public void fermer() throws java.io.IOException {
		if (out != null)
			fermerOut();
		if (in != null)
			fermerIn();
	}

	/**
	 * suppression du fichier.
	 * 
	 * @throws java.io.IOException
	 *             si erreur lors de la suppression.
	 */
	public void supprimer() throws java.io.IOException {
		fermer();
		File file = null;
		try {
			file = new File(nomFichier);
			file.delete();
		} catch (NullPointerException ex) {
			/*
			 * afin que toutes les m�thodes renvoient une exception du m�me type
			 * : java.io.IOException.
			 */
			throw new java.io.IOException(ex.getMessage());
		}
	}

	// fermeture de l'input stream.
	private void fermerIn() throws java.io.IOException {
		in.close();
		in = null;
	}

	// fermeture de l'output stream
	private void fermerOut() throws java.io.IOException {
		out.flush();
		out.close();
		out = null;
	}

} // fin de la classe