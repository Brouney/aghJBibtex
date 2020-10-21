import static org.junit.jupiter.api.Assertions.*;

import test.JpaUtil;
import test.Jpaconf;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import entities.Article;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class Testjunit {
	// private static final Logger LOG =
	// Logger.getLogger(Testjunit.class.getName());

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

	@Test
	public void utworzOsobaFizyczna() {
		System.out.println("utworzOsobaFizyczna");
		Article of = new Article();
		of.setAuthor("jan.kowalski@web.pl");
		of.setTitle("tytul ");
		System.out.println("persist");

		EntityManager em = null;

		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
		} catch (RuntimeException e) {
			System.out.println("Can't beginWorkUnitAndTransaction " + e);
		}

		em.persist(of);

		try {
			if (false == em.getTransaction().getRollbackOnly()) {
				em.getTransaction().commit();
			} else {
				em.getTransaction().rollback();
			}
		} catch (RuntimeException e) {
			System.out.println("Can't closeWotkUnitAndCommitTransaction " + e);
		} finally {
			if (null != em) {
				try {
					if (em.getTransaction().isActive()) {
						em.getTransaction().rollback();
					}
					em.close();
				} catch (RuntimeException e) {
					System.out.println("Can't close entity manager! " + e);
				}
			}
			em = null;
		}

	}

}
