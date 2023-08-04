package ci.gouv.dgmg.stam.dao;

import ci.gouv.dgmg.stam.dao.acte.ActeDAO;
import ci.gouv.dgmg.stam.dao.acte.AgrementDAO;
import ci.gouv.dgmg.stam.dao.acte.PermisExploitationDAO;
import ci.gouv.dgmg.stam.dao.acte.PermisRechercheDAO;
import ci.gouv.dgmg.stam.dao.acte.ProspectionDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeNouvelleAgrementDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeNouvellePEDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeNouvellePRDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeNouvelleProspectionDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeRenouvellementAgrementDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeRenouvellementPEDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeRenouvellementPRDAO;
import ci.gouv.dgmg.stam.dao.demande.DemandeRenouvellementProspectionDAO;

public class DAOFactory {
	
	public static DemandeDAO getDemandeDAO(DAOType daoType) {
		switch(daoType) {
		case DEMANDE_NOUVELLE_AGREMENT:
			return new DemandeNouvelleAgrementDAO();
		case DEMANDE_NOUVELLE_PE:
			return new DemandeNouvellePEDAO();
		case DEMANDE_NOUVELLE_PR:
			return new DemandeNouvellePRDAO();
		case DEMANDE_NOUVELLE_PROSPECTION:
			return new DemandeNouvelleProspectionDAO();
		case DEMANDE_RENOUVELLEMENT_AGREMENT:
			return new DemandeRenouvellementAgrementDAO();
		case DEMANDE_RENOUVELLEMENT_PE:
			return new DemandeRenouvellementPEDAO();
		case DEMANDE_RENOUVELLEMENT_PR:
			return new DemandeRenouvellementPRDAO();
		case DEMANDE_RENOUVELLEMENT_PROSPECTION:
			return new DemandeRenouvellementProspectionDAO();
		default:
			return null;
		}
	}
	
	public static ActeDAO getActeDAO(DAOType daoType) {
		switch(daoType) {
		case DEMANDE_NOUVELLE_AGREMENT:
			return new AgrementDAO();
		case DEMANDE_NOUVELLE_PE:
			return new PermisExploitationDAO();
		case DEMANDE_NOUVELLE_PR:
			return new PermisRechercheDAO();
		case DEMANDE_NOUVELLE_PROSPECTION:
			return new ProspectionDAO();
		default:
			return null;
		}
	}

	public enum DAOType {
		DEMANDE_NOUVELLE_AGREMENT,
		DEMANDE_NOUVELLE_PE,
		DEMANDE_NOUVELLE_PR,
		DEMANDE_NOUVELLE_PROSPECTION,
		DEMANDE_RENOUVELLEMENT_AGREMENT,
		DEMANDE_RENOUVELLEMENT_PE,
		DEMANDE_RENOUVELLEMENT_PR,
		DEMANDE_RENOUVELLEMENT_PROSPECTION,
		ACTE_NOUVEAU_AGREMENT,
		ACTE_NOUVEAU_PE,
		ACTE_NOUVEAU_PR,
		ACTE_NOUVEAU_PROSPECTION,
		ACTE_RENOUVELLEMENT_AGREMENT,
		ACTE_RENOUVELLEMENT_PE,
		ACTE_RENOUVELLEMENT_PR,
		ACTE_RENOUVELLEMENT_PROSPECTION;
	}
	
}
