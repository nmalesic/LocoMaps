package com.locomaps.edd.bl.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.locomaps.edd.bl.model.Adresse2D;
import com.locomaps.edd.bl.model.GoogleGeoCodeResponse;
import com.locomaps.edd.bl.model.User;

import fcoe.com.tetris.Connexion.ConnexionDBTetris;
import fcoe.com.tetris.Connexion.Score;

public class ConnexionDB {

	private String chaineConnection = "jdbc:sqlite:";
	private static Statement statement;
	private static Connection connection;
	private static ConnexionDB connexionDB = null;

	public String getChaineConnection() {
		return chaineConnection;
	}

	public void setChaineConnection(String chaineConnection) {
		this.chaineConnection = chaineConnection;
	}

	public static Statement getStatement() {
		return statement;
	}

	public static void setStatement(Statement statement) {
		ConnexionDB.statement = statement;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		ConnexionDB.connection = connection;
	}

	public static ConnexionDB getConnexionDB() {
		return connexionDB;
	}

	public static void setConnexionTetris(ConnexionDB connexionDB) {
		ConnexionDB.connexionDB = connexionDB;
	}

	public ConnexionDB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retourne l'instance de la BDD
	 * @return Instance de la BDD
	 */
	public Boolean initDB()
	{
		Boolean ok = true;
		if (connexionDB == null)
		{	
			connexionDB = new ConnexionDB();
			try 
			{
				//Connexion à la base de données
				connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/fcoeuret/Documents/workspace-sts-3.7.0.RELEASE/TetrisGame/BDD/Tetris.db");
				statement = connection.createStatement();
				statement.setQueryTimeout(30);
				
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				ok = false;
			}
			finally 
			{
				return ok;
			}
		}
	}

	/**
	 * Liste de tous les utilisateurs
	 * @return Une liste de tous les utilisteurs
	 */
	public ArrayList<User> listAllUser()
	{
		ArrayList<User> listUser = new ArrayList<User>();

		String rq = "SELECT * FROM UTILISATEUR LEFT JOIN UTILISATEUR.IDUTILISATEUR = ADRESSE.IDUTILISATEUR";
		try 
		{
			ResultSet res = statement.executeQuery(rq);
			int i = 0;
			while (res.next()) 
			{
				i++;
				User user = new User();
				user.setNomUtil(res.getString(2));
				user.setPrenomUtil(res.getString(3));
				user.setPseudo(res.getString(4));
				user.setEmail(res.getString(5));
				user.setPassword(res.getString(6));
				user.setSexe(res.getString(7));
				user.setFumeur(res.getString(8));
				GoogleGeoCodeResponse gcoord = new GoogleGeoCodeResponse();
				gcoord = res.getString(14);
				Adresse2D adresse = new Adresse2D(res.getString(10),res.getString(11),res.getString(12),res.getString(13),gcoord);
				user.setAddress(adresse);
				listUser.add(user);
			}
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUser;
	}
	
	
	/**
	 * Enregistre un utilisateur
	 * @param user Utilisateur
	 */
	public Boolean addUser(User user)
	{
		Boolean ok = true;
//		if (user !== null)
//		{
//			idScore = getMaxIdScore();
//		}
//		idScore++;
		//String rq = "INSERT INTO UTILISATEUR VALUES (" + idScore + ",'" + sc.getNomJoueur() + "'," + sc.getNbLigne() + "," + sc.getNiveau() + "," + sc.getScore() + "," + sc.getDateScore() + "," + idGrille + ")";
		String rqUtil = "INSERT INTO UTILISATEUR VALUES (,'" + user.getNomUtil() + "'," + user.getPrenomUtil() + "," + user.getPseudo() + "," + user.getEmail() + "," + user.getPassword() + "," + user.getSexe() + "," + user.getFumeur() + ")";
		String rqAdr = "INSERT INTO ADRESSE VALUES (,'" + user.getAddress().getAdresse1() + "'," + user.getAddress().getAdresse2() + "," + user.getAddress().getCP() + "," + user.getAddress().getVille() + "," + user.getAddress().getLocation().lat + "," + user.getAddress().getLocation().lng + "," + user.getAddress().getTypeAddress2D() + ")";
		
		try 
		{
			statement.executeUpdate(rqUtil);
			statement.executeUpdate(rqAdr);
		}
		catch (SQLException e) 
		{
			ok = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			return ok;
		}
	}
	
	public User getUSerByEmail(String email)
	{
		String rq = "SELECT * FROM UTILISATEUR LEFT JOIN UTILISATEUR.IDUTILISATEUR = ADRESSE.IDUTILISATEUR WHERE Email = " + email;
		try 
		{
			ResultSet res = statement.executeQuery(rq);
			User user = new User();
			user.setNomUtil(res.getString(2));
			user.setPrenomUtil(res.getString(3));
			user.setPseudo(res.getString(4));
			user.setEmail(res.getString(5));
			user.setPassword(res.getString(6));
			user.setSexe(res.getString(7));
			user.setFumeur(res.getString(8));
			//String gcoord = new GoogleGeoCodeResponse();
			String gcoord = res.getString(14);
			Adresse2D adresse = new Adresse2D(res.getString(10),res.getString(11),res.getString(12),res.getString(13),(GoogleGeoCodeResponse) gcoord);
			user.setAddress(adresse);
			
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	
	
}
