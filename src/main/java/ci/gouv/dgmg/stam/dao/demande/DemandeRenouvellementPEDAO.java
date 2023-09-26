package ci.gouv.dgmg.stam.dao.demande;

import java.util.List;

import ci.gouv.dgmg.stam.dao.StringIndexDAO;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementPE;

public class DemandeRenouvellementPEDAO 
	extends StringIndexDAO<DemandeRenouvellementPE>{

	@Override
	public void create(DemandeRenouvellementPE t) {
		em.getTransaction().begin();
		t.setAgent(em.merge(t.getAgent()));
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void del(DemandeRenouvellementPE t) {
		em.getTransaction().begin();
		DemandeRenouvellementPE drpe = em.find(t.getClass(), t.getCadastreId());
		em.remove(drpe);
		em.getTransaction().commit();
		
	}

	@Override
	public void update(DemandeRenouvellementPE t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		
	}

	@Override
	public DemandeRenouvellementPE get(String index) {
		return em.find(DemandeRenouvellementPE.class, index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeRenouvellementPE> getAll() {
		return em.createQuery("from DemandeRenouvellementPE").getResultList();
	}

}
