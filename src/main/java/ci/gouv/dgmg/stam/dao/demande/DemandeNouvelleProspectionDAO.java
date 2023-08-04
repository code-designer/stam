package ci.gouv.dgmg.stam.dao.demande;

import java.util.List;

import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleProspection;
import ci.gouv.dgmg.stam.models.user.Agent;

public class DemandeNouvelleProspectionDAO extends DemandeDAO<DemandeNouvelleProspection> {

	@Override
	public void create(DemandeNouvelleProspection t) {
		em.getTransaction().begin();
		t.setAgent(em.merge(t.getAgent()));
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void del(DemandeNouvelleProspection t) {
		em.getTransaction().begin();
		DemandeNouvelleProspection dnp = em.find(t.getClass(), t.getCadastreId());
		em.remove(dnp);
		em.getTransaction().commit();
		
	}

	@Override
	public void update(DemandeNouvelleProspection t) {
		em.getTransaction().begin();
		em.merge(t);		
		em.getTransaction().commit();
	}

	@Override
	public DemandeNouvelleProspection get(String index) {
		return em.find(DemandeNouvelleProspection.class, index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeNouvelleProspection> getAll() {
		return em.createQuery("from DemandeNouvelleProspection").getResultList();
	}
	
}
