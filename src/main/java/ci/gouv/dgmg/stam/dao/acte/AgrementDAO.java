package ci.gouv.dgmg.stam.dao.acte;

import java.util.List;

import ci.gouv.dgmg.stam.dao.StringIndexDAO;
import ci.gouv.dgmg.stam.models.acte.Agrement;

public class AgrementDAO extends StringIndexDAO<Agrement> {

	@Override
	public void create(Agrement t) {
		em.getTransaction().begin();
		t.setAgent(em.merge(t.getAgent()));
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void del(Agrement t) {
		em.getTransaction().begin();
		Agrement agrmt = em.find(t.getClass(), t.getNumeroOctroi());
		em.persist(agrmt);
		em.getTransaction().commit();
		
	}

	@Override
	public void update(Agrement t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public Agrement get(String index) {
		return em.find(Agrement.class, index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agrement> getAll() {
		return em.createQuery("from Agrement").getResultList();
	}

}
