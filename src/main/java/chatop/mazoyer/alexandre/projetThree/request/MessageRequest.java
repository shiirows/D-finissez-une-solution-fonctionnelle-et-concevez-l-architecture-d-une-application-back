package chatop.mazoyer.alexandre.projetThree.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MessageRequest {
	
	@Size(max = 5000)
	@NotNull
	private String message;
	
	@NotNull
	private Long rental_id;
	
	@NotNull
	private Long user_id;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getRental_id() {
		return rental_id;
	}

	public void setRental_id(Long rental_id) {
		this.rental_id = rental_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	

}
