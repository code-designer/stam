package ci.gouv.dgmg.stam.models.user;

public enum Sexe {
	Masculin("Masculin"),
	Feminin("Feminin"),
	Inconnu("Inconnu");
	
	private String sexe;
	
	Sexe(String sexe) {
		this.sexe = sexe;
	}
	
	public String toString() {
		return this.sexe;
	}
	
	public Sexe toSexe(String sexe) {
		for(Sexe s : values()) 
			if (s.toString().equals(sexe))
				return s;
		return Inconnu;
		
	}
}
