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
public class DemandeNouvellePE extends DemandeNouvelleTitre {
	@Column(name = "rapport_travaux_recherche")
	private Path rapportDesTravauxDeRecherche;
	
	@Column(name = "rapport_etude_faisabilite")
	private Path rapportEtudeFaisabilite;
	
	@Column(name = "arrete_approbation_eies")
	private Path arreteApprobatioinEIES;
	
	@Column(name = "plan_financement")
	private Path planDeFinancement;
	
	@Column(name = "nombre_emploi_categorie")
	private Path nombreEmploiParCategorie;
}
