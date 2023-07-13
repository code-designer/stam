package ci.gouv.dgmg.stam.model.user;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@AllArgsConstructor
@NoArgsConstructor
public final class Credential {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "matricule_agent", referencedColumnName = "matricule")
	@NonNull 
	private Agent agent;
	
	@Column(name = "password", nullable = false)
	@NonNull 
	private String password;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	@NonNull 
	private Set<UserRole> roles;
	
	public void setAgent(Agent agent) {
		this.agent = agent;
		if(agent.getCredentials() == null || !agent.getCredentials().equals(this)) 
			agent.setCredentials(this);
	}
	
	public void addRole(UserRole role) {
		if (roles == null)
			roles = new HashSet<>();
		roles.add(role);
	}
	
	public boolean removeRole(UserRole role) {
		if (roles != null)
			return roles.remove(role);
		return false;
	}
}
