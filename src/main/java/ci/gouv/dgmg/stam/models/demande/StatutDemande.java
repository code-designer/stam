package ci.gouv.dgmg.stam.models.demande;

public enum StatutDemande {
	EN_TRAITEMENT ("EN TRAITEMENT"),
	A_LA_CIM ("A LA CIM"),
	REFUSEE ("REFUSEE"),
	ACCEPTEE ("ACCEPTEE");
	
	private String etat;
	
	StatutDemande(String etat) {
		this.etat = etat;
	}
	
	public String toString() {
		return this.etat;
	}
	
	public static StatutDemande toStatut(String etat) {
		for (StatutDemande s: values())
			if (s.toString().equals(etat))
				return s;
		return EN_TRAITEMENT;
	}
}
