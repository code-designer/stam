package ci.gouv.dgmg.stam.managers;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import jakarta.servlet.ServletException;
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
	
	private static final Logger logger = LoggerFactory.getLogger(DemandeNouvelleManagerImpl.class);  
	
	public DemandeNouvelleManagerImpl(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	@Override
	public void addDemandeNouvelleAgrement(DemandeNouvelleAgrement agrmt) {
		logger.trace("Ajouter DemandeNouvelleAgrement");
		System.out.println("Ajouter Demande Nouvelle Agrement");
		demandeAgrementDAO.create(agrmt);
	}

	@Override
	public void delDemandeNouvelleAgrement(DemandeNouvelleAgrement agrmt) {
		logger.trace("Supprimer DemandeNouvelleAgrement");
		demandeAgrementDAO.del(agrmt);
	}

	@Override
	public void delDemandeNouvelleAgrement(DemandeNouvelleAgrement... agrmt) {
		logger.trace("Supprimer une liste de DemandeNouvelleAgrement");
		for(DemandeNouvelleAgrement demande : agrmt)
			demandeAgrementDAO.del(demande);
	}

	@Override
	public void updateDemandeNouvelleAgrement(DemandeNouvelleAgrement agmt) {
		logger.trace("Mettre à jour une DemandeNouvelleAgrement");
		demandeAgrementDAO.update(agmt);
	}

	@Override
	public DemandeNouvelleAgrement getDemandeNouvelleAgrement(String index) {
		logger.trace("Recuperer une DemandeNouvelleAgrement");
		return demandeAgrementDAO.get(index);
	}

	@Override
	public List<DemandeNouvelleAgrement> getDemandeNouvelleAgrements(long start, int step, String index) {
		logger.trace("Recuperer une liste de DemandeNouvelleAgrement");
		return demandeAgrementDAO.getAll();
	}

	@Override
	public DemandeNouvelleAgrement getDemandeNouvelleAgrement() throws IOException, ServletException {
		logger.trace("Construire une DemandeNouvelleAgrement");
		System.out.println("Construire une Demande Nouvelle Agrement");
		return buildDemandeNouvelleAgrement();
	}

	@Override
	public void addDemandeNouvellePE(DemandeNouvellePE pe) {
		logger.trace("Ajouter un Permis d'exploitation");
		demandePEDAO.create(pe);
	}

	@Override
	public void delDemandeNouvellePE(DemandeNouvellePE pe) {
		logger.trace("Supprimer un permis d'exploitation");
		demandePEDAO.del(pe);
	}

	@Override
	public void delDemandeNouvellePE(DemandeNouvellePE... pe) {
		logger.trace("Supprimer une liste de permis de d'exploitation");
		for(DemandeNouvellePE permis : pe)
			demandePEDAO.del(permis);
	}

	@Override
	public void updateDemandeNouvellePE(DemandeNouvellePE pe) {
		logger.trace("Mettre à jour un permis d'exploitation");
		demandePEDAO.update(pe);
	}

	@Override
	public DemandeNouvellePE getDemandeNouvellePE(String index) {
		logger.trace("Recuperer une DemandeNouvellePE à partir de l'index");
		return demandePEDAO.get(index);
	}

	@Override
	public List<DemandeNouvellePE> getDemandeNouvellePE(long start, int step, String index) {
		logger.trace("Recuperer une liste de DemandeNouvellePE");
		return demandePEDAO.getAll();
	}

	@Override
	public DemandeNouvellePE getDemandeNouvellePE() throws IOException, ServletException {
		logger.trace("Construire une DemandeNouvellePE");
		return buildDemandeNouvellePE();
	}

	@Override
	public void addDemandeNouvellePR(DemandeNouvellePR pr) {
		logger.trace("Ajouter une DemandeNouvellePR");
		demandePRDAO.create(pr);
	}

	@Override
	public void delDemandeNouvellePR(DemandeNouvellePR pr) {
		logger.trace("Supprimer une DemandeNouvellePR");
		demandePRDAO.del(pr);
	}

	@Override
	public void delDemandeNouvellePR(DemandeNouvellePR... pr) {
		logger.trace("Supprimer une liste de DemandeNouvellePR");
		for(DemandeNouvellePR permis : pr)
			demandePRDAO.del(permis);
	}

	@Override
	public void updateDemandeNouvellePR(DemandeNouvellePR pr) {
		logger.trace("Mettre à jour une DemandeNouvellePR");
		demandePRDAO.update(pr);
	}

	@Override
	public DemandeNouvellePR getDemandeNouvellePR(String index) {
		logger.trace("Recuperer une DemandeNouvellePR à partir de l'index");
		return demandePRDAO.get(index);
	}

	@Override
	public List<DemandeNouvellePR> getDemandeNouvellePR(long start, int step, String index) {
		logger.trace("Recuperer une liste de DemandeNouvellePR");
		return demandePRDAO.getAll();
	}

	@Override
	public DemandeNouvellePR getDemandeNouvellePR() throws IOException, ServletException {
		logger.trace("Construire une DemandeNouvellePR");
		return buildDemandeNouvellePR();
	}

	@Override
	public void addDemandeNouvelleProspection(DemandeNouvelleProspection pr) {
		logger.trace("Ajouter une DemandeNouvelleProspection");
		demandeProspection.create(pr);
	}

	@Override
	public void delDemandeNouvelleProspection(DemandeNouvelleProspection pr) {
		logger.trace("Supprimer une DemandeNouvelleProspection");
		demandeProspection.del(pr);
	}

	@Override
	public void delDemandeNouvelleProspection(DemandeNouvelleProspection... pr) {
		logger.trace("Supprimer une liste de DemandeNouvelleProspection");
		for(DemandeNouvelleProspection permis : pr)
			demandeProspection.del(permis);
	}

	@Override
	public void updateDemandeNouvelleProspection(DemandeNouvelleProspection pr) {
		logger.trace("Mettre à jour une DemandeNouvelleProspection");
		demandeProspection.update(pr);
	}

	@Override
	public DemandeNouvelleProspection getDemandeNouvelleProspection(String index) {
		logger.trace("Recuperer une DemandeNouvelleProspection à partir de l'index");
		return demandeProspection.get(index);
	}

	@Override
	public List<DemandeNouvelleProspection> getDemandeNouvelleProspection(long start, int step, String index) {
		logger.trace("Recuperer une liste de DemandeNouvelleProspection");
		return demandeProspection.getAll();
	}

	@Override
	public DemandeNouvelleProspection getDemandeNouvelleProspection() throws IOException, ServletException {
		logger.trace("Recuperer une DemandeNouvelleProspection");
		return buildDemandeNouvelleProspection();
	}

}
