package ci.gouv.dgmg.stam.managers;

import java.util.List;

import ci.gouv.dgmg.stam.dao.DAOFactory;
import ci.gouv.dgmg.stam.dao.DAOFactory.DAOType;
import ci.gouv.dgmg.stam.dao.acte.AgrementDAO;
import ci.gouv.dgmg.stam.dao.acte.PermisExploitationDAO;
import ci.gouv.dgmg.stam.dao.acte.PermisRechercheDAO;
import ci.gouv.dgmg.stam.dao.acte.ProspectionDAO;
import ci.gouv.dgmg.stam.models.acte.Agrement;
import ci.gouv.dgmg.stam.models.acte.PermisExploitation;
import ci.gouv.dgmg.stam.models.acte.PermisRecherche;
import ci.gouv.dgmg.stam.models.acte.Prospection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ActeManagerImpl extends Manager implements ActeManager {
	
	
	private final AgrementDAO agrementDAO = (AgrementDAO) DAOFactory
			.getActeDAO(DAOType.ACTE_NOUVEAU_AGREMENT);
	private final PermisExploitationDAO peDAO = (PermisExploitationDAO) DAOFactory
			.getActeDAO(DAOType.ACTE_NOUVEAU_PE);
	private final PermisRechercheDAO prDAO = (PermisRechercheDAO) DAOFactory
			.getActeDAO(DAOType.ACTE_NOUVEAU_PR);
	private final ProspectionDAO prospectionDAO = (ProspectionDAO) DAOFactory
			.getActeDAO(DAOType.ACTE_NOUVEAU_PROSPECTION);
	
	
	@Override
	public void addAgrement(Agrement agrmt) {
		agrementDAO.create(agrmt);
	}

	@Override
	public void delAgrement(Agrement agrmt) {
		agrementDAO.del(agrmt);
	}

	@Override
	public void delAgrement(Agrement... agrmt) {
		for(Agrement agr : agrmt)
			delAgrement(agr);
	}

	@Override
	public void updateAgrement(Agrement agmt) {
		agrementDAO.update(agmt);
	}

	@Override
	public Agrement getAgrement(String index) {
		return agrementDAO.get(index);
	}

	@Override
	public List<Agrement> getAgrements(long start, int step, String index) {
		
		return agrementDAO.getAll();
	}
	
	@Override
	public Agrement getAgrement(HttpServletRequest request, HttpServletResponse response) {
		return buildAgrement();
	}

	@Override
	public void addPermisExploitation(PermisExploitation pe) {
		peDAO.create(pe);
	}

	@Override
	public void delPermisExploitation(PermisExploitation pe) {
		peDAO.del(pe);
	}

	@Override
	public void delPermisExploitation(PermisExploitation... pe) {
		for (PermisExploitation p : pe)
			delPermisExploitation(p);
	}

	@Override
	public void updatePermisExploitation(PermisExploitation pe) {
		peDAO.update(pe);
	}

	@Override
	public PermisExploitation getPermisExploitation(String index) {
		return peDAO.get(index);
	}

	@Override
	public List<PermisExploitation> getPermisExploitation(long start, int step, String index) {
		return peDAO.getAll();
	}
	
	@Override
	public PermisExploitation getPermisExploitation(HttpServletRequest request, HttpServletResponse response) {
		return buildPE();
	}

	@Override
	public void addPermisRecherche(PermisRecherche pr) {
		prDAO.create(pr);
	}

	@Override
	public void delPermisRecherche(PermisRecherche pr) {
		prDAO.del(pr);
	}

	@Override
	public void delPermisRecherche(PermisRecherche... pr) {
		for (PermisRecherche p : pr)
			delPermisRecherche(p);
	}

	@Override
	public void updatePermisRecherche(PermisRecherche pr) {
		prDAO.update(pr);
	}

	@Override
	public PermisRecherche getPermisRecherche(String index) {
		return prDAO.get(index);
	}

	@Override
	public List<PermisRecherche> getPermisRecherche(long start, int step, String index) {
		return prDAO.getAll();
	}
	
	@Override
	public PermisRecherche getPermisRecherche(HttpServletRequest request, HttpServletResponse response) {
		return buildPR();
	}

	@Override
	public void addProspection(Prospection pros) {
		prospectionDAO.create(pros);
	}

	@Override
	public void delProspection(Prospection pros) {
		prospectionDAO.del(pros);
	}

	@Override
	public void delProspection(Prospection... prospec) {
		for(Prospection p : prospec)
			delProspection(p);
	}

	@Override
	public void updateProspection(Prospection pr) {
		prospectionDAO.update(pr);
	}

	@Override
	public Prospection getProspection(String index) {
		return prospectionDAO.get(index);
	}

	@Override
	public List<Prospection> getProspection(long start, int step, String index) {
		return prospectionDAO.getAll();
	}

	@Override
	public Prospection getProspection(HttpServletRequest request, HttpServletResponse response) {
		return buildProspection();
	}
	

}
