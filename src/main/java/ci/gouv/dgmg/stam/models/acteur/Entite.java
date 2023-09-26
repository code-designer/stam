package ci.gouv.dgmg.stam.models.acteur;

import java.nio.file.Path;

import ci.gouv.dgmg.stam.common.Entreprise;
import ci.gouv.dgmg.stam.common.PathConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "entites")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class Entite extends Entreprise {
	@Builder
	public Entite(long id, String raisonSociale, String gerant, Path pathStatut) {
		super(id, raisonSociale, gerant);
		this.status = pathStatut;
	}

	@Convert(converter = PathConverter.class)
	private Path status;
}
