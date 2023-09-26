package ci.gouv.dgmg.stam.managers;

import java.util.List;

import ci.gouv.dgmg.stam.dao.DAOFactory;
import ci.gouv.dgmg.stam.dao.DAOFactory.DAOType;
import ci.gouv.dgmg.stam.dao.demande.DemandeNouvelleAgrementDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeNouvellePEDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeNouvellePRDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeNouvelleProspectionDAO;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleAgrement;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvellePE;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvellePR;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleProspection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DemandeNouvelleManagerImpl extends Manager implements DemandeNouvelleManager {
	
	private final DemandeNouvelleAgrementDAO demandeAgrementDAO = 
			(DemandeNouvelleAgrementDAO)DAOFactory.getDemandeDAO(DAOType.DEMANDE_NOUVELLE_AGREMENT);
	private final DemandeNouvellePRDAO demandePRDAO = 
			(DemandeNouvellePRDAO) DAOFactory.getDemandeDAO(DAOType.DEMANDE_NOUVELLE_PR);
	private final DemandeNouvellePEDAO demandePEDAO = 
			(DemandeNouvellePEDAO) DAOFactory.getDemandeDAO(DAOType.DEMANDE_NOUVELLE_PE);
	private final DemandeNouvelleProspectionDAO demandeProspection = 
	(DemandeNouvelleProspectionDAO) DAOFactory.getDemandeDAO(DAOType.DEMANDE_NOUVELLE_PROSPECTION);
	
	@Override
	public void addDemandeNouvelleAgrement(DemandeNouvelleAgrement agrmt) {
		demandeAgrementDAO.create(agrmt);
	}

	@Override
	public void delDemandeNouvelleAgrement(DemandeNouvelleAgrement agrmt) {
		demandeAgrementDAO.del(agrmt);
	}

	@Override
	public void delDemandeNouvelleAgrement(DemandeNouvelleAgrement... agrmt) {
		for(DemandeNouvelleAgrement demande : agrmt)
			demandeAgrementDAO.del(demande);
	}

	@Override
	public void updateDemandeNouvelleAgrement(DemandeNouvelleAgrement agmt) {
		demandeAgrementDAO.update(agmt);
	}

	@Override
	public DemandeNouvelleAgrement getDemandeNouvelleAgrement(String index) {
		return demandeAgrementDAO.get(index);
	}

	@Override
	public List<DemandeNouvelleAgrement> getDemandeNouvelleAgrements(long start, int step, String index) {
		return demandeAgrementDAO.getAll();
	}

	@Override
	public DemandeNouvelleAgrement getDemandeNouvelleAgrement(HttpServletRequest request, HttpServletResponse response) {
		return buildDemandeNouvelleAgrement();
	}

	@Override
	public void addPermisExploitation(DemandeNouvellePE pe) {
		demandePEDAO.create(pe);
	}

	@Override
	public void delPermisExploitation(DemandeNouvellePE pe) {
		demandePEDAO.del(pe);
	}

	@Override
	public void delPermisExploitation(DemandeNouvellePE... pe) {
		for(DemandeNouvellePE permis : pe)
			demandePEDAO.del(permis);
	}

	@Override
	public void updatePermisExploitation(DemandeNouvellePE pe) {
		demandePEDAO.update(pe);
	}

	@Override
	public DemandeNouvellePE getDemandeNouvellePE(String index) {
		return demandePEDAO.get(index);
	}

	@Override
	public List<DemandeNouvellePE> getDemandeNouvellePEs(long start, int step, String index) {
		return demandePEDAO.getAll();
	}

	@Override
	public DemandeNouvellePE getDemandeNouvellePE(HttpServletRequest request, HttpServletResponse response) {
		return buildDemandeNouvellePE();
	}

	@Override
	public void addDemandeNouvellePR(DemandeNouvellePR pr) {
		demandePRDAO.create(pr);
	}

	@Override
	public void delDemandeNouvellePR(DemandeNouvellePR pr) {
		demandePRDAO.del(pr);
	}

	@Override
	public void delDemandeNouvellePR(DemandeNouvellePR... pr) {
		for(DemandeNouvellePR permis : pr)
			demandePRDAO.del(permis);
	}

	@Override
	public void updateDemandeNouvellePR(DemandeNouvellePR pr) {
		demandePRDAO.update(pr);
	}

	@Override
	public DemandeNouvellePR getDemandeNouvellePR(String index) {
		return demandePRDAO.get(index);
	}

	@Override
	public List<DemandeNouvellePR> getDemandeNouvellePRs(long start, int step, String index) {
		return demandePRDAO.getAll();
	}

	@Override
	public DemandeNouvellePR getDemandeNouvellePR(HttpServletRequest request, HttpServletResponse response) {
		return buildDemandeNouvellePR();
	}

	@Override
	public void addDemandeNouvelleProspection(DemandeNouvelleProspection pr) {
		demandeProspection.create(pr);
	}

	@Override
	public void delDemandeNouvelleProspection(DemandeNouvelleProspection pr) {
		demandeProspection.del(pr);
	}

	@Override
	public void delDemandeNouvelleProspection(DemandeNouvelleProspection... pr) {
		for(DemandeNouvelleProspection permis : pr)
			demandeProspection.del(permis);
	}

	@Override
	public void updateDemandeNouvelleProspection(DemandeNouvelleProspection pr) {
		demandeProspection.update(pr);
	}

	@Override
	public DemandeNouvelleProspection getDemandeNouvelleProspection(String index) {
		return demandeProspection.get(index);
	}

	@Override
	public List<DemandeNouvelleProspection> getDemandeNouvelleProspection(long start, int step, String index) {
		return demandeProspection.getAll();
	}

	@Override
	public DemandeNouvelleProspection getDemandeNouvelleProspection(HttpServletRequest request,
			HttpServletResponse response) {
		return buildDemandeNouvelleProspection();
	}

}
