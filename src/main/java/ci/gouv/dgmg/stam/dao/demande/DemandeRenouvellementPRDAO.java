package ci.gouv.dgmg.stam.dao.demande;

import java.util.List;

import ci.gouv.dgmg.stam.dao.StringIndexDAO;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementPR;

public class DemandeRenouvellementPRDAO 
	extends StringIndexDAO<DemandeRenouvellementPR> {

	@Override
	public void create(DemandeRenouvellementPR t) {
		em.getTransaction().begin();
		//t.setAgent(em.merge(t.getAgent()));
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void del(DemandeRenouvellementPR t) {
		em.getTransaction().begin();
		DemandeRenouvellementPR drpr = em.find(t.getClass(), t.getCadastreId());
		em.remove(drpr);
		em.getTransaction().commit();
		
	}

	@Override
	public void update(DemandeRenouvellementPR t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		
	}

	@Override
	public DemandeRenouvellementPR get(String index) {
		return em.find(DemandeRenouvellementPR.class, index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeRenouvellementPR> getAll() {
		return em.createQuery("from DemandeRenouvellementPR").getResultList();
	}

}
