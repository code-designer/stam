package ci.gouv.dgmg.stam.managers;

import java.io.IOException;
import java.util.List;

import ci.gouv.dgmg.stam.models.acte.Agrement;
import ci.gouv.dgmg.stam.models.acte.PermisRecherche;
import ci.gouv.dgmg.stam.models.acte.Prospection;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleAgrement;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvellePE;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvellePR;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleProspection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface DemandeNouvelleManager {
	//Agrement
	public void addDemandeNouvelleAgrement(DemandeNouvelleAgrement agrmt);
	public void delDemandeNouvelleAgrement(DemandeNouvelleAgrement agrmt);
	public void delDemandeNouvelleAgrement(DemandeNouvelleAgrement ...agrmt);
	public void updateDemandeNouvelleAgrement(DemandeNouvelleAgrement agmt);
	public DemandeNouvelleAgrement getDemandeNouvelleAgrement(String index);
	public List<DemandeNouvelleAgrement> getDemandeNouvelleAgrements(long start, int step, String index)
			throws IOException, ServletException;
	public DemandeNouvelleAgrement getDemandeNouvelleAgrement() throws IOException, ServletException;
	
	//Permis d'exploitation
	public void addDemandeNouvellePE(DemandeNouvellePE pe);
	public void delDemandeNouvellePE(DemandeNouvellePE pe);
	public void delDemandeNouvellePE(DemandeNouvellePE ...pe);
	public void updateDemandeNouvellePE(DemandeNouvellePE pe);
	public DemandeNouvellePE getDemandeNouvellePE(String index);
	public List<DemandeNouvellePE> getDemandeNouvellePE(long start, int step, String index)
			throws IOException, ServletException;
	public DemandeNouvellePE getDemandeNouvellePE() throws IOException, ServletException;
	
	//Permis de recherche
	public void addDemandeNouvellePR(DemandeNouvellePR pr);
	public void delDemandeNouvellePR(DemandeNouvellePR pr);
	public void delDemandeNouvellePR(DemandeNouvellePR ...pr);
	public void updateDemandeNouvellePR(DemandeNouvellePR pr);
	public DemandeNouvellePR getDemandeNouvellePR(String index);
	public List<DemandeNouvellePR> getDemandeNouvellePR(long start, int step, String index)
			throws IOException, ServletException;
	public DemandeNouvellePR getDemandeNouvellePR() throws IOException, ServletException;
	
	//Prospection
	public void addDemandeNouvelleProspection(DemandeNouvelleProspection pr);
	public void delDemandeNouvelleProspection(DemandeNouvelleProspection pr);
	public void delDemandeNouvelleProspection(DemandeNouvelleProspection ...pr);
	public void updateDemandeNouvelleProspection(DemandeNouvelleProspection pr);
	public DemandeNouvelleProspection getDemandeNouvelleProspection(String index);
	public List<DemandeNouvelleProspection> getDemandeNouvelleProspection(long start, int step, String index)
			throws IOException, ServletException;
	public DemandeNouvelleProspection getDemandeNouvelleProspection() throws IOException, ServletException;
		
}
