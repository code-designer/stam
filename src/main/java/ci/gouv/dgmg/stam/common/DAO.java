package ci.gouv.dgmg.stam.common;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public abstract class DAO {
	protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("stam-jpa");
	
	@PersistenceContext
	protected EntityManager em = emf.createEntityManager();
	
}
