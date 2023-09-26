package ci.gouv.dgmg.stam.common;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import ci.gouv.dgmg.stam.models.user.Contact;
import ci.gouv.dgmg.stam.models.user.Sexe;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
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

@Entity
@Table(name = "personnes")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
@EqualsAndHashCode(of = {"nom", "prenoms","contacts"})
@ToString(of = {"nom","prenoms","sexe"})
@SuperBuilder

public abstract class Personne implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
	
	@Convert(converter = PathConverter.class)
	protected Path photo;
	
	@Column(name = "created_on")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	protected LocalDateTime createdOn;
		
}
