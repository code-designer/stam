package ci.gouv.dgmg.stam.models.acte;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import ci.gouv.dgmg.stam.common.PathConverter;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelle;
import ci.gouv.dgmg.stam.models.demande.DemandeRenouvellement;
import ci.gouv.dgmg.stam.models.user.Agent;
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "acte")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public abstract class Acte implements Serializable {
	@Id
	@Column(name = "numero_octroi", length = 10)
	protected String numeroOctroi;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	protected Detenteur detenteur;
	
	@Enumerated(EnumType.STRING)
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
	@Convert(converter = PathConverter.class)
	protected Path acteNumerise;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "acte_id", referencedColumnName = "cadastre_id")
	@NonNull
	protected DemandeNouvelle demandeNouvelle;
	
	@Column(name = "created_on")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	protected LocalDateTime createdOn;
	
	@Column(name = "updated_on")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	protected LocalDateTime updatedOn;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "acte")
	protected List<DemandeRenouvellement> renouvellements;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	protected Agent agent;
	
	@Column(name = "dossier_complementaire")
	@Convert(converter = PathConverter.class)
	protected Path dossierComplementaire;
	
	public void setDemandeNouvelle(DemandeNouvelle demande) {
		if (this.demandeNouvelle != null && !demande.equals(this.getDemandeNouvelle()))
			this.demandeNouvelle.setActe(null);
		
		this.demandeNouvelle = demande;
		
		if (demande != null && !demande.getActe().equals(this))
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
