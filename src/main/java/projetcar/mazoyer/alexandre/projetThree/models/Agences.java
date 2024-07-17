package projetcar.mazoyer.alexandre.projetThree.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "AGENCES")
public class Agences {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@NotBlank(message = "Le nom d'utilisateur est obligatoire")
	@Size(max = 50)
	@NotNull
	private String name;
	
	@NotBlank(message = "l'adresse est obligatoire")
	@Size(max = 100)
	@NotNull
	private String adress;
	
	@NotBlank(message = "Le pays est obligatoire")
	@Size(max = 50)
	@NotNull
	private String country;
	
	@NotBlank(message = "La ville est obligatoire")
	@Size(max = 50)
	@NotNull
	private String city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
