package com.locomaps.edd.bl.model.bd;

import com.locomaps.edd.bl.model.User;
import java.util.ArrayList;
import java.util.HashMap;

public interface Persistance {

	/**
	 * Lecture de tous les User en base de donnée
	 * 
	 * @return ArrayList<User>
	 */
	public HashMap<String, User> listAllUser();

	/**
	 * Lecture de l'utilisateur à partir de son email
	 * 
	 * @param email
	 * @return
	 */
	public User getUserByEmail(String email);

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
	


}
