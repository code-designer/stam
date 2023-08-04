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
@Table(name = "dmd_renv_pr")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DemandeRenouvellementPR extends DemandeRenouvellementTitre {
	@Column(name = "situation_carte")
	@Convert(converter = PathConverter.class)
	private Path situationDeLaCarte;
	
	@Column(name = "rapport_general_travaux_recherche")
	@Convert(converter = PathConverter.class)
	private Path rapportGeneralDesTravauxDeRecherche;
	
	@Column(name = "prog_general_detaille_des_travaux")
	@Convert(converter = PathConverter.class)
	private Path programmeGeneralEtDetailleDesTravaux;
	
	@Column(name = "droit_option")
	@Convert(converter = PathConverter.class)
	private Path droitOption;
}
