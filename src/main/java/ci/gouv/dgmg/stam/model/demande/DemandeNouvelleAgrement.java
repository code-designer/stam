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
public class DemandeNouvelleAgrement extends DemandeNouvelle {
	@Column(name = "cv_rt")
	private Path cvRT; //CV responsable Technique
	
	@Column(name = "type_activite")
	private String typeActivite;
	
	@Column(name = "numero_compte_contribuable")
	private String numeroCompteContribuable;
	
	@Column(name = "liste_autres_activites")
	private Path listeAutresActivites;
	
	@Column(name = "contrat_sous_traitance")
	private Path contratDeSousTraitance;
	
	@Column(name = "copie_titre_minier")
	private Path copietitreMinier;
	
	@Column(name = "declaration_honneur")
	private Path declarationSurHonneur;
	
	private Demandeur gerant;
	
	@Column(name = "liste_postes_categorie")
	private Path listeDesPostesParCategorie;
	
	@Column(name = "liste_personnel")
	private Path listePersonnel;
}
