package ci.gouv.dgmg.stam.model.acteur;

import java.nio.file.Path;

import ci.gouv.dgmg.stam.common.Person;
import ci.gouv.dgmg.stam.model.acte.Detenteur;
import ci.gouv.dgmg.stam.model.demande.Demandeur;

public class PersonnePhysique extends Person implements Demandeur, Detenteur {
	private Path casierJudiciaire;
	private Path certificatResidence;
}
