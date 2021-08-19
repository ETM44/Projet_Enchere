package fr.eni.ecole.projet_enchere.bll;

import java.util.List;

import fr.eni.ecole.projet_enchere.bo.Categorie;
import fr.eni.ecole.projet_enchere.bo.Enchere;

/*NG 18/08/2021
 *Reprise des fonctionnalit�s de la DAL avec la contrainte suivante :
 *Lors de la cr�ation d'une ench�re, il faut tester si, en parcourant le liste,
 *il existe d�j� une ench�re du m�me article, du m�me utilisateur
 *Cr�ation d'un algo de tri par cat�gorie
 */

public interface CategorieManager {

	public void addCategorie(Categorie categorie) throws BLLException;

	public void setCategorie(Categorie categorie) throws BLLException;

	public void removeCategorie(Categorie categorie) throws BLLException;

	public List<Categorie> getAllCategorie() throws BLLException;

	public Categorie getCategorie(Categorie categorie) throws BLLException;
}
