package ci.gouv.dgmg.stam.models.user;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "localisations")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Localisation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String quartier;
	
	@NonNull
	private String commune;
	@NonNull
	private String ville;
	
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Agent agent;
	
	public void setAgent(Agent agent) {
		if (this.agent != null && !this.agent.equals(agent))
			this.agent.setLocalisation(null);
		
		this.agent = agent;
		
		if (agent.getLocalisation() == null || !agent.getLocalisation().equals(this))
			agent.setLocalisation(this);
	}
		
}
