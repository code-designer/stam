package ci.gouv.dgmg.stam.models.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "credentials")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public final class Credential implements Serializable{
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	*/
	
	@Id
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "agent", referencedColumnName = "matricule")
	@NonNull 
	private Agent agent;
	
	@Column(name = "password", nullable = false)
	@NonNull 
	private String password;
	
	@ElementCollection
	@CollectionTable(name = "agent_roles",joinColumns = @JoinColumn(name="agent"))
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
