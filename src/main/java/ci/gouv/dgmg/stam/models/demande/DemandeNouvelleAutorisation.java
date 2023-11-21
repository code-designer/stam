package ci.gouv.dgmg.stam.models.demande;

import java.nio.file.Path;

import ci.gouv.dgmg.stam.common.PathConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)

public abstract class DemandeNouvelleAutorisation extends DemandeNouvelle {
	@Column(name = "cv_rt")
	@Convert(converter = PathConverter.class)
	protected Path cvRT;
}
