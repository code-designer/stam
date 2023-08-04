package ci.gouv.dgmg.stam.dao.demande;

import java.util.List;

import ci.gouv.dgmg.stam.models.demande.DemandeNouvellePR;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementPE;

public class DemandeNouvellePRDAO extends DemandeDAO<DemandeNouvellePR> {

	@Override
	public void create(DemandeNouvellePR t) {
		em.getTransaction().begin();
		t.setAgent(em.merge(t.getAgent()));
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void del(DemandeNouvellePR t) {
		em.getTransaction().begin();
		DemandeNouvellePR dnpr = em.find(t.getClass(), t.getCadastreId());
		em.remove(dnpr);
		em.getTransaction().commit();
	}

	@Override
	public void update(DemandeNouvellePR t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		
	}

	@Override
	public DemandeNouvellePR get(String index) {
		return em.find(DemandeNouvellePR.class, index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeNouvellePR> getAll() {
		return em.createQuery("from DemandeNouvellePR").getResultList();
	}

}
