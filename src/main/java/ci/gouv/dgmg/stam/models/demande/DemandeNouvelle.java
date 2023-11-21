package ci.gouv.dgmg.stam.models.demande;

import java.nio.file.Path;

import ci.gouv.dgmg.stam.common.PathConverter;
import ci.gouv.dgmg.stam.models.acte.Acte;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dmd_nouv")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public abstract class DemandeNouvelle extends Demande {
	@Column(name = "lettre_de_demande")
	@Convert(converter = PathConverter.class)
	protected Path lettreDeDemande;
	
	@Column(name = "numero_compte_contribuable")
	private String numeroCompteContribuable;
	
	@Convert(converter = PathConverter.class)
	protected Path rccm;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "demandeNouvelle")
	protected Acte acte;
	
	public void setActe(Acte acte) {
		if(this.acte != null && !this.acte.equals(acte)) 
			this.acte.setDemandeNouvelle(null);
		
		this.acte = acte;
		
		if (!acte.getDemandeNouvelle().equals(this))
			acte.setDemandeNouvelle(this);
	}
	
}
