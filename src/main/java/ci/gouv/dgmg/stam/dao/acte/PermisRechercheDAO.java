package ci.gouv.dgmg.stam.dao.acte;

import java.util.List;

import ci.gouv.dgmg.stam.dao.StringIndexDAO;
import ci.gouv.dgmg.stam.models.acte.PermisRecherche;

public class PermisRechercheDAO extends StringIndexDAO<PermisRecherche> {

	@Override
	public void create(PermisRecherche t) {
		em.getTransaction().begin();
		t.setAgent(em.merge(t.getAgent()));
		em.persist(t);
		em.getTransaction().commit();
		
	}

	@Override
	public void del(PermisRecherche t) {
		em.getTransaction().begin();
		PermisRecherche pro = em.find(t.getClass(), t.getNumeroOctroi());
		em.remove(pro);
		em.getTransaction().commit();
	}

	@Override
	public void update(PermisRecherche t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public PermisRecherche get(String index) {
		return em.find(PermisRecherche.class, index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PermisRecherche> getAll() {
		return em.createQuery("from PermisRecherche").getResultList();
	}

}
