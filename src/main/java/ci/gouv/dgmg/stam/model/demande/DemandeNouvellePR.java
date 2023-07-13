package ci.gouv.dgmg.stam.model.demande;

import java.nio.file.Path;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class DemandeNouvellePR extends DemandeNouvelleTitre {
	@Column(name = "cv_rt")
	private Path cvRT;
	
	@Column(name = "prog_general_travaux_quatre")
	private Path programmeGeneralDesTravauxSurQuatreAns;
	
	@Column(name = "prog_detaille_premiere_annee")
	private Path programmeDetailleDeLaPremiereAnnee;
	
	@Column(name = "liste_postes_categorie")
	private Path listeDesPostesParCategorie;
	
	@Column(name = "lettre_designation_rt")
	private Path lettreDeDesignationDuRT;
	
	@Column(name = "photocopie_diplomes")
	private Path photocopieDesDiplomes;
	
	@Column(name = "experience_demandeur")
	private Path experienceDuDemandeur;
	
	@Column(name = "attestation_bancaire")
	private Path attestationBancaire;
	
	@Column(name = "releve_bancaire")
	private Path releveBancaire;
}
