package ci.gouv.dgmg.stam.models.demande;

import java.nio.file.Path;

import ci.gouv.dgmg.stam.common.PathConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dmd_nouv_pr")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DemandeNouvellePR extends DemandeNouvelleTitre {
	@Column(name = "cv_rt")
	@Convert(converter = PathConverter.class)
	private Path cvRT;
	
	@Column(name = "prog_general_travaux_quatre")
	@Convert(converter = PathConverter.class)
	private Path programmeGeneralDesTravauxSurQuatreAns;
	
	@Column(name = "prog_detaille_premiere_annee")
	@Convert(converter = PathConverter.class)
	private Path programmeDetailleDeLaPremiereAnnee;
	
	@Column(name = "liste_postes_categorie")
	@Convert(converter = PathConverter.class)
	private Path listeDesPostesParCategorie;
	
	@Column(name = "lettre_designation_rt")
	@Convert(converter = PathConverter.class)
	private Path lettreDeDesignationDuRT;
	
	@Column(name = "photocopie_diplomes")
	@Convert(converter = PathConverter.class)
	private Path photocopieDesDiplomes;
	
	@Column(name = "experience_demandeur")
	@Convert(converter = PathConverter.class)
	private Path experienceDuDemandeur;
	
	@Column(name = "attestation_bancaire")
	@Convert(converter = PathConverter.class)
	private Path attestationBancaire;
	
	@Column(name = "releve_bancaire")
	@Convert(converter = PathConverter.class)
	private Path releveBancaire;
}
