package ci.gouv.dgmg.stam.models.acteur;

import java.nio.file.Path;

import ci.gouv.dgmg.stam.common.PathConverter;
import ci.gouv.dgmg.stam.common.Personne;
import jakarta.persistence.Column;
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
@Table(name = "requerents")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Requerent extends Personne {
	
	@Convert(converter = PathConverter.class)
	private Path casierJudiciaire;
	
	@Convert(converter = PathConverter.class)
	private Path certificatResidence;
	
	@Column(name= "nature_de_piece")
	private String natureDePiece;
	
	@Column(name="numero_piece")
	private String numeroDePiece;
	
	@Convert(converter = PathConverter.class)
	private Path pieceIdentite;
}
