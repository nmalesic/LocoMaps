package com.locomaps.edd.bl.model.db;

import javax.servlet.http.HttpSession;

public class PersistanceParameter {

	//public static DataProvider datatype = DataProvider.SQLITE;

	//public static String chaineDeConnexion = "jdbc:sqlite:D:/DB/DB_LocoMaps.db";
	
	//public static String chaineDeConnexion = "jdbc:sqlite:/App/sts-bundle/pivotal-tc-server-developer-3.1.1.RELEASE/base-instance/wtpwebapps/LocoMaps/DB/DB_LocoMaps.db";
//	public static String chaineDeConnexion = "jdbc:sqlite:WebContent/DB/DB_LocoMaps.db";
//	public static String chaineDeConnexion = "jdbc:sqlite:/App/sts-bundle/pivotal-tc-server-developer-3.1.1.RELEASE/base-instance/wtpwebapps/LocoMaps/DB/DB_LocoMaps.db";
//	public static String chaineDeConnexion = "jdbc:sqlite:WebContent/DB/DB_LocoMaps.db";

	public static DataProvider datatype = DataProvider.MYSQL;

	public static String chaineDeConnexion = "jdbc:mysql://localhost:3306/locomaps";
	public static String username = "root";
	public static String password = "";
}
