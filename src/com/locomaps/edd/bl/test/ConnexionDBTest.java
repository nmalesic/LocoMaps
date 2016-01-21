package com.locomaps.edd.bl.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.locomaps.edd.bl.DB.ConnexionDB;
import com.locomaps.edd.bl.model.Adresse2D;
import com.locomaps.edd.bl.model.GoogleGeoCodeResponse;
import com.locomaps.edd.bl.model.Location;
import com.locomaps.edd.bl.model.TypeAddress;
import com.locomaps.edd.bl.model.User;
import com.locomaps.edd.bl.model.bd.Persistance;
import com.locomaps.edd.bl.model.bd.PersistanceParameter;

public class ConnexionDBTest {

	private ConnexionDB connexionDB;
	private Statement statement;
	private TypeAddress typeAdresse;
	private ArrayList<User> listUser;
	private static String cheminBase = "jdbc:sqlite:WebContent/DB/DB_LocoMaps_Test.db";


	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	/**
	 * Initialise une liste de User pour tests
	 */
	private void initListUser()
	{
		listUser = new ArrayList<User>();
		//User 1
		User user = new User();
		GoogleGeoCodeResponse gCoord = new GoogleGeoCodeResponse();
		Location location = new Location();
		user.setNomUtil("COEURET");
		user.setPrenomUtil("Fabrice");
		user.setPseudo("fcoeuret");
		user.setEmail("fcoeuret@segilog.com");
		user.setPassword("123456789");
		user.setSexe("Masculin");
		user.setFumeur("Non");
		user.setTelephone("0233455521");
		Adresse2D adresse = new Adresse2D("8 bis rue du petit midi","","72400","PREVAL",gCoord,"result");
		location.setLat("100");
		location.setLng("200");
		adresse.setLocation(location);
		user.setAddress(adresse);
		listUser.add(user);
		
		//User 2
		user = new User();
		gCoord = new GoogleGeoCodeResponse();
		location = new Location();
		user.setNomUtil("MALESIC");
		user.setPrenomUtil("Nicolas");
		user.setPseudo("nmalesic");
		user.setEmail("nicolas.malsic@berger-levrault.fr");
		user.setPassword("dff56eee4");
		user.setSexe("Masculin");
		user.setFumeur("Non");
		user.setTelephone("06.32.55.55.66");
		adresse = new Adresse2D("Rue Ampère","Près de SEGILOG","59340","FRELINGHIEN",gCoord,"result");
		location.setLat("300");
		location.setLng("2500");
		adresse.setLocation(location);
		user.setAddress(adresse);
		listUser.add(user);
		
		//User 3
		user = new User();
		gCoord = new GoogleGeoCodeResponse();
		location = new Location();
		user.setNomUtil("CHAMAYOU");
		user.setPrenomUtil("Olivier");
		user.setPseudo("olivier.chamayou");
		user.setEmail("olivier.chamayou@berger-levrault.fr");
		user.setPassword("e4t4ers_6f");
		user.setSexe("Masculin");
		user.setFumeur("Oui");
		user.setTelephone("07-54-54-54-44");
		adresse = new Adresse2D("Rue de chez lui","Dans sa maison","31000","TOULOUSE",gCoord,"result");
		location.setLat("400");
		location.setLng("700");
		adresse.setLocation(location);
		user.setAddress(adresse);
		listUser.add(user);
		
		//User 4
		user = new User();
		gCoord = new GoogleGeoCodeResponse();
		location = new Location();
		user.setNomUtil("RABOIS");
		user.setPrenomUtil("Sylvain");
		user.setPseudo("sylvain.rabois");
		user.setEmail("sylvain.rabois@berger-levrault.fr");
		user.setPassword("64ez78d");
		user.setSexe("Masculin");
		user.setFumeur("Non");
		user.setTelephone("");
		adresse = new Adresse2D("Boulevard de l'Europe","","31320","CASTANET-TOLOSAN",gCoord,"result");
		location.setLat("800");
		location.setLng("650");
		adresse.setLocation(location);
		user.setAddress(adresse);
		listUser.add(user);
		
		//User 5
		user = new User();
		gCoord = new GoogleGeoCodeResponse();
		location = new Location();
		user.setNomUtil("DECHERF");
		user.setPrenomUtil("Floriane");
		user.setPseudo("fdecherf");
		user.setEmail("fdecherf@segilog.com");
		user.setPassword("pid4dsq6");
		user.setSexe("Féminin");
		user.setFumeur("Non");
		user.setTelephone("0900000000");
		adresse = new Adresse2D("Place de l église","","72600","ST VINCENT DES PRES",gCoord,"result");
		location.setLat("1500");
		location.setLng("750");
		adresse.setLocation(location);
		user.setAddress(adresse);
		listUser.add(user);
		
	}
	
