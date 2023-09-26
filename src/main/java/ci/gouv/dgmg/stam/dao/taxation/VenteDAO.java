package ci.gouv.dgmg.stam.dao.taxation;

import java.util.List;

import ci.gouv.dgmg.stam.dao.NumberIndexDAO;
import ci.gouv.dgmg.stam.models.taxation.UniteVente;

public class VenteDAO extends NumberIndexDAO<UniteVente> {

	@Override
	public void create(UniteVente t) {
		em.getTransaction().begin();
		t.setPermis(em.merge(t.getPermis()));
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void del(UniteVente t) {
		em.getTransaction().begin();
		UniteVente uv = em.find(t.getClass(), t.getId());
		em.remove(uv);
		em.getTransaction().commit();
	}

	@Override
	public void update(UniteVente t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public UniteVente get(long index) {
		return em.find(UniteVente.class, index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UniteVente> getAll() {
		return em.createQuery("from UniteVente").getResultList();
	}

}
