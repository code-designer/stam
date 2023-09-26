package ci.gouv.dgmg.stam.models.acte;

public enum StatutActe {
	VALIDE("VALIDE"),
	EXPIRE("EXPIRE"),
	EN_RENOUVELLEMENT("EN RENOUVELLEMENT"),
	ARCHIVE("ARCHIVE");
	
	private String etat;
	
	StatutActe(String etat) {
		this.etat = etat;
	}
	
	public String toString() {
		return this.etat;
	}
	
	public static StatutActe toStatut(String etat) {
		for (StatutActe s: values())
			if (s.toString().equals(etat))
				return s;
		return ARCHIVE;
	}
}
