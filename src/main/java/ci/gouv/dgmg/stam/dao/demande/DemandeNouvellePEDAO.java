package ci.gouv.dgmg.stam.dao.demande;

import java.util.List;

import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleAgrement;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvellePE;

public class DemandeNouvellePEDAO extends DemandeDAO<DemandeNouvellePE> {

	@Override
	public void create(DemandeNouvellePE t) {
		em.getTransaction().begin();
		t.setAgent(em.merge(t.getAgent()));
		em.persist(t);
		em.getTransaction().commit();
		
	}

	@Override
	public void del(DemandeNouvellePE t) {
		em.getTransaction().begin();
		DemandeNouvellePE dnpe = em.find(t.getClass(), t.getCadastreId());
		em.remove(dnpe);
		em.getTransaction().commit();
		
	}

	@Override
	public void update(DemandeNouvellePE t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		
	}

	@Override
	public DemandeNouvellePE get(String index) {
		return em.find(DemandeNouvellePE.class, index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeNouvellePE> getAll() {
		return em.createQuery("from DemandeNouvellePE").getResultList();
	}

}
