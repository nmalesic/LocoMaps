package com.locomaps.edd.bl.model.bd;

import com.locomaps.edd.bl.model.User;
import java.util.ArrayList;
import java.util.HashMap;

public interface Persistance {

	/**
	 * Lecture de tous les User en base de donn�e
	 * 
	 * @return ArrayList<User>
	 */
	public HashMap<String, User> listAllUser();

	/**
	 * Lecture de l'utilisateur � partir de son email
	 * 
	 * @param email
	 * @return
	 */
	public User getUserByEMail(String email);

	/**
	 * Ajout d'un utilisateur
	 * 
	 * @param user
	 * @return true: ok, false: ko
	 */
	public boolean addUser(User user);

	/**
	 * Modifie l'utilisateur
	 * @param user
	 * @return true: ok, false: ko
	 */
	public boolean change(User user);
	
	/**
	 * Initialisation de la base de donn�es
	 * 
	 * @return
	 */
	public boolean initDB(Object chaineDeConnexion);

}
