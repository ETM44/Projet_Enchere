package fr.eni.ecole.projet_enchere.bll;

import java.util.List;

import fr.eni.ecole.projet_enchere.bo.Utilisateur;

/*Il a �t� choisi de centraliser toutes les contraintes dans une BLL unique :
 * NG 16/08/2021, cr�ation :
 * 1/ Utilisateur : Reprise des fonctionalit�s du DAO en ajoutant des cotraintes en EnchereManagerImpl
 * 2/ Utilisateur : V�rification du login et mot de passe en base de donn�e
 */
public interface UtilisateurManager {
	
	public void insert(Utilisateur utilisateur) throws Exception;
	
	public void update(Utilisateur utilisateur) throws Exception;

	public void delete(Integer id) throws Exception;
	
	public List<Utilisateur> selectAll() throws Exception;
	
	public Utilisateur selectById(Integer id) throws Exception;

	boolean logAndPassChecked(Utilisateur utilisateur) throws Exception;

}
