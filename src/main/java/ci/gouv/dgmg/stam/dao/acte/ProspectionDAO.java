package ci.gouv.dgmg.stam.dao.acte;

import java.util.List;

import ci.gouv.dgmg.stam.dao.StringIndexDAO;
import ci.gouv.dgmg.stam.models.acte.Prospection;

public class ProspectionDAO extends StringIndexDAO<Prospection> {

	@Override
	public void create(Prospection t) {
		em.getTransaction().begin();
		t.setAgent(em.merge(t.getAgent()));
		em.persist(t);
		em.getTransaction().commit();
		
	}

	@Override
	public void del(Prospection t) {
		em.getTransaction().begin();
		Prospection pro = em.find(t.getClass(), t.getNumeroOctroi());
		em.remove(pro);
		em.getTransaction().commit();
		
	}

	@Override
	public void update(Prospection t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public Prospection get(String index) {
		return em.find(Prospection.class, index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prospection> getAll() {
		return em.createQuery("from Prospection").getResultList();
	}

}
