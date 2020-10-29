package test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



public class Jpaconf {

private static final Logger LOG = Logger.getLogger(Jpaconf.class.getName());
	
	protected EntityManager em;

	@Before
	public void beginWorkUnitAndTransaction() {
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
		} catch (RuntimeException e) {
			System.out.println("Can't beginWorkUnitAndTransaction "+e);
		}
	}
	
	@After
	public void closeWotkUnitAndCommitTransaction() {
		try {
			if (false == em.getTransaction().getRollbackOnly()) {
				em.getTransaction().commit();
			} else {
				em.getTransaction().rollback();
			}
		} catch (RuntimeException e) {
			System.out.println("Can't closeWotkUnitAndCommitTransaction "+ e);
		} finally {
			if (null != em) {
				try {
					if (em.getTransaction().isActive()) {
						em.getTransaction().rollback();
					}
					em.close();
				} catch (RuntimeException e) {
					System.out.println("Can't close entity manager! "+ e);
				}
			}
			em = null;
		}
	}
	
	@AfterAll
	public void closeEntityManagerFactory() {
		JpaUtil.closeEntityManagerFactory();
	}

}
