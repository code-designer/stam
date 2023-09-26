package ci.gouv.dgmg.stam.models.taxation;

import java.time.LocalDate;

import ci.gouv.dgmg.stam.models.acte.PermisExploitation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@ToString
@EqualsAndHashCode
public abstract class Unite {
		
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	protected PermisExploitation permis;
	
	@Column(name = "date_transaction")
	@Temporal(TemporalType.DATE)
	protected LocalDate dateDeTransaction;
}
