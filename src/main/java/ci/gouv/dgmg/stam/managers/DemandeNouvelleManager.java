package ci.gouv.dgmg.stam.managers;

import java.util.List;

import ci.gouv.dgmg.stam.models.acte.Agrement;
import ci.gouv.dgmg.stam.models.acte.PermisRecherche;
import ci.gouv.dgmg.stam.models.acte.Prospection;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleAgrement;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvellePE;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvellePR;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleProspection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface DemandeNouvelleManager {
	//Agrement
	public void addDemandeNouvelleAgrement(DemandeNouvelleAgrement agrmt);
	public void delDemandeNouvelleAgrement(DemandeNouvelleAgrement agrmt);
	public void delDemandeNouvelleAgrement(DemandeNouvelleAgrement ...agrmt);
	public void updateDemandeNouvelleAgrement(DemandeNouvelleAgrement agmt);
	public DemandeNouvelleAgrement getDemandeNouvelleAgrement(String index);
	public List<DemandeNouvelleAgrement> getDemandeNouvelleAgrements(long start, int step, String index);
	public DemandeNouvelleAgrement getDemandeNouvelleAgrement(HttpServletRequest request, HttpServletResponse response);
	
	//Permis d'exploitation
	public void addPermisExploitation(DemandeNouvellePE pe);
	public void delPermisExploitation(DemandeNouvellePE pe);
	public void delPermisExploitation(DemandeNouvellePE ...pe);
	public void updatePermisExploitation(DemandeNouvellePE pe);
	public DemandeNouvellePE getDemandeNouvellePE(String index);
	public List<DemandeNouvellePE> getDemandeNouvellePEs(long start, int step, String index);
	public DemandeNouvellePE getDemandeNouvellePE(HttpServletRequest request, HttpServletResponse response);
	
	//Permis de recherche
	public void addDemandeNouvellePR(DemandeNouvellePR pr);
	public void delDemandeNouvellePR(DemandeNouvellePR pr);
	public void delDemandeNouvellePR(DemandeNouvellePR ...pr);
	public void updateDemandeNouvellePR(DemandeNouvellePR pr);
	public DemandeNouvellePR getDemandeNouvellePR(String index);
	public List<DemandeNouvellePR> getDemandeNouvellePRs(long start, int step, String index);
	public DemandeNouvellePR getDemandeNouvellePR(HttpServletRequest request, HttpServletResponse response);
	
	//Prospection
	public void addDemandeNouvelleProspection(DemandeNouvelleProspection pr);
	public void delDemandeNouvelleProspection(DemandeNouvelleProspection pr);
	public void delDemandeNouvelleProspection(DemandeNouvelleProspection ...pr);
	public void updateDemandeNouvelleProspection(DemandeNouvelleProspection pr);
	public DemandeNouvelleProspection getDemandeNouvelleProspection(String index);
	public List<DemandeNouvelleProspection> getDemandeNouvelleProspection(long start, int step, String index);
	public DemandeNouvelleProspection getDemandeNouvelleProspection(HttpServletRequest request, HttpServletResponse response);
		
}
