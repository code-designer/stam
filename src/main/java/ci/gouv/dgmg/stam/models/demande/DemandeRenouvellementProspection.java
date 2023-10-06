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
@Table(name = "dmd_renv_prospec")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DemandeRenouvellementProspection extends DemandeRenouvellement {
	@Column(name = "rapport_activite_prospection")
	@Convert(converter = PathConverter.class)
	private Path rapportActiviteDeProspection;
	
	@Column(name = "programme_prospection")
	@Convert(converter = PathConverter.class)
	private Path programmeProspection;
	
	@Column(name = "rapport_visite")
	@Convert(converter = PathConverter.class)
	protected Path rapportVisite;
	
}
