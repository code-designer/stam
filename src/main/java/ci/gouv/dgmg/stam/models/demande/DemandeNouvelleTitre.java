package ci.gouv.dgmg.stam.models.demande;

import java.nio.file.Path;
import java.time.LocalDate;

import ci.gouv.dgmg.stam.common.PathConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DemandeNouvelleTitre extends DemandeNouvelle {
	@Column(name = "date_cim")
	protected LocalDate dateCIM;
	
	@Column(name = "carte_2OO_OOO")
	@Convert(converter = PathConverter.class)
	protected Path carte200000;
	
	@Column(name = "carte_a4")
	@Convert(converter = PathConverter.class)
	protected Path carteA4;
	
	@Column(name = "numero_compte_contribuable")
	protected String numeroCompteContribuable;
	
	@Column(name = "attestation_regularite_fiscale")
	@Convert(converter = PathConverter.class)
	protected Path attestationDeRegulariteFiscale;
	
	@Column(name = "rapport_visite")
	@Convert(converter = PathConverter.class)
	protected Path rapportVisite;
}
