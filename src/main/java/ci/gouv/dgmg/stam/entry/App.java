package ci.gouv.dgmg.stam.entry;

import java.time.LocalDate;
import java.util.List;

import org.instancio.Instancio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ci.gouv.dgmg.stam.dao.DAOFactory;
import ci.gouv.dgmg.stam.dao.DAOFactory.DAOType;
import ci.gouv.dgmg.stam.dao.demande.DemandeNouvelleProspectionDAO;
import ci.gouv.dgmg.stam.dao.user.UserDAOImpl;
import ci.gouv.dgmg.stam.models.demande.Demande;
import ci.gouv.dgmg.stam.models.demande.DemandeNouvelleProspection;
import ci.gouv.dgmg.stam.models.user.Agent;
import ci.gouv.dgmg.stam.models.user.Contact;
import ci.gouv.dgmg.stam.models.user.Credential;
import ci.gouv.dgmg.stam.models.user.Localisation;
import ci.gouv.dgmg.stam.models.user.Sexe;
import ci.gouv.dgmg.stam.models.user.UserRole;

public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	public static void main(String[] args) {
		LOGGER.info(null);
		Credential credential = new Credential();
		credential.setPassword("Ydf4gUH65S43efix");
		credential.addRole(UserRole.Manager);
		credential.addRole(UserRole.TopManager);
		credential.addRole(UserRole.Senior);
		
		Credential credential1 = new Credential();
		credential1.setPassword("n02Vsq7H5S43emz2");
		credential1.addRole(UserRole.Junior);
		credential1.addRole(UserRole.Manager);
		credential1.addRole(UserRole.Trainee);
		
		Localisation localisation = new Localisation();
		localisation.setQuartier("Lazarus");
		localisation.setCommune("Beth");
		localisation.setVille("Bethanie");
		localisation.setDescription("Village de la ressurection");
		
		Localisation localisation1 = new Localisation();
		localisation1.setQuartier("Quodesh");
		localisation1.setCommune("Salem");
		localisation1.setVille("Jerusalem");
		localisation1.setDescription("Cité de paix");
		
		Contact contact = new Contact();
		contact.setEmailPro("olivialove@kingdom.org");
		contact.setTelephonePro("+2550427290136");
		
		Contact contact1 = new Contact();
		contact1.setEmailPro("jameshappy@kingdom.org");
		contact1.setTelephonePro("+2550787450124");
		
		Agent agent = Agent.builder()
				.matricule("111000T")
				.nom("Love")
				.prenoms("Olivia")
				.dateDeNaissance(LocalDate.of(1983, 04, 13))
				.sexe(Sexe.Feminin)
				.contacts(contact)
				.build();
		agent.setCredentials(credential);
		agent.setContacts(contact);
		agent.setLocalisation(localisation);
		
		Agent agent1 = Agent.builder()
				.matricule("222333W")
				.nom("Happy")
				.prenoms("James")
				.dateDeNaissance(LocalDate.of(1982, 07, 20))
				.sexe(Sexe.Masculin)
				.contacts(contact1)
				.build();
		
		agent1.setCredentials(credential1);
		agent1.setContacts(contact1);
		agent1.setLocalisation(localisation1);
		
		UserDAOImpl um = new UserDAOImpl();
		//um.create(agent1);
		
		List<Agent> agents = um.getAll();
		
		System.out.println(agents);
		
		Demande demande = Instancio.create(DemandeNouvelleProspection.class);
		
		demande.setAgent(agents.get(0));
		demande.getDemandeur().setId(0);
		demande.getDemandeur().getEntite().setId(0);
		demande.getDemandeur().getRequerent().setId(0);
		System.out.println(demande);
		
		DemandeNouvelleProspectionDAO dd = (DemandeNouvelleProspectionDAO)DAOFactory.getDemandeDAO(DAOType.DEMANDE_NOUVELLE_PROSPECTION);
		//dd.create((DemandeNouvelleProspection)demande);
	}

}
