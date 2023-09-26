package ci.gouv.dgmg.stam.models.taxation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ventes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString (callSuper = true)
@EqualsAndHashCode (callSuper = true)
public class UniteVente extends UniteProduction {
	@Column(name = "cours_substance")
	private double coursSubstance;
}
