package ci.gouv.dgmg.stam.dao.demande;

import java.util.List;

import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleAgrement;

public class DemandeNouvelleAgrementDAO extends DemandeDAO<DemandeNouvelleAgrement> {

	@Override
	public void create(DemandeNouvelleAgrement t) {
		em.getTransaction().begin();
		t.setAgent(em.merge(t.getAgent()));
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void del(DemandeNouvelleAgrement t) {
		em.getTransaction().begin();
		DemandeNouvelleAgrement dna = em.find(t.getClass(), t.getCadastreId());
		em.remove(dna);
		em.getTransaction().commit();
	}

	@Override
	public void update(DemandeNouvelleAgrement t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public DemandeNouvelleAgrement get(String index) {
		return em.find(DemandeNouvelleAgrement.class, index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeNouvelleAgrement> getAll() {
		return em.createQuery("form DemandeNouvelleAgrement").getResultList();
	}

}
