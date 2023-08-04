package ci.gouv.dgmg.stam.models.taxation;

import java.time.LocalDate;

import ci.gouv.dgmg.stam.models.acteur.Operateur;

public abstract class Unite {
	protected Operateur detenteur;
	protected LocalDate dateDeTransaction;
}
