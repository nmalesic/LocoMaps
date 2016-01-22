package com.locomaps.edd.bl.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.locomaps.edd.bl.model.Adresse2D;
import com.locomaps.edd.bl.model.GoogleGeoCodeResponse;
import com.locomaps.edd.bl.model.Location;
import com.locomaps.edd.bl.model.User;
import com.locomaps.edd.bl.model.bd.Persistance;

public class ConnexionDB implements Persistance{

	//private String chaineConnection = "jdbc:sqlite:";
	private static Statement statement;
	private static Connection connection;
	private static ConnexionDB connexionDB = null;
	//private static String cheminBase = "C:/Users/fcoeuret/Documents/workspace-sts-3.7.0.RELEASE/LocoMaps/WebContent/DB/DB_LocoMaps.db";
	//private String cheminBase = "WebContent/DB/DB_LocoMaps.db";

//	public String getChaineConnection() {
//		return chaineConnection;
//	}
//
//	public void setChaineConnection(String chaineConnection) {
//		this.chaineConnection = chaineConnection;
//	}

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
	
//	public String getcheminBase() {
//		return cheminBase;
//	}
//
//	public void setcheminBase(String cheminBase) {
//		this.cheminBase = cheminBase;
//	}

	public ConnexionDB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retourne l'instance de la BDD
	 * @return Instance de la BDD
	 */
	public static Persistance getInstance(String chaineDeConnexion)
	{
		
		Boolean ok = true;
		if (connexionDB == null)
		{	
			connexionDB = new ConnexionDB();
			try 
			{
				//Connexion à la base de données
				//connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/fcoeuret/Documents/workspace-sts-3.7.0.RELEASE/TetrisGame/BDD/Tetris.db");
				Class.forName("org.sqlite.JDBC");
				connection = DriverManager.getConnection(chaineDeConnexion);
				statement = connection.createStatement();
				statement.setQueryTimeout(30);
				
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				ok = false;
				e.printStackTrace();
			}
		}
		return connexionDB;
	}

