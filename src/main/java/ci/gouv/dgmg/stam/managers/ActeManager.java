package ci.gouv.dgmg.stam.managers;

import java.util.List;

import ci.gouv.dgmg.stam.models.acte.Agrement;
import ci.gouv.dgmg.stam.models.acte.PermisExploitation;
import ci.gouv.dgmg.stam.models.acte.PermisRecherche;
import ci.gouv.dgmg.stam.models.acte.Prospection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ActeManager {
		//Agrement
		public void addAgrement(Agrement agrmt);
		public void delAgrement(Agrement agrmt);
		public void delAgrement(Agrement ...agrmt);
		public void updateAgrement(Agrement agmt);
		public Agrement getAgrement(String index);
		public List<Agrement> getAgrements(long start, int step, String index);
		public Agrement getAgrement(HttpServletRequest request, HttpServletResponse response);
		
		//Permis d'exploitation
		public void addPermisExploitation(PermisExploitation pe);
		public void delPermisExploitation(PermisExploitation pe);
		public void delPermisExploitation(PermisExploitation ...pe);
		public void updatePermisExploitation(PermisExploitation pe);
		public PermisExploitation getPermisExploitation(String index);
		public List<PermisExploitation> getPermisExploitation(long start, int step, String index);
		public PermisExploitation getPermisExploitation(HttpServletRequest request, HttpServletResponse response);
		
		//Permis de recherche
		public void addPermisRecherche(PermisRecherche pr);
		public void delPermisRecherche(PermisRecherche pr);
		public void delPermisRecherche(PermisRecherche ...pr);
		public void updatePermisRecherche(PermisRecherche pr);
		public PermisRecherche getPermisRecherche(String index);
		public List<PermisRecherche> getPermisRecherche(long start, int step, String index);
		public PermisRecherche getPermisRecherche(HttpServletRequest request, HttpServletResponse response);
		
		//Prospection
		public void addProspection(Prospection pr);
		public void delProspection(Prospection pr);
		public void delProspection(Prospection ...pr);
		public void updateProspection(Prospection pr);
		public Prospection getProspection(String index);
		public List<Prospection> getProspection(long start, int step, String index);
		public Prospection getProspection(HttpServletRequest request, HttpServletResponse response);
}
