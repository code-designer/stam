package ci.gouv.dgmg.stam.model.demande;

import java.nio.file.Path;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class DemandeRenouvellementPR extends DemandeRenouvellementTitre {
	private Path situationDeLaCarte;
	private Path rapportGeneralDesTravauxDeRecherche;
	private Path programmeGeneralEtDetailleDesTravaux;
	private Path droitOption;
}
