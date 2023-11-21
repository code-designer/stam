package ci.gouv.dgmg.stam.models.demande;

import java.nio.file.Path;

import ci.gouv.dgmg.stam.common.PathConverter;
import ci.gouv.dgmg.stam.common.Substance;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dmd_nouv_prospec")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)

public class DemandeNouvelleProspection extends DemandeNouvelleAutorisation {
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, 
			CascadeType.MERGE})
	protected Substance substance;
	
	@Column(name = "carte_zone")
	@Convert(converter = PathConverter.class)
	private Path carteZone;
	
	@Column(name = "prog_de_prospection")
	@Convert(converter = PathConverter.class)
	private Path programmeDePropection;
	
	@Column(name = "rapport_visite")
	@Convert(converter = PathConverter.class)
	protected Path rapportVisite;
}
