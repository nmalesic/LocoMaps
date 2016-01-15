package com.locomaps.edd.bl.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.locomaps.edd.bl.Register;

public class RegisterTest {

	Register register;
	Collection<String> listTest;
	Collection<String> list2Test;
	Collection<String> listResult;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void validateEmailTest() {

		listTest = new ArrayList<String>();
		listResult = new ArrayList<String>();

		String messErr;
		String messRes;
		register = new Register();

		listTest.add("fcoeuret@segilog.com");
		listResult.add(null);
		
		listTest.add("fabrice.coeuret@bergr-levrault.com");
		listResult.add(null);
		
		listTest.add("fcoeuret12@segilog.com");
		listResult.add(null);

		listTest.add("fcoeu,/ret@segilog.com");
		listResult.add("Veuillez saisir une adresse mail valide");
		
		listTest.add("fcoe;ret@segilog.com");
		listResult.add("Veuillez saisir une adresse mail valide");
		
		listTest.add("");
		listResult.add("L'adresse mail est obligatoire");

		listTest.add(null);
		listResult.add("L'adresse mail est obligatoire");
		

		Iterator it = listTest.iterator();
		Iterator itr = listResult.iterator();
		while (it.hasNext())
		{
				messErr = register.validateEmail((String) it.next());
				messRes = (String) itr.next(); 
				assertEquals(messErr, messRes);
		}
	}

	@Test
	public void validatePwdTest() {

		listTest = new ArrayList<String>();
		list2Test = new ArrayList<String>();
		listResult = new ArrayList<String>();

		String messErr;
		String messRes;
		register = new Register();

		listTest.add("123456789");
		list2Test.add("123456789");
		listResult.add(null);
		
		listTest.add("dfzdfs452.dsf");
		list2Test.add("dfzdfs452.dsf");
		listResult.add(null);
		
		listTest.add("");
		list2Test.add("");
		listResult.add("Le mot de passe doit contenir au minimum 8 caractères");

		listTest.add(null);
		list2Test.add(null);
		listResult.add("Le mot de passe est obligatoire");

		listTest.add("123456789");
		list2Test.add(null);
		listResult.add("Les mots de passes ne sont pas identiques");

		listTest.add("123456789");
		list2Test.add("");
		listResult.add("Les mots de passes ne sont pas identiques");

		listTest.add("1234");
		list2Test.add("1234");
		listResult.add("Le mot de passe doit contenir au minimum 8 caractères");

		Iterator it1 = listTest.iterator();
		Iterator it2 = list2Test.iterator();
		Iterator itr = listResult.iterator();
		while (it1.hasNext())
		{
			//while (itr.hasNext()) 
			//{
				messErr = register.validatePwd((String) it1.next(),(String) it2.next());
				messRes = (String) itr.next(); 
				assertEquals(messErr, messRes);
			//}
		}
	}

	@Test
	public void validateTelTest() {

		listTest = new ArrayList<String>();
		listResult = new ArrayList<String>();

		String messErr;
		String messRes;
		register = new Register();

		listTest.add("0123456789");
		listResult.add(null);
		
		listTest.add("0236547896");
		listResult.add(null);
		
		listTest.add("0362412365");
		listResult.add(null);

		listTest.add("0436254796");
		listResult.add(null);

		listTest.add("0462412365");
		listResult.add(null);

		listTest.add("0562412365");
		listResult.add(null);

		listTest.add("0662412365");
		listResult.add(null);

		listTest.add("0762412365");
		listResult.add(null);

		listTest.add("0962412365");
		listResult.add(null);

		listTest.add("0962412365");
		listResult.add(null);

		listTest.add("1062412365");
		listResult.add("Veuillez saisir un numéro de téléphone valide");
		
		listTest.add("06.62.41.23.65");
		listResult.add("Veuillez saisir un numéro de téléphone valide");

		listTest.add("06-62-41-23-65");
		listResult.add("Veuillez saisir un numéro de téléphone valide");

		listTest.add("06/62/41/23/65");
		listResult.add("Veuillez saisir un numéro de téléphone valide");

		listTest.add(null);
		listResult.add(null);

		listTest.add("06-6241/23/65");
		listResult.add("Veuillez saisir un numéro de téléphone valide");
		
		Iterator it = listTest.iterator();
		Iterator itr = listResult.iterator();
		while (it.hasNext())
		{
				messErr = register.validateTel((String) it.next());
				messRes = (String) itr.next(); 
				assertEquals(messErr, messRes);
		}
	}

	@Test
	public void validateInfoTest() {
		
		listTest = new ArrayList<String>();
		list2Test = new ArrayList<String>();
		listResult = new ArrayList<String>();

		String messErr;
		String messRes;
		register = new Register();

		listTest.add("COEURET");
		list2Test.add("1");
		listResult.add(null);
		
		listTest.add("");
		list2Test.add("1");
		listResult.add("Le nom d'utilisateur est obligatoire");
		
		listTest.add(null);
		list2Test.add("1");
		listResult.add("Le nom d'utilisateur est obligatoire");

		listTest.add("Fabrice");
		list2Test.add("2");
		listResult.add(null);

		listTest.add("");
		list2Test.add("2");
		listResult.add("Le prénom est obligatoire");

		listTest.add(null);
		list2Test.add("2");
		listResult.add("Le prénom est obligatoire");

		listTest.add("fabrice.coeuret");
		list2Test.add("3");
		listResult.add(null);

		listTest.add("");
		list2Test.add("3");
		listResult.add("Le pseudo est obligatoire");

		listTest.add(null);
		list2Test.add("3");
		listResult.add("Le pseudo est obligatoire");

		listTest.add("8 rue de la paix");
		list2Test.add("4");
		listResult.add(null);

		listTest.add("");
		list2Test.add("4");
		listResult.add("L'adresse est obligatoire");

		listTest.add(null);
		list2Test.add("4");
		listResult.add("L'adresse est obligatoire");

		listTest.add("31000");
		list2Test.add("5");
		listResult.add(null);

		listTest.add("");
		list2Test.add("5");
		listResult.add("Le code postal est obligatoire");

		listTest.add(null);
		list2Test.add("5");
		listResult.add("Le code postal est obligatoire");
		
		listTest.add("Toulouse");
		list2Test.add("6");
		listResult.add(null);

		listTest.add("");
		list2Test.add("6");
		listResult.add("La ville est obligatoire");

		listTest.add(null);
		list2Test.add("6");
		listResult.add("La ville est obligatoire");

		Iterator it1 = listTest.iterator();
		Iterator it2 = list2Test.iterator();
		Iterator itr = listResult.iterator();
		int i;
		while (it1.hasNext())
		{
				messErr = register.validateInfo((String) it1.next(),Integer.parseInt((String) it2.next()));
				messRes = (String) itr.next(); 
				assertEquals(messErr, messRes);
		}
	}
	
	
}
