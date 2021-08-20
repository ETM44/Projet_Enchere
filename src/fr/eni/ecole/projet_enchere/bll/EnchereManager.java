package fr.eni.ecole.projet_enchere.bll;

import java.util.List;

import fr.eni.ecole.projet_enchere.bo.Categorie;
import fr.eni.ecole.projet_enchere.bo.Enchere;
import fr.eni.ecole.projet_enchere.bo.Utilisateur;

/*NG 18/08/2021
 *Reprise des fonctionnalit�s de la DAL avec la contrainte suivante :
 *Lors de la cr�ation d'une ench�re, il faut tester si, en parcourant le liste,
 *il existe d�j� une ench�re du m�me article, du m�me utilisateur
 *Cr�ation d'un algo de tri par cat�gorie
 */

public interface EnchereManager {

	public void addEnchere(Enchere enchere) throws BLLException;

	public void setEnchere(Enchere enchere) throws BLLException;

	public void removeEnchere(Enchere enchere) throws BLLException;

	public List<Enchere> getAllEnchere() throws BLLException;

	public Enchere getEnchere(Enchere enchere) throws BLLException;

	public List<Enchere> getEnchereFiltre(String filtre) throws BLLException;

	public List<Enchere> getEnchereCategorieFiltre(Categorie categorie, String filtre) throws BLLException;

	public List<Enchere> getEnchereFiltreAchats(String filtre, String enchOuv, String enchCour, String enchRemp, Utilisateur utilisateur) throws BLLException;

	public List<Enchere> getEnchereCategorieFiltreAchats(Categorie categorie, String filtre, String enchOuv, String enchCour, String enchRemp, Utilisateur utilisateur) throws BLLException;

	public List<Enchere> getEnchereFiltreVentes(String filtre, String ventCour, String ventDeb, String ventTer, Utilisateur utilisateur) throws BLLException;

	public List<Enchere> getEnchereCategorieFiltreVentes(Categorie categorie, String filtre, String ventCour, String ventDeb, String ventTer, Utilisateur utilisateur) throws BLLException;

}
