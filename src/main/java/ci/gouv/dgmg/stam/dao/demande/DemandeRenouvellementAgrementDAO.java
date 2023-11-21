package ci.gouv.dgmg.stam.dao.demande;

import java.util.List;

import ci.gouv.dgmg.stam.dao.StringIndexDAO;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementAgrement;

public class DemandeRenouvellementAgrementDAO 
	extends StringIndexDAO<DemandeRenouvellementAgrement> {

	@Override
	public void create(DemandeRenouvellementAgrement t) {
		em.getTransaction().begin();
		//t.setAgent(em.merge(t.getAgent()));
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void del(DemandeRenouvellementAgrement t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DemandeRenouvellementAgrement t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DemandeRenouvellementAgrement get(String index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DemandeRenouvellementAgrement> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
