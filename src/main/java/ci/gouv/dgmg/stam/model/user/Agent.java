package ci.gouv.dgmg.stam.model.user;

import ci.gouv.dgmg.stam.common.Person;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = {"matricule"}, callSuper = true)
@ToString(of ={"matricule"}, callSuper = true)
@SuperBuilder
public class Agent extends Person{
	@Id
	@Column(length = 7)
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
		this.credentials = credentials;
		if (credentials.getAgent() == null || !credentials.getAgent().equals(this))
			credentials.setAgent(this);
	}
		
}