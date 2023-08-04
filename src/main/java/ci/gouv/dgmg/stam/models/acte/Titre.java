package ci.gouv.dgmg.stam.models.acte;

import ci.gouv.dgmg.stam.common.Substance;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public abstract class Titre extends Acte {
	protected double superficie;
	protected String region;
	protected String localite;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	protected Substance substance;
}
