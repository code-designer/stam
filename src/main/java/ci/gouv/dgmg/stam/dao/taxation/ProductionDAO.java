package ci.gouv.dgmg.stam.dao.taxation;

import java.util.List;

import ci.gouv.dgmg.stam.dao.DAO;
import ci.gouv.dgmg.stam.dao.NumberIndexDAO;
import ci.gouv.dgmg.stam.models.taxation.UniteProduction;

public class ProductionDAO extends NumberIndexDAO<UniteProduction> {

	@Override
	public UniteProduction get(long index) {
		return em.find(UniteProduction.class, index);
	}

	@Override
	public void create(UniteProduction t) {
		em.getTransaction().begin();
		t.setPermis(em.merge(t.getPermis()));
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void del(UniteProduction t) {
		em.getTransaction().begin();
		UniteProduction up = em.find(t.getClass(), t.getId());
		em.remove(up);
		em.getTransaction().commit();
	}

	@Override
	public void update(UniteProduction t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UniteProduction> getAll() {
		return em.createQuery("from UniteProduction").getResultList();
	}


}
