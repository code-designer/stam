package ci.gouv.dgmg.stam.models.demande;

import java.nio.file.Path;

import ci.gouv.dgmg.stam.common.PathConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dmd_nouv_pe")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)

public class DemandeNouvellePE extends DemandeNouvelleTitre {
	@Column(name = "rapport_travaux_recherche")
	@Convert(converter = PathConverter.class)
	private Path rapportDesTravauxDeRecherche;
	
	@Column(name = "rapport_etude_faisabilite")
	@Convert(converter = PathConverter.class)
	private Path rapportEtudeFaisabilite;
	
	@Column(name = "arrete_approbation_eies")
	@Convert(converter = PathConverter.class)
	private Path arreteApprobatioinEIES;
	
	@Column(name = "plan_financement")
	@Convert(converter = PathConverter.class)
	private Path planDeFinancement;
	
	@Column(name = "nombre_emploi_categorie")
	@Convert(converter = PathConverter.class)
	private Path nombreEmploiParCategorie;
}
