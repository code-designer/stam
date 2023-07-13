package ci.gouv.dgmg.stam.model.demande;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.LocalDate;

import ci.gouv.dgmg.stam.model.acte.Acte;
import ci.gouv.dgmg.stam.model.user.Agent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Demande implements Serializable {
	@Id
	@Column(name = "cadastre_id")
	protected long cadastreId;
	
	protected Demandeur demandeur;
	
	@Column(name = "date_soumission")
	@Temporal(TemporalType.DATE)
	protected LocalDate dateSoumission;
	
	@Column(name = "droit_fixe")
	protected Path droitFixe;
	
	@Column(name = "dossier_complementaire")
	protected Path dossierComplementaire;
	protected Agent agent;
	
	@Enumerated(EnumType.STRING)
	protected StatutDemande statut;
	protected Acte acte;
	
	public void setActe(Acte acte) {
		if(this.acte == null || !this.acte.equals(acte))
			this.acte = acte;
		acte.setDemande(this);
	}
}
