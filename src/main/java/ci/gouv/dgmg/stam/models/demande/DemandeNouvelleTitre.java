package ci.gouv.dgmg.stam.models.demande;

import java.nio.file.Path;
import java.time.LocalDate;

import ci.gouv.dgmg.stam.common.PathConverter;
import ci.gouv.dgmg.stam.common.Substance;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)

public class DemandeNouvelleTitre extends DemandeNouvelle {
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, 
			CascadeType.MERGE})
	protected Substance substance;
	
	@Column(name = "date_cim")
	protected LocalDate dateCIM;
	
	@Column(name = "carte_2OO_OOO")
	@Convert(converter = PathConverter.class)
	protected Path carte200000;
	
	@Column(name = "carte_a4")
	@Convert(converter = PathConverter.class)
	protected Path carteA4;
	
	@Column(name = "attestation_regularite_fiscale")
	@Convert(converter = PathConverter.class)
	protected Path attestationDeRegulariteFiscale;
	
	@Column(name = "rapport_visite")
	@Convert(converter = PathConverter.class)
	protected Path rapportVisite;
}
