package ci.gouv.dgmg.stam.models.acteur;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Operateur implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Requerent requerent;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	protected Entite entite;
	
	public void setEntite(Entite entite) {
		this.requerent = null;
		this.entite = entite;		
	}
	
	public void setRequerent(Requerent req) {
		this.entite = null;
		this.requerent = req;
	}
}
