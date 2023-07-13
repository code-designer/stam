package ci.gouv.dgmg.stam.model.acte;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Agrement extends Acte{
	private String domaine;
	private String etat;
	private String observations;
}
