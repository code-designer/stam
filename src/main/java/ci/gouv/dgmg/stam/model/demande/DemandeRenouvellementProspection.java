package ci.gouv.dgmg.stam.model.demande;

import java.nio.file.Path;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class DemandeRenouvellementProspection extends DemandeRenouvellement {
	private Path rapportActiviteDeProspection;
	private Path programmeProspection;
	
}
