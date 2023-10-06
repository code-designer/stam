package ci.gouv.dgmg.stam.managers;

import java.io.IOException;
import java.util.List;

import ci.gouv.dgmg.stam.dao.demande.DemandeRenouvellementAgrementDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeRenouvellementPEDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeRenouvellementPRDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeRenouvellementProspectionDAO;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementAgrement;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementPE;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementPR;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementProspection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DemandeRenouvellementManagerImpl extends Manager implements DemandeRenouvellementManager {
	
	private final DemandeRenouvellementAgrementDAO agrementDAO = 
			(DemandeRenouvellementAgrementDAO) new DemandeRenouvellementAgrementDAO();
	private final DemandeRenouvellementPEDAO peDAO = 
			(DemandeRenouvellementPEDAO) new DemandeRenouvellementPEDAO();
	private final DemandeRenouvellementPRDAO prDAO = 
			(DemandeRenouvellementPRDAO) new DemandeRenouvellementPRDAO();
	private final DemandeRenouvellementProspectionDAO prospectionDAO = 
			(DemandeRenouvellementProspectionDAO) new DemandeRenouvellementProspectionDAO();
	
	public DemandeRenouvellementManagerImpl(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	@Override
	public void addDemandeRenouvellementAgrement(DemandeRenouvellementAgrement agrmt) {
		agrementDAO.create(agrmt);
	}

	@Override
	public void delDemandeRenouvellementAgrement(DemandeRenouvellementAgrement agrmt) {
		agrementDAO.del(agrmt);
	}

	@Override
	public void delDemandeRenouvellementAgrement(DemandeRenouvellementAgrement... agrmt) {
		for(DemandeRenouvellementAgrement agr : agrmt)
			agrementDAO.del(agr);
	}

	@Override
	public void updateDemandeRenouvellementAgrement(DemandeRenouvellementAgrement agmt) {
		agrementDAO.update(agmt);
	}

	@Override
	public DemandeRenouvellementAgrement getDemandeRenouvellementAgrement(String index) {
		return agrementDAO.get(index);
	}

	@Override
	public List<DemandeRenouvellementAgrement> getDemandeRenouvellementAgrements(long start, int step, String index) {
		return agrementDAO.getAll();
	}

	@Override
	public DemandeRenouvellementAgrement getAgrement() throws IOException, ServletException {
		return buildDemandeRenouvellementAgrement();
	}

	@Override
	public void addDemandeRenouvellementPE(DemandeRenouvellementPE pe) {
		peDAO.create(pe);
	}

	@Override
	public void delDemandeRenouvellementPE(DemandeRenouvellementPE pe) {
		peDAO.del(pe);
	}

	@Override
	public void delDemandeRenouvellementPE(DemandeRenouvellementPE... pe) {
		for(DemandeRenouvellementPE permis : pe)
			peDAO.del(permis);
	}

	@Override
	public void updateDemandeRenouvellementPE(DemandeRenouvellementPE pe) {
		peDAO.update(pe);
	}

	@Override
	public DemandeRenouvellementPE getDemandeRenouvellementPE(String index) {
		return peDAO.get(index);
	}

	@Override
	public List<DemandeRenouvellementPE> getDemandeRenouvellementPE(long start, int step, String index) {
		return peDAO.getAll();
	}

	@Override
	public DemandeRenouvellementPE getDemandeRenouvellementPE() throws IOException, ServletException {
		return buildDemandeRenouvellementPE();
	}

	@Override
	public void addDemandeRenouvellementPR(DemandeRenouvellementPR pr) {
		prDAO.create(pr);
	}

	@Override
	public void delDemandeRenouvellementPR(DemandeRenouvellementPR pr) {
		prDAO.del(pr);
	}

	@Override
	public void delDemandeRenouvellementPR(DemandeRenouvellementPR... pr) {
		for(DemandeRenouvellementPR permis : pr)
			prDAO.del(permis);
	}

	@Override
	public void updateDemandeRenouvellementPR(DemandeRenouvellementPR pr) {
		prDAO.update(pr);
	}

	@Override
	public DemandeRenouvellementPR getDemandeRenouvellementPR(String index) {
		return prDAO.get(index);
	}

	@Override
	public List<DemandeRenouvellementPR> getDemandeRenouvellement(long start, int step, String index) {
		return prDAO.getAll();
	}

	@Override
	public DemandeRenouvellementPR getDemandeRenouvellementPR() throws IOException, ServletException {
		return buildDemandeRenouvellementPR();
	}

	@Override
	public void addDemandeRenouvellementProspection(DemandeRenouvellementProspection pr) {
		prospectionDAO.create(pr);
	}

	@Override
	public void delDemandeRenouvellementProspection(DemandeRenouvellementProspection pr) {
		prospectionDAO.del(pr);
	}

	@Override
	public void delDemandeRenouvellementProspection(DemandeRenouvellementProspection... pr) {
		for(DemandeRenouvellementProspection permis : pr)
			prospectionDAO.del(permis);
	}

	@Override
	public void updateDemandeRenouvellementProspection(DemandeRenouvellementProspection pr) {
		prospectionDAO.update(pr);
	}

	@Override
	public DemandeRenouvellementProspection getDemandeRenouvellementProspection(String index) {
		return prospectionDAO.get(index);
	}

	@Override
	public List<DemandeRenouvellementProspection> getDemandeRenouvellementProspections(long start, int step,
			String index) {
		return prospectionDAO.getAll();
	}

	@Override
	public DemandeRenouvellementProspection getDemandeRenouvellementProsptection() 
			throws IOException, ServletException {
		return buildDemandeRenouvellementProspection();
	}

}
