package chatop.mazoyer.alexandre.projetThree.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RentalRequest {
	
	@NotNull
	private String name;
	
	@Size(max = 5000)
	@NotNull
	private String description;
	
	@NotNull
	private Double surface;
	
	@NotNull
	private Double price;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSurface() {
		return surface;
	}
	public void setSurface(Double surface) {
		this.surface = surface;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

}
