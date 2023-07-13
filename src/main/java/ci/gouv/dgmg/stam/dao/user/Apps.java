package ci.gouv.dgmg.stam.dao.user;

import java.time.LocalDate;
import java.util.List;

import ci.gouv.dgmg.stam.model.user.Agent;
import ci.gouv.dgmg.stam.model.user.Contact;
import ci.gouv.dgmg.stam.model.user.Credential;
import ci.gouv.dgmg.stam.model.user.Localisation;
import ci.gouv.dgmg.stam.model.user.Sexe;
import ci.gouv.dgmg.stam.model.user.UserRole;

public class Apps {

	public static void main(String[] args) {
		Credential credential = new Credential();
		credential.setPassword("Ydf4gRWoP9V7fix");
		credential.addRole(UserRole.Manager);
		credential.addRole(UserRole.TopManager);
		
		Localisation localisation = new Localisation();
		localisation.setQuartier("Quodesh");
		localisation.setCommune("Salem");
		localisation.setVille("Jerusalem");
		
		Contact contact = new Contact();
		contact.setEmailPro("jamesfaith@kingdom.org");
		contact.setTelephonePro("+2550780294136");
		
		Agent agent = Agent.builder()
				.matricule("333444W")
				.nom("Faith")
				.prenoms("James")
				.dateDeNaissance(LocalDate.of(1982, 05, 25))
				.sexe(Sexe.Masculin)
				.contacts(contact)
				.localisation(localisation)
				.credentials(credential)
				.build();
		//Agent agent2 = new Agent();
		agent.setCredentials(credential);
		//System.out.println(credential.getAgent());
		
		UserDAOImpl um = new UserDAOImpl();
		//um.createUser(agent);
		List<Agent> agents = um.getAll();
		System.out.println(agents.get(0));
		System.out.println(agents.get(0).getCredentials().getPassword());
		
	}

}
