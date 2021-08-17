package fr.eni.ecole.projet_enchere.bll;

import java.util.List;

import fr.eni.ecole.projet_enchere.bo.Utilisateur;
import fr.eni.ecole.projet_enchere.dal.UtilisateurDAO;
import fr.eni.ecole.projet_enchere.dal.UtilisateurDAOFact;

public class UtilisateurManagerImpl implements UtilisateurManager {

	private UtilisateurDAO dao = UtilisateurDAOFact.getInstance();
	private boolean areInDatabase = false;

	@Override
	public void insert(Utilisateur utilisateur) throws Exception {
		// test de l'existence du pseudo et du mail dans la liste utilisateur

		for (Utilisateur element : dao.selectAll()) {
			if (element.getPseudo().equals(utilisateur.getPseudo())
					&& element.getEmail().equals(utilisateur.getEmail())) {
				System.out.println("utilisateurmanagerbll : verif login et mail");
				throw new BLLException("Login ou mail d�j� en base de donn�e,merci de changer de login ou de mail");

			}
		}
		// test de l'existence de caract�res uniquement alaphanum�rique
		if (utilisateur.getPseudo().matches("[a-zA-Z0-9]*$")) {
			System.out.println("utilisateurmanagerbll : verif caract alphanumerique du login");
			dao.insert(utilisateur);
		} else {
			throw new BLLException("N'utilisez que des caract�res alphanum�riques, s'il vous pla�t");
		}
	}

	@Override
	public void update(Utilisateur utilisateur) throws Exception {
		dao.update(utilisateur);

	}

	@Override
	public void delete(Integer id) throws Exception {
		dao.delete(id);

	}

	@Override
	public List<Utilisateur> selectAll() throws Exception {

		return dao.selectAll();
	}

	@Override
	public Utilisateur selectById(Integer id) throws Exception {
		
		return dao.selectById(id); 
	}
	
	@Override
	public boolean logAndPassChecked(Utilisateur utilisateur) throws Exception {

		// test de l'existence du pseudo et du mail dans la liste utilisateur
		for (Utilisateur element : dao.selectAll()) {
			if (element.getPseudo().equals(utilisateur.getPseudo())
					&& element.getEmail().equals(utilisateur.getEmail())) {
				System.out.println("utilisateurmanagerbll : verif login et mail en base de donn�e");

				areInDatabase = true;
			}
		}
		return areInDatabase;
	}
}
