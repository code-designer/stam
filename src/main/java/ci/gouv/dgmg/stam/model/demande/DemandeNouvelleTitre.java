package ci.gouv.dgmg.stam.model.demande;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class DemandeNouvelleTitre extends DemandeNouvelle {
	private LocalDate dateCIM;
}
