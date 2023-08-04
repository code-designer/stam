package ci.gouv.dgmg.stam.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class DAO {
	
	protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("stam-jpa");
	
	protected EntityManager em = emf.createEntityManager();
	
}
