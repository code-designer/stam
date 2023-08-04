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
@Table(name = "dmd_renv_pe")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DemandeRenouvellementPE extends DemandeRenouvellementTitre {
	@Column(name = "rapport_faisabilite_technique_eco")
	@Convert(converter = PathConverter.class)
	private Path rapportFaisabiliteTechEco;
	
	@Column(name = "plan_eies_actualise")
	@Convert(converter = PathConverter.class)
	private Path planEIESactualise;
}
