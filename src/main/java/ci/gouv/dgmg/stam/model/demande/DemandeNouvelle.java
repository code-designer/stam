package ci.gouv.dgmg.stam.model.demande;

import java.nio.file.Path;

import ci.gouv.dgmg.stam.model.acte.Acte;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public abstract class DemandeNouvelle extends Demande {
	@Column(name = "lettre_de_demande")
	protected Path lettreDeDemande;
	
	protected Path rccm;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "demande")
	protected Acte acte;
}
