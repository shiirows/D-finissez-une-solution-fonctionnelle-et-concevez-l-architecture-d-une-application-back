package projetcar.mazoyer.alexandre.projetThree.models;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS",
/* on contrain la table a ne poséder qu'un seul et unique pseudo et Email */
uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Le mail est obligatoire")
	@Size(max = 100)
	@Email
	@NotNull
	private String email;

	@NotBlank(message = "Le nom d'utilisateur est obligatoire")
	@Size(max = 20)
	@NotNull
	private String name;
	
	@NotBlank(message = "Le nom d'utilisateur est obligatoire")
	@Size(max = 20)
	@NotNull
	private String firstName;
	
	@NotBlank(message = "Le mot de passe est obligatoire")
	@Size(max = 120)
	@NotNull
	private String password;
	
	@NotBlank(message = "La date de naissance est obligatoire")
	@Size(max = 20)
	@NotNull
	private Date dateOfBirth;
	
	@NotBlank(message = "l'adresse est obligatoire")
	@Size(max = 50)
	@NotNull
	private String adress;
	
	@NotBlank(message = "Le code postal est obligatoire")
	@Size(max = 50)
	@NotNull
	private String countryCode;
	
	@NotBlank(message = "Le pays est obligatoire")
	@Size(max = 50)
	@NotNull
	private String country;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
