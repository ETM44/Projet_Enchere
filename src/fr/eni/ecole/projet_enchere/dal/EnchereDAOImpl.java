package fr.eni.ecole.projet_enchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.projet_enchere.bo.Enchere;

public class EnchereDAOImpl implements EnchereDAO {
	private final String INSERT = "INSERT INTO encheres(no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?,?,?,?)";
	private final String UPDATE = "UPDATE encheres SET date_enchere=?, montant_enchere=? WHERE no_utilisateur=? AND no_article=?";
	private final String DELETE = "DELETE FROM encheres WHERE no_utilisateur=? AND no_article=?";
	private final String SELECT = "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM encheres";
	private final String FROM = "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM encheres WHERE no_utilisateur=? AND no_article=?";
	
	private UtilisateurDAO utilDao = UtilisateurDAOFact.getInstance();
	private ArticleVenduDAO artDao = ArticleVenduDAOFact.getInstance();
	
	@Override
	public void insert(Enchere enchere) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) { 
			PreparedStatement stmt = con.prepareStatement(INSERT);
			stmt.setInt(1, enchere.getUtilisateurEncherit().getNoUtilisateur());
			stmt.setInt(2, enchere.getArticleConcerne().getNoArticle());
			stmt.setDate(3, Date.valueOf(enchere.getDateEnchere()));
			stmt.setInt(4, enchere.getMontant_enchere());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Probl�me SQL");
		}
	}

	@Override
	public void update(Enchere enchere) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) { 
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setDate(1, Date.valueOf(enchere.getDateEnchere()));
			stmt.setInt(2, enchere.getMontant_enchere());
			stmt.setInt(3, enchere.getUtilisateurEncherit().getNoUtilisateur());
			stmt.setInt(4, enchere.getArticleConcerne().getNoArticle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Probl�me SQL");
		}
	}

	@Override
	public void delete(Integer idUtilisateur, Integer idArticle) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) { 
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, idUtilisateur);
			stmt.setInt(2, idArticle);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Probl�me SQL");
		}
	}

	@Override
	public List<Enchere> selectAll() throws DALException {
		List<Enchere> result = new ArrayList<Enchere>();
		try (Connection con = ConnectionProvider.getConnection()) { 
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Enchere enchere = new Enchere();
				enchere.setUtilisateurEncherit(utilDao.selectById(rs.getInt("no_utilisateur")));
				enchere.setArticleConcerne(artDao.selectById(rs.getInt("no_article")));
				enchere.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				result.add(enchere);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Probl�me SQL");
		}
		return result;
	}

	@Override
	public Enchere selectById(Integer idUtilisateur, Integer idArticle) throws DALException {
		Enchere enchere = new Enchere();
		try (Connection con = ConnectionProvider.getConnection()) { 
			PreparedStatement stmt = con.prepareStatement(FROM);
			stmt.setInt(1, idUtilisateur);
			stmt.setInt(2, idArticle);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				enchere.setUtilisateurEncherit(utilDao.selectById(rs.getInt("no_utilisateur")));
				enchere.setArticleConcerne(artDao.selectById(rs.getInt("no_article")));
				enchere.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Probl�me SQL");
		}
		return enchere;
	}

}
