package ci.gouv.dgmg.stam.model.acte;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ci.gouv.dgmg.stam.model.demande.Demande;
import ci.gouv.dgmg.stam.model.demande.DemandeRenouvellement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Acte implements Serializable {
	@Id
	protected String numeroOctroi;
	protected Detenteur detenteur;
	protected StatutActe statut;
	
	@Column(name = "numero_acte", nullable = false, unique = true)
	protected String numeroActe;
	
	@Column(name = "annee_octroi")
	@Temporal(TemporalType.DATE)
	protected LocalDate anneeOctroi;
	
	@Column(name = "annee_expiration")
	@Temporal(TemporalType.DATE)
	protected LocalDate anneeExpiration;
	
	@Column(name = "acte_numerise")
	protected Path acteNumerise;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acte_id", referencedColumnName = "cadastre_id")
	@NonNull
	protected Demande demande;
	
	protected List<DemandeRenouvellement> renouvellements;
	
	public void setDemande(Demande demande) {
		if (this.demande == null || !demande.equals(this.getDemande()))
			this.demande = demande;
		demande.setActe(this);
	}
	
	public boolean addRenouvellement(DemandeRenouvellement renouvellement) {
		if (renouvellements == null)
			renouvellements = new ArrayList<>();
		return renouvellements.add(renouvellement);
	}
	
	public boolean removeRenouvellement(DemandeRenouvellement renouvellement) {
		return renouvellements != null ? renouvellements.remove(renouvellement) : false;
	}
}
