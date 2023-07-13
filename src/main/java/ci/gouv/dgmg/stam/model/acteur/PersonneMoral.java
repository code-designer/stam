package ci.gouv.dgmg.stam.model.acteur;

import java.nio.file.Path;

import ci.gouv.dgmg.stam.common.Entreprise;
import ci.gouv.dgmg.stam.model.acte.Detenteur;
import ci.gouv.dgmg.stam.model.demande.Demandeur;

public class PersonneMoral extends Entreprise implements Demandeur, Detenteur {
	private Path status;
}
