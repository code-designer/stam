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
@Table(name = "dmd_renv_agrmt")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DemandeRenouvellementAgrement extends DemandeRenouvellement {
	@Column(name = "type_activite")
	@Convert(converter = PathConverter.class)
	private Path typeActivite;
	
	@Column(name = "rapport_general_tech_fin")
	@Convert(converter = PathConverter.class)
	private Path rapportGeneralTechnFin;
	
	@Column(name = "copie_titre_minier")
	@Convert(converter = PathConverter.class)
	private Path copieTitreMinier;
}
