package ci.gouv.dgmg.stam.managers;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import jakarta.servlet.ServletException;
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
	
	private static final Logger logger = LoggerFactory.getLogger(ActeManagerImpl.class);
	
	public ActeManagerImpl(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	@Override
	public void addAgrement(Agrement agrmt) {
		logger.trace("Ajouter un agrement");
		agrementDAO.create(agrmt);
	}

	@Override
	public void delAgrement(Agrement agrmt) {
		logger.trace("Supprimer un agrement");
		agrementDAO.del(agrmt);
	}

	@Override
	public void delAgrement(Agrement... agrmt) {
		logger.trace("Supprimer une liste d'agrements");
		for(Agrement agr : agrmt)
			delAgrement(agr);
	}

	@Override
	public void updateAgrement(Agrement agmt) {
		logger.trace("Mettre à jour un agrement");
		agrementDAO.update(agmt);
	}

	@Override
	public Agrement getAgrement(String index) {
		logger.trace("Recuperer un agrement à partir de l'index");
		return agrementDAO.get(index);
	}

	@Override
	public List<Agrement> getAgrements(long start, int step, String index) {
		logger.trace("Recuperer une liste d'agrement");
		return agrementDAO.getAll();
	}
	
	@Override
	public Agrement getAgrement() throws IOException, ServletException {
		logger.trace("Créer un agrement");
		return buildAgrement();
	}

	@Override
	public void addPermisExploitation(PermisExploitation pe) {
		logger.trace("Ajouter Permis d'exploitation");
		peDAO.create(pe);
	}

	@Override
	public void delPermisExploitation(PermisExploitation pe) {
		logger.trace("Supprimer Permis d'exploitation");
		peDAO.del(pe);
	}

	@Override
	public void delPermisExploitation(PermisExploitation... pe) {
		logger.trace("Supprimer liste de permis d'exploitation");
		for (PermisExploitation p : pe)
			delPermisExploitation(p);
	}

	@Override
	public void updatePermisExploitation(PermisExploitation pe) {
		logger.trace("Mettre à jour un permis d'exploitation");
		peDAO.update(pe);
	}

	@Override
	public PermisExploitation getPermisExploitation(String index) {
		logger.trace("recuperer un permis d'exploitation à partir de l'index");
		return peDAO.get(index);
	}

	@Override
	public List<PermisExploitation> getPermisExploitation(long start, int step, String index) {
		logger.trace("Recuperer une liste de permis d'exploitation");
		return peDAO.getAll();
	}
	
	@Override
	public PermisExploitation getPermisExploitation() throws IOException, ServletException {
		logger.trace("Construire un Permis d'exploitation");
		return buildPE();
	}

	@Override
	public void addPermisRecherche(PermisRecherche pr) {
		logger.trace("Ajouter un permis de recherche");
		prDAO.create(pr);
	}

	@Override
	public void delPermisRecherche(PermisRecherche pr) {
		logger.trace("Supprimer un permis de recherche");
		prDAO.del(pr);
	}

	@Override
	public void delPermisRecherche(PermisRecherche... pr) {
		logger.trace("Supprimer une liste de permis de recherche");
		for (PermisRecherche p : pr)
			delPermisRecherche(p);
	}

	@Override
	public void updatePermisRecherche(PermisRecherche pr) {
		logger.trace("Mettre à jour un permis de recherche");
		prDAO.update(pr);
	}

	@Override
	public PermisRecherche getPermisRecherche(String index) {
		logger.trace("Recuperer un permis de recherche à partir de l'index.");
		return prDAO.get(index);
	}

	@Override
	public List<PermisRecherche> getPermisRecherche(long start, int step, String index) {
		logger.trace("Recuperer une liste de permis de recherche");
		return prDAO.getAll();
	}
	
	@Override
	public PermisRecherche getPermisRecherche() throws IOException, ServletException {
		logger.trace("Construire un permis de recherche");
		return buildPR();
	}

	@Override
	public void addProspection(Prospection pros) {
		logger.trace("Ajouter une autorisation de prospection");
		prospectionDAO.create(pros);
	}

	@Override
	public void delProspection(Prospection pros) {
		logger.trace("Supprimer une autorisation de prospection");
		prospectionDAO.del(pros);
	}

	@Override
	public void delProspection(Prospection... prospec) {
		logger.trace("Supprimer une liste d'autorisationde prospection");
		for(Prospection p : prospec)
			delProspection(p);
	}

	@Override
	public void updateProspection(Prospection pr) {
		logger.trace("Mettre à jour une autorisation de prospection");
		prospectionDAO.update(pr);
	}

	@Override
	public Prospection getProspection(String index) {
		logger.trace("Recuperer une autorisation de prospection à partir de l'index");
		return prospectionDAO.get(index);
	}

	@Override
	public List<Prospection> getProspection(long start, int step, String index) {
		logger.trace("Recuperer une liste de prospection");
		return prospectionDAO.getAll();
	}

	@Override
	public Prospection getProspection() throws IOException, ServletException {
		logger.trace("Construire une autorisation de prospection");
		return buildProspection();
	}
	

}
