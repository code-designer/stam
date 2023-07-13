package ci.gouv.dgmg.stam.model.taxation;

import java.time.LocalDate;

import ci.gouv.dgmg.stam.model.acte.Detenteur;

public abstract class Unite {
	protected Detenteur detenteur;
	protected LocalDate dateDeTransaction;
}
