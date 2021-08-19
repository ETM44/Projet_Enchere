package fr.eni.ecole.projet_enchere.bll;

import java.time.LocalDate;

import fr.eni.ecole.projet_enchere.bo.ArticleVendu;
import fr.eni.ecole.projet_enchere.bo.Categorie;
import fr.eni.ecole.projet_enchere.bo.Enchere;
import fr.eni.ecole.projet_enchere.bo.EtatsVente;
import fr.eni.ecole.projet_enchere.bo.Utilisateur;
import fr.eni.ecole.projet_enchere.dal.ArticleVenduDAO;
import fr.eni.ecole.projet_enchere.dal.ArticleVenduDAOFact;
import fr.eni.ecole.projet_enchere.dal.DALException;
import fr.eni.ecole.projet_enchere.dal.UtilisateurDAO;
import fr.eni.ecole.projet_enchere.dal.UtilisateurDAOFact;

public class TestEnchereManager {
	public static void main(String[] args) throws DALException, BLLException {

		EnchereManager manager = EnchereManagerSingl.getInstance();
		Categorie informatique = new Categorie("Informatique");
		Categorie ameublement = new Categorie("Ameublement");
		EnchereManager enchMan = EnchereManagerSingl.getInstance();
		UtilisateurDAO utilDao = UtilisateurDAOFact.getInstance();
		ArticleVenduDAO artDao = ArticleVenduDAOFact.getInstance();

		System.out.println("TEST 1 : INSERTION DE DEUX ENCHERES");		
		Enchere enchere1 = new Enchere(LocalDate.of(2018, 8, 10), 210,
				new Utilisateur(1,"pseudo1", "nom1","prenom1","email1","telephone1","rue1","cp1","ville1","mot_de_passe1",0,false),
				new ArticleVendu(1, "PC Gamer", "PC Gamer pour travailler", LocalDate.now().plusDays(5),
						LocalDate.now().plusDays(20), 210, null, EtatsVente.CREEE, null, null, informatique, null));
		
		Enchere enchere2 = new Enchere(LocalDate.of(2018, 10, 9), 180,
				new Utilisateur(2,"pseudo2", "nom2","prenom2","email2","telephone2","rue2","cp2","ville2","mot_de_passe2",0,false),
				new ArticleVendu(2, "Rocket Stove", "Rocket Stove pour riz et p�tes",
						LocalDate.now().plusDays(8), LocalDate.now().plusDays(30), 185, null, EtatsVente.CREEE, null, null,
						ameublement, null));


		Enchere enchere3 = new Enchere(LocalDate.of(2018, 8, 10), 210, utilDao.selectById(13), artDao.selectById(1));

		System.out.println("TEST 2 : TRI PAR CATEGORIE (MOCK)");
		System.out.println(manager.getAllEnchereCategorie(ameublement));
		enchMan.addEnchere(enchere1);
		enchMan.addEnchere(enchere1);
		System.out.println(enchMan.getAllEnchere());

	}
}