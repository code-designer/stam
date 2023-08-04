package ci.gouv.dgmg.stam.dao.demande;

import java.util.List;

import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementPR;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementProspection;

public class DemandeRenouvellementProspectionDAO 
	extends DemandeDAO<DemandeRenouvellementProspection> {

	@Override
	public void create(DemandeRenouvellementProspection t) {
		em.getTransaction().begin();
		t.setAgent(em.merge(t.getAgent()));
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void del(DemandeRenouvellementProspection t) {
		em.getTransaction().begin();
		DemandeRenouvellementProspection drp = em.find(t.getClass(), t.getCadastreId());
		em.remove(drp);
		em.getTransaction().commit();
		
	}

	@Override
	public void update(DemandeRenouvellementProspection t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		
	}

	@Override
	public DemandeRenouvellementProspection get(String index) {
		return em.find(DemandeRenouvellementProspection.class, index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeRenouvellementProspection> getAll() {
		return em.createQuery("from DemandeRenouvellementProspection").getResultList();
	}

}
