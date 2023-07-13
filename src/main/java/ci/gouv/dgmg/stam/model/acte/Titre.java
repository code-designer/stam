package ci.gouv.dgmg.stam.model.acte;

import ci.gouv.dgmg.stam.common.Substance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public abstract class Titre extends Acte {
	protected double superficie;
	protected String region;
	protected String localite;
	protected Substance substance;
}