	/**
	 * Liste de tous les utilisateurs
	 * @return Une liste de tous les utilisteurs
	 */
	public HashMap<String, User> listAllUser()
	{
		HashMap<String, User> listUser = new HashMap<String, User>();

		String rq = "SELECT * FROM UTILISATEUR U LEFT JOIN ADRESSE A ON U.IDUTILISATEUR = A.IDUTILISATEUR";
		try 
		{
			ResultSet res = statement.executeQuery(rq);
			int i = 0;
			while (res.next()) 
			{
				i++;
				User user = new User();
				user = initUser(res);
//				user.setId(res.getInt(1));
//				user.setNomUtil(res.getString(2));
//				user.setPrenomUtil(res.getString(3));
//				user.setPseudo(res.getString(4));
//				user.setEmail(res.getString(5));
//				user.setPassword(res.getString(6));
//				user.setSexe(res.getString(7));
//				user.setFumeur(res.getString(8));
//				GoogleGeoCodeResponse gcoord = new GoogleGeoCodeResponse();
//				Adresse2D adresse = new Adresse2D(res.getString(10),res.getString(11),res.getString(12),res.getString(13),gcoord,res.getString(14));
//				user.setAddress(adresse);
	            listUser.put( user.getEmail(),user);
				//listUser.add(user);
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
	public boolean addUser(User user)
	{
		Boolean ok = true;
		String rqAdr = "";
		try 
		{
			String rqUtil = "INSERT INTO UTILISATEUR VALUES (" + null + ",\"" + user.getNomUtil() + "\",\"" + user.getPrenomUtil() + "\",\"" + user.getPseudo() + "\",\"" + user.getEmail() + "\",\"" + user.getPassword() + "\",\"" + user.getSexe() + "\",\"" + user.getFumeur() + "\",\"" + user.getTelephone() + "\")";
			statement.executeUpdate(rqUtil);
			int idUser = getIdUserByEmail(user.getEmail());
			if (idUser != 0)
			{
				String a = user.getAddress().getAdresse1();
				a = user.getAddress().getAdresse2();
				a = user.getAddress().getCP();
				a = user.getAddress().getVille();
				a = user.getAddress().getLocation().lat;
				a = user.getAddress().getLocation().lng;
				a = user.getAddress().getTypeAddress2D().toString();
				a = user.getAddress().getResult();
				rqAdr = "INSERT INTO ADRESSE VALUES (" + null + "," + idUser + ",\"" + user.getAddress().getAdresse1() + "\",\"" + user.getAddress().getAdresse2() + "\",\"" + user.getAddress().getCP() + "\",\"" + user.getAddress().getVille() + "\",\"" + user.getAddress().getLocation().lat + "\",\"" + user.getAddress().getLocation().lng + "\",\"" + user.getAddress().getTypeAddress2D().toString() + "\",\"" + user.getAddress().getResult() + "\")";
			}
			statement.executeUpdate(rqAdr);
		}
		catch (Exception e) 
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
	
	/**
	 * Recherche Identifiant User par son email 
	 * @param email
	 * @return idUser
	 */
	private int getIdUserByEmail(String email)
	{
		int idUser = 0;
		String rq = "SELECT UTILISATEUR.IDUTILISATEUR FROM UTILISATEUR WHERE UTILISATEUR.Email = \"" + email + "\"";
		try 
		{
			ResultSet res = statement.executeQuery(rq);
			idUser = res.getInt(1);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			return idUser;
		}
	}
	

	/**
	 * Recherche User par son email
	 * @param email
	 * @return User
	 */
	@Override
	public User getUserByEmail(String email)
	{
		User user = new User();
		String rq = "SELECT * FROM UTILISATEUR U LEFT JOIN ADRESSE A ON U.IDUTILISATEUR = A.IDUTILISATEUR WHERE U.Email = \"" + email + "\"";
		try 
		{
			ResultSet res = statement.executeQuery(rq);
			user = initUser(res);
//			user.setId(res.getInt(1));
//			user.setNomUtil(res.getString(2));
//			user.setPrenomUtil(res.getString(3));
//			user.setPseudo(res.getString(4));
//			user.setEmail(res.getString(5));
//			user.setPassword(res.getString(6));
//			user.setSexe(res.getString(7));
//			user.setFumeur(res.getString(8));
//			GoogleGeoCodeResponse gcoord = new GoogleGeoCodeResponse();
//			Adresse2D adresse = new Adresse2D(res.getString(10),res.getString(11),res.getString(12),res.getString(13),gcoord,res.getString(14));
//			user.setAddress(adresse);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			user = null;
			e.printStackTrace();
		}
		finally
		{
			return user;
		}
	}
	
	/**
	 * Renseigne User par rapport à un ResultSet d'une requête
	 * @param res (ResultSet)
	 * @return User
	 */
	private User initUser(ResultSet res)
	{
		User user = new User();
		try 
		{
			user.setId(res.getInt(1));
			user.setNomUtil(res.getString(2));
			user.setPrenomUtil(res.getString(3));
			user.setPseudo(res.getString(4));
			user.setEmail(res.getString(5));
			user.setPassword(res.getString(6));
			user.setSexe(res.getString(7));
			user.setFumeur(res.getString(8));
			user.setTelephone(res.getString(9));
			//GoogleGeoCodeResponse gcoord = new GoogleGeoCodeResponse();
			
			Location location = new Location();
			location.setLat(res.getString(16));
			location.setLng(res.getString(17));
			Adresse2D adresse = new Adresse2D(res.getString(12),res.getString(13),res.getString(14),res.getString(15),res.getString(19));
			//adresse.setLocation(location);
			user.setAddress(adresse);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			user = null;
			e.printStackTrace();
		}
		return user;
	}



	@Override
	public boolean change(User user) 
	{
		Boolean ok = true;
		String rqAdr = "";
		try 
		{
			String rqUtil = "UPDATE UTILISATEUR SET NOM = \"" + user.getNomUtil() + "\", PRENOM = \"" + user.getPrenomUtil() + "\", PSEUDO = \"" + user.getPseudo() + "\", EMAIL = \"" + user.getEmail() + "\", PASSWORD = \"" + user.getPassword() + "\", SEXE = \"" + user.getSexe() + "\", FUMEUR = \"" + user.getFumeur() + "\", TELEPHONE = \"" + user.getTelephone() + "\" WHERE IDUTILISATEUR = " + user.getId();
			statement.executeUpdate(rqUtil);
			int idUser = getIdUserByEmail(user.getEmail());
			if (idUser != 0)
			{
				rqAdr = "UPDATE ADRESSE SET ADRESSE1 = \"" + user.getAddress().getAdresse1() + "\", ADRESSE2 = \"" + user.getAddress().getAdresse2() + "\", CP = \"" + user.getAddress().getCP() + "\", VILLE = \"" + user.getAddress().getVille() + "\", LATITUDE = " + user.getAddress().getLocation().lat + ", LONGITUDE = " + user.getAddress().getLocation().lng + ",TYPEADRESSE = \"" + user.getAddress().getTypeAddress2D() + "\",GCOORD = \"" + user.getAddress().getResult() + "\" WHERE IDADRESSE = " + user.getAddress().getId();
			}
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




	

	
	
	
	
}
