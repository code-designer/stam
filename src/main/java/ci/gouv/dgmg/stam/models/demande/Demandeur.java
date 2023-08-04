package ci.gouv.dgmg.stam.models.demande;

import java.util.ArrayList;
import java.util.List;

import ci.gouv.dgmg.stam.models.acteur.Operateur;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "demandeur")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Demandeur extends Operateur{
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "demandeur", cascade = CascadeType.ALL)
	private List<Demande> demandes;
	
	public void addDemande(Demande demande) {
		if (demandes == null)
			demandes = new ArrayList<>();
		demandes.add(demande);
	}
	
	public boolean removeDemande(Demande demande) {
		if (demandes == null)
			return false;
		return demandes.remove(demande);
	}
	
	public void setDemande(Demande demande) {
		if (demandes == null)
			demandes = new ArrayList<>();
		
		if (!demandes.contains(demande)) {
			demande.setDemandeur(this);
			demandes.add(demande);
		}
	}
}
