package ci.gouv.dgmg.stam.models.taxation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "charges")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString (callSuper = true)
@EqualsAndHashCode (callSuper = true)
public class UniteDeFrais extends Unite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	private double montantDesFrais;
}
