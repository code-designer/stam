package ci.gouv.dgmg.stam.models.demande;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import ci.gouv.dgmg.stam.common.PathConverter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "demandes")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode

public abstract class Demande implements Serializable {
	@Id
	@Column(name = "cadastre_id", length = 10)
	protected String cadastreId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	protected Demandeur demandeur;
	
	@Column(name = "date_soumission")
	@Temporal(TemporalType.DATE)
	protected LocalDate dateSoumission;
	
	@Column(name = "droit_fixe")
	@Convert(converter = PathConverter.class)
	protected Path droitFixe;
	
	@Column(name = "dossier_complementaire")
	@Convert(converter = PathConverter.class)
	protected Path dossierComplementaire;
	
	//@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//protected Agent agent;
	
	@Enumerated(EnumType.STRING)
	protected StatutDemande statut;
	
	@Column(name = "created_on")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	protected LocalDateTime createdOn;
	
	@Column(name = "updated_on")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	protected LocalDateTime updatedOn;
	
	
	public void setDemandeur(Demandeur demandeur) {
		if (this.demandeur != null && !this.demandeur.equals(demandeur))
			this.demandeur.getDemandes().remove(this);
		
		this.demandeur = demandeur;
		
		if (demandeur.getDemandes() == null || !demandeur.getDemandes().contains(this))
			demandeur.addDemande(this);
	}
	
	public String toString() {
		return this.cadastreId;
	}
}
