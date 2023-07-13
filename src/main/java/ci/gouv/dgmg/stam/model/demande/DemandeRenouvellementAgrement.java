package ci.gouv.dgmg.stam.model.demande;

import java.nio.file.Path;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class DemandeRenouvellementAgrement extends DemandeRenouvellement {
	private Path typeActivite;
	private Path rapportGeneralTechnFin;
	private Path copieTitreMinier;
}
