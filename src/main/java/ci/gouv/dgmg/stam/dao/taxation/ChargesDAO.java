package ci.gouv.dgmg.stam.dao.taxation;

import java.util.List;

import ci.gouv.dgmg.stam.dao.NumberIndexDAO;
import ci.gouv.dgmg.stam.models.taxation.UniteDeFrais;

public class ChargesDAO extends NumberIndexDAO<UniteDeFrais> {

	@Override
	public void create(UniteDeFrais t) {
		em.getTransaction().begin();
		t.setPermis(em.merge(t.getPermis()));
		em.persist(t);
		em.getTransaction().commit();	
	}

	@Override
	public void del(UniteDeFrais t) {
		em.getTransaction().begin();
		UniteDeFrais uf = em.find(t.getClass(), t.getId());
		em.remove(uf);
		em.getTransaction().commit();
	}

	@Override
	public void update(UniteDeFrais t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public UniteDeFrais get(long index) {
		return em.find(UniteDeFrais.class, index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UniteDeFrais> getAll() {
		return em.createQuery("from charges").getResultList();
	}
	
}
