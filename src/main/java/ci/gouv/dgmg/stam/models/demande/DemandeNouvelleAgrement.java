package ci.gouv.dgmg.stam.models.demande;

import java.nio.file.Path;

import ci.gouv.dgmg.stam.common.PathConverter;
import ci.gouv.dgmg.stam.models.acteur.Requerent;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
@Table(name = "dmd_nouv_agrmt")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DemandeNouvelleAgrement extends DemandeNouvelleAutorisation {
	
	@Column(name = "type_activite")
	private String typeActivite;
	
	@Column(name = "numero_compte_contribuable")
	private String numeroCompteContribuable;
	
	@Column(name = "liste_autres_activites")
	@Convert(converter = PathConverter.class)
	private Path listeAutresActivites;
	
	@Column(name = "contrat_sous_traitance")
	@Convert(converter = PathConverter.class)
	private Path contratDeSousTraitance;
	
	@Column(name = "copie_titre_minier")
	@Convert(converter = PathConverter.class)
	private Path copietitreMinier;
	
	@Column(name = "declaration_honneur")
	@Convert(converter = PathConverter.class)
	private Path declarationSurHonneur;
	
	@Column(name = "liste_postes_categorie")
	@Convert(converter = PathConverter.class)
	private Path listeDesPostesParCategorie;
	
	@Column(name = "liste_personnel")
	@Convert(converter = PathConverter.class)
	private Path listePersonnel;
}
