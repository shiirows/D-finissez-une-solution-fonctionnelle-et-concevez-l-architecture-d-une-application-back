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
@Table(name = "VEHICULES")
public class vehicules {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@NotBlank(message = "La categorie est obligatoire")
	@Size(max = 50)
	@NotNull
	private String categorie;
	
	@NotBlank(message = "La marque est obligatoire")
	@Size(max = 50)
	@NotNull
	private String marque;
	
	@NotBlank(message = "Le modele est obligatoire")
	@Size(max = 50)
	@NotNull
	private String modele;
	
	@NotBlank(message = "Le prix est obligatoire")
	@Size(max = 50)
	@NotNull
	private String prix;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}
	

}
