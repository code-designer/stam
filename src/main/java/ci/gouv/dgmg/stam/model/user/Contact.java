package ci.gouv.dgmg.stam.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"telephonePro", "emailPro"})
public class Contact {
	
	@Column(name="telephone_mob", length = 15)
	private String telephoneMob;
	
	@Column(name="telephone_pro", length = 15, unique = true)
	@NonNull
	private String telephonePro;
	
	@Column(name="email_perso")
	private String emailPerso;
	
	@Column(name="email_pro", unique = true)
	@NonNull
	private String emailPro;
	
	@Column(name="adresse_postale")
	private String adressePostale;
}
