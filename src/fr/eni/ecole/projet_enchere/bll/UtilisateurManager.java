package fr.eni.ecole.projet_enchere.bll;

import java.util.List;

import fr.eni.ecole.projet_enchere.bo.ArticleVendu;
import fr.eni.ecole.projet_enchere.bo.Utilisateur;

/*Il a �t� choisi de centraliser toutes les contraintes dans une BLL unique :
 * NG 16/08/2021, cr�ation :
 * 1/ Utilisateur : Reprise des fonctionalit�s du DAO en ajoutant des cotraintes en EnchereManagerImpl
 * 2/ Utilisateur : V�rification du login et mot de passe en base de donn�e
 */
public interface UtilisateurManager {

	public void addUtilisateur(Utilisateur utilisateur) throws BLLException;

	public void setUtilisateur(Utilisateur utilisateur) throws BLLException;

	public void removeUtilisateur(Utilisateur utilisateur) throws BLLException;

	public List<Utilisateur> getAllUtilisateurs() throws BLLException;

	public Utilisateur getUtilisateur(Utilisateur utilisateur) throws BLLException;

	boolean logAndPassChecked(Utilisateur utilisateur) throws BLLException;

	boolean passChecked(Utilisateur utilisateur) throws BLLException;

	boolean newPassChecked(String newPass, String confPass) throws BLLException;

	boolean articleRemporteChecked(Utilisateur utilisateur, ArticleVendu articleRemporte) throws BLLException;
	
	boolean retraitValideChecked(Utilisateur utilisateur, ArticleVendu articleValide) throws BLLException; 
}
