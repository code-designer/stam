package ci.gouv.dgmg.stam.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public abstract class DAO<T> {
	
	protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("stam-jpa");
	@PersistenceContext
	protected EntityManager em = emf.createEntityManager();
	
	public abstract void create(T t);
	public abstract void del(T t);
	public abstract void update(T t);
	public abstract List<T> getAll();
	
}
