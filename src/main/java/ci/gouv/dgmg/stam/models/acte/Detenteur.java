package ci.gouv.dgmg.stam.models.acte;

import java.util.ArrayList;
import java.util.List;

import ci.gouv.dgmg.stam.models.acteur.Operateur;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "detenteurs")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Detenteur extends Operateur {
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "detenteur")
	private List<Acte> actes;
	
	public void addActe(Acte acte) {
		if (actes == null)
			actes = new ArrayList<>();
		actes.add(acte);
	}
	
	public boolean removeActe(Acte acte) {
		if (actes == null)
			return false;
		return actes.remove(acte);
	}
}
