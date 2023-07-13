package ci.gouv.dgmg.stam.common;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import ci.gouv.dgmg.stam.model.user.Contact;
import ci.gouv.dgmg.stam.model.user.Sexe;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
@EqualsAndHashCode(of = {"nom", "prenoms","contacts"})
@ToString(of = {"nom","prenoms","sexe"})
@SuperBuilder
public abstract class Person implements Serializable {
	
	@Column(length = 15)
	@NonNull 
	protected String nom;
	
	@Column(length = 35)
	@NonNull 
	protected String prenoms;
	
	@Enumerated(EnumType.STRING)
	@NonNull 
	protected Sexe sexe;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_de_naissance")
	@NonNull
	protected LocalDate dateDeNaissance;
	
	@Embedded
	@NonNull 
	protected Contact contacts;
	
	protected String photo;
	
	@Column(name = "created_On")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	protected LocalDateTime createdOn;
		
}
