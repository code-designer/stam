package ci.gouv.dgmg.stam.model.demande;

import java.nio.file.Path;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public abstract class DemandeRenouvellement extends Demande{
	protected Path lettreDeDemandeDeRenouvellement;
}
