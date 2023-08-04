package ci.gouv.dgmg.stam.models.acteur;

import java.nio.file.Path;

import ci.gouv.dgmg.stam.common.Entreprise;
import ci.gouv.dgmg.stam.common.PathConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "entite")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class Entite extends Entreprise {
	@Convert(converter = PathConverter.class)
	private Path status;
}
