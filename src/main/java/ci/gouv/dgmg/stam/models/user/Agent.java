package ci.gouv.dgmg.stam.models.user;

import ci.gouv.dgmg.stam.common.Personne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "agents")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = {"matricule"}, callSuper = true)
@ToString(of ={"matricule"}, callSuper = true)
@SuperBuilder
public class Agent extends Personne{
	
	@Column(unique = true, length = 7)
	@NonNull
	private String matricule;
	
	@Column(length = 50)
	private String fonction;
	
	@Column(length = 50)
	private String service;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "agent")
	protected Localisation localisation;
	
	@OneToOne(mappedBy="agent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Credential credentials;
	
	public void setCredentials(Credential credentials) {
		if (this.credentials != null && !this.credentials.equals(credentials))
			this.credentials.setAgent(null);
		
		this.credentials = credentials;
		
		if (credentials.getAgent() == null || !credentials.getAgent().equals(this))
			credentials.setAgent(this);
	}
	
	public void setLocalisation(Localisation localisation) {
		if (this.localisation != null && !this.localisation.equals(localisation))
			this.localisation.setAgent(null);
		
		this.localisation = localisation;
		
		if (localisation.getAgent() == null || !localisation.getAgent().equals(this))
			localisation.setAgent(this);
	}
		
}