package test;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class JpaUtil {
	
	
	
	private static EntityManagerFactory emf = null;
	
	private static EntityManagerFactory getEntityManagerFactory() {
		if (null == emf) {
			System.out.println("Create entity manager factory...");
			emf = Persistence.createEntityManagerFactory("bibtextproj");
		}
		return emf;
	}

	public static EntityManager getEntityManager() {
		System.out.println("entering getEntityManager");
		return getEntityManagerFactory().createEntityManager();
	}
	
	public static void closeEntityManagerFactory() {
		System.out.println("Close EntityMangerFactory");
		if (null == emf) {
			return;
		}
		emf.close();
	}
}

