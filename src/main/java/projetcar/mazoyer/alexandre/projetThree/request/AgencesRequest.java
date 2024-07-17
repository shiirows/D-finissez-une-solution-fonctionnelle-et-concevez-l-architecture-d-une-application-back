package projetcar.mazoyer.alexandre.projetThree.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AgencesRequest {
	
	@Size(max = 50)
	@NotNull
	private String name;
	
	@Size(max = 100)
	@NotNull
	private String adress;
	
	@Size(max = 50)
	@NotNull
	private String city;
	
	@NotBlank(message = "Le pays est obligatoire")
	@Size(max = 50)
	@NotNull
	private String country;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