	@Test
	public void getInstanceTest() {
		
		Boolean res = true;
		connexionDB = (ConnexionDB)ConnexionDB.getInstance(cheminBase);
		assertNotNull("Connexion", connexionDB);
	}

	private void deleteBase()
	{
		connexionDB = (ConnexionDB)ConnexionDB.getInstance(cheminBase);
		assertNotNull("Connexion", connexionDB);
		if (connexionDB != null)
		{
			try 
			{
				String rqUtil = "DELETE FROM UTILISATEUR";
				connexionDB.getStatement().executeUpdate(rqUtil);
				String rqAdr = "DELETE FROM ADRESSE";
				connexionDB.getStatement().executeUpdate(rqAdr);
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally 
			{
				//return ok;
			}
		}
	}
	
	@Test
	public void addUserTest()
	{
		initListUser();
		connexionDB = (ConnexionDB)ConnexionDB.getInstance(cheminBase);
		assertNotNull("Connexion", connexionDB);
		Boolean retUser = false;
		if (connexionDB != null)
		{
			deleteBase();
			User user = new User();
			user = listUser.get(3);
			retUser = connexionDB.addUser(user);
			assertEquals(true, retUser);
			user = new User();
			user = listUser.get(4);
			retUser = connexionDB.addUser(user);
			assertEquals(true, retUser);

		}
	
	}
	
	@Test
	public void getUserByEmailTest()
	{
		initListUser();
		connexionDB = (ConnexionDB)ConnexionDB.getInstance(cheminBase);
		assertNotNull("Connexion", connexionDB);
		Boolean retUser = false;
		if (connexionDB != null)
		{
			deleteBase();
			User user = new User();
			user = listUser.get(1);
			retUser = connexionDB.addUser(user);
			User userRet = new User();
			userRet = connexionDB.getUserByEmail(user.getEmail());
			assertUser(user,userRet);
		}
	}
	
	private void assertUser(User user, User userRet)
	{
		assertEquals(user.getNomUtil(),userRet.getNomUtil());
		assertEquals(user.getPrenomUtil(),userRet.getPrenomUtil());
		assertEquals(user.getPseudo(),userRet.getPseudo());
		assertEquals(user.getEmail(),userRet.getEmail());
		assertEquals(user.getPassword(),userRet.getPassword());
		assertEquals(user.getSexe(),userRet.getSexe());
		assertEquals(user.getFumeur(),userRet.getFumeur());
		assertEquals(user.getTelephone(),userRet.getTelephone());
		assertEquals(user.getAddress().getAdresse1(),userRet.getAddress().getAdresse1());
		assertEquals(user.getAddress().getAdresse2(),userRet.getAddress().getAdresse2());
		assertEquals(user.getAddress().getCP(),userRet.getAddress().getCP());
		assertEquals(user.getAddress().getVille(),userRet.getAddress().getVille());
		assertEquals(user.getAddress().getResult(),userRet.getAddress().getResult());
		assertEquals(user.getAddress().getLocation().getLat(),userRet.getAddress().getLocation().getLat());
		assertEquals(user.getAddress().getLocation().getLng(),userRet.getAddress().getLocation().getLng());
	}
	
	@Test
	public void listAllUserTest()
	{
		HashMap<String, User> mapUser = new HashMap<String, User>();
		HashMap<String, User> mapUserRet = new HashMap<String, User>();
		User user = null;
		initListUser();
		connexionDB = (ConnexionDB)ConnexionDB.getInstance(cheminBase);
		assertNotNull("Connexion", connexionDB);
		Boolean retUser = false;
		if (connexionDB != null)
		{
			deleteBase();
			Iterator<User> it = listUser.iterator();
			while (it.hasNext())
			{
				user = new User();
				user = (User) it.next();
				mapUser.put(user.getEmail(), user);
				retUser = connexionDB.addUser(user);
			}
			
			mapUserRet = connexionDB.listAllUser();
			while (it.hasNext())
			{
				user = new User();
				assertUser(mapUser.get(user.getEmail()),mapUserRet.get(user.getEmail()));
			}
		}	
	}
	
}
