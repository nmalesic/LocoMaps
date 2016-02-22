package com.locomaps.edd.bl.db.mysql;

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
import com.locomaps.edd.bl.model.db.Persistance;
import com.locomaps.edd.bl.webservice.LocoAddress;
import com.locomaps.edd.bl.webservice.UserPOJO;

public class MySqlDAO implements Persistance {

	private static Statement statement;
	private static Connection connection;
	private static MySqlDAO connexionDB = null;

	public static Statement getStatement() {
		return statement;
	}

	public static void setStatement(Statement statement) {
		MySqlDAO.statement = statement;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		MySqlDAO.connection = connection;
	}

	public static MySqlDAO getConnexionDB() {
		return connexionDB;
	}

	public static void setConnexionTetris(MySqlDAO connexionDB) {
		MySqlDAO.connexionDB = connexionDB;
	}

	public MySqlDAO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retourne l'instance de la BDD
	 * 
	 * @return Instance de la BDD
	 */
	public static Persistance getInstance(String chaineDeConnexion, String username, String password) {

		Boolean ok = true;
		if (connexionDB == null) {
			connexionDB = new MySqlDAO();
			try {
				// Connexion � la base de donn�es

				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(chaineDeConnexion, username, password);
				statement = connection.createStatement();
				statement.setQueryTimeout(30);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				ok = false;
				e.printStackTrace();
			}
		}
		return connexionDB;
	}

	/**
	 * Liste de tous les utilisateurs
	 * 
	 * @return Une liste de tous les utilisteurs
	 */
	public HashMap<String, User> listAllUser() {
		HashMap<String, User> listUser = new HashMap<String, User>();

		String rq = "SELECT * FROM user U LEFT JOIN address A ON U.idUser = A.idUser";
		try {
			ResultSet res = statement.executeQuery(rq);
			int i = 0;
			while (res.next()) {
				i++;
				User user = new User();
				user = initUser(res);

				listUser.put(user.getEmail(), user);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUser;
	}

	/**
	 * Enregistre un utilisateur
	 * 
	 * @param user
	 *            Utilisateur
	 */
	public boolean addUser(User user) {
		Boolean ok = true;
		String rqAdr = "";
		try {
			// INSERT INTO user VALUES (null,"MALESIC","Nicolas","Nico","n@n.n","123456789","Féminin","Non","0123456789")
//			String rqUtil = "INSERT INTO UTILISATEUR VALUES (" + null + ",\"" + user.getNomUtil() + "\",\"" 
//					+ user.getPrenomUtil() + "\",\"" + user.getPseudo() + "\",\"" + user.getEmail() + "\",\"" 
//					+ user.getPassword() + "\",\"" + user.getSexe() + "\",\"" + user.getFumeur() + "\",\"" 
//					+ user.getTelephone() + "\")";
			String rqUtil = "INSERT INTO user VALUES (" + null + ",\"" + user.getLastName() + "\",\""
					+ user.getFirstName() + "\",\"" + user.getPseudo() + "\",\"" + user.getEmail() + "\",\""
					+ user.getPassword() + "\",\"" + user.getSex() + "\",\"" + user.getSmoker() + "\",\""
					+ user.getTelephone() + "\")";
			statement.executeUpdate(rqUtil);
			int idUser = getIdUserByEmail(user.getEmail());
			if (idUser != 0) {
				rqAdr = "INSERT INTO address VALUES (" + null + "," + idUser + ",\"" + user.getAddress().getAddress1()
						+ "\",\"" + user.getAddress().getAddress2() + "\",\"" + user.getAddress().getCodePostal() + "\",\""
						+ user.getAddress().getCity()  + "\",\""
								+ user.getAddress().getOnelineAddress() + "\",\"" + user.getAddress().getLocation().lat + "\",\""
						+ user.getAddress().getLocation().lng + "\")";
			}
			statement.executeUpdate(rqAdr);
		} catch (Exception e) {
			ok = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return ok;
		}
	}

	/**
	 * Recherche Identifiant User par son email
	 * 
	 * @param email
	 * @return idUser
	 */
	private int getIdUserByEmail(String email) {
		int idUser = 0;
		String rq = "SELECT user.idUser FROM user WHERE user.email = \"" + email + "\"";
		try {
			ResultSet res = statement.executeQuery(rq);
			res.next();
			idUser = res.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return idUser;
		}
	}

	/**
	 * Recherche User par son email
	 * 
	 * @param email
	 * @return User
	 */
	@Override
	public User getUserByEmail(String email) {
		User user = null;// new User();
		String rq = "SELECT * FROM user U LEFT JOIN address A ON U.idUser = A.idUser WHERE U.Email = \""
				+ email + "\"";
		try {
			ResultSet res = statement.executeQuery(rq);
			if (res.next()) {
				user = initUser(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			user = null;
			e.printStackTrace();
		} finally {
			return user;
		}
	}

	/**
	 * Renseigne User par rapport � un ResultSet d'une requ�te
	 * 
	 * @param res
	 *            (ResultSet)
	 * @return User
	 */
	private User initUser(ResultSet res) {
		User user = new User();
		try {
			user.setId(res.getInt(1));
			user.setLastName(res.getString(2));
			user.setFirstName(res.getString(3));
			user.setPseudo(res.getString(4));
			user.setEmail(res.getString(5));
			user.setPassword(res.getString(6));
			user.setSex(res.getString(7));
			user.setSmoker(res.getString(8));
			user.setTelephone(res.getString(9));
			// GoogleGeoCodeResponse gcoord = new GoogleGeoCodeResponse();

			Location location = new Location();
			location.setLat(res.getString(17));
			location.setLng(res.getString(18));
			LocoAddress address = new LocoAddress(res.getString(12), res.getString(13), res.getString(14),
					res.getString(15),res.getString(16),location);
					address.setId(res.getInt(10));
		   	
		   	user.setAddress(address);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			user = null;
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean change(User user) {
		Boolean ok = true;
		String rqAdr = "";
		try {
			String rqUtil = "UPDATE user SET lastName = \"" + user.getLastName() + "\", firstName = \""
					+ user.getFirstName() + "\", pseudo = \"" + user.getPseudo() + "\", email = \"" + user.getEmail()
					+ "\", password = \"" + user.getPassword() + "\", sex = \"" + user.getSex() + "\", smoker = \""
					+ user.getSmoker() + "\", telephone = \"" + user.getTelephone() + "\" WHERE idUser = "
					+ user.getId();
			statement.executeUpdate(rqUtil);
			int idUser = getIdUserByEmail(user.getEmail());
			if (idUser != 0) {
				rqAdr = "UPDATE address SET adresse1 = \"" + user.getAddress().getAddress1() + "\", adresse2 = \""
						+ user.getAddress().getAddress2() + "\", postalCode = \"" + user.getAddress().getCodePostal() + "\", city = \""
						+ user.getAddress().getCity() + "\", onelineAddress = \""
								+ user.getAddress().getOnelineAddress() + "\", latitude = \"" + user.getAddress().getLocation().lat
						+ "\", longitude = \"" + user.getAddress().getLocation().lng + "\" WHERE IDADRESSE = "
						+ user.getAddress().getId();

			}
			statement.executeUpdate(rqAdr);
		} catch (SQLException e) {
			ok = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return ok;
		}
	}

}
