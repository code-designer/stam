package ci.gouv.dgmg.stam.model.demande;

import java.nio.file.Path;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class DemandeNouvelleProspection extends DemandeNouvelle {
	private Path cvRT;
	private Path carteZone;
	private Path programmeDePropection;
}
