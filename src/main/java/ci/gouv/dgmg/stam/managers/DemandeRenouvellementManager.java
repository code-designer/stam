package ci.gouv.dgmg.stam.managers;

import java.io.IOException;
import java.util.List;

import ci.gouv.dgmg.stam.models.acte.Agrement;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementAgrement;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementPE;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementPR;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellementProspection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface DemandeRenouvellementManager {
	//Agrement
	public abstract void addDemandeRenouvellementAgrement(DemandeRenouvellementAgrement agrmt);
	public abstract void delDemandeRenouvellementAgrement(DemandeRenouvellementAgrement agrmt);
	public abstract void delDemandeRenouvellementAgrement(DemandeRenouvellementAgrement ...agrmt);
	public abstract void updateDemandeRenouvellementAgrement(DemandeRenouvellementAgrement agmt);
	public abstract DemandeRenouvellementAgrement getDemandeRenouvellementAgrement(String index);
	public abstract List<DemandeRenouvellementAgrement> getDemandeRenouvellementAgrements(long start, 
			int step, String index) throws IOException, ServletException;
	public abstract DemandeRenouvellementAgrement getAgrement() throws IOException, ServletException;
	
	//Permis d'exploitation
	public abstract void addDemandeRenouvellementPE(DemandeRenouvellementPE pe);
	public abstract void delDemandeRenouvellementPE(DemandeRenouvellementPE pe);
	public abstract void delDemandeRenouvellementPE(DemandeRenouvellementPE ...pe);
	public abstract void updateDemandeRenouvellementPE(DemandeRenouvellementPE pe);
	public abstract DemandeRenouvellementPE getDemandeRenouvellementPE(String index);
	public abstract List<DemandeRenouvellementPE> getDemandeRenouvellementPE(long start, int step, 
			String index) throws IOException, ServletException;
	public abstract DemandeRenouvellementPE getDemandeRenouvellementPE() throws IOException, ServletException;
	
	//Permis de recherche
	public abstract void addDemandeRenouvellementPR(DemandeRenouvellementPR pr);
	public abstract void delDemandeRenouvellementPR(DemandeRenouvellementPR pr);
	public abstract void delDemandeRenouvellementPR(DemandeRenouvellementPR ...pr);
	public abstract void updateDemandeRenouvellementPR(DemandeRenouvellementPR pr);
	public abstract DemandeRenouvellementPR getDemandeRenouvellementPR(String index);
	public abstract List<DemandeRenouvellementPR> getDemandeRenouvellementPR(long start, int step, 
			String index) throws IOException, ServletException;
	public abstract DemandeRenouvellementPR getDemandeRenouvellementPR() throws IOException, ServletException;
	
	//Prospection
	public abstract void addDemandeRenouvellementProspection(DemandeRenouvellementProspection pr);
	public abstract void delDemandeRenouvellementProspection(DemandeRenouvellementProspection pr);
	public abstract void delDemandeRenouvellementProspection(DemandeRenouvellementProspection ...pr);
	public abstract void updateDemandeRenouvellementProspection(DemandeRenouvellementProspection pr);
	public abstract DemandeRenouvellementProspection getDemandeRenouvellementProspection(String index);
	public abstract List<DemandeRenouvellementProspection> getDemandeRenouvellementProspections(long start, 
			int step, String index) throws IOException, ServletException;
	public abstract DemandeRenouvellementProspection getDemandeRenouvellementProsptection() throws IOException, ServletException;

}
