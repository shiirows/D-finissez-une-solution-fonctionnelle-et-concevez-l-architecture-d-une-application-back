package projetcar.mazoyer.alexandre.projetThree.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MessageAsyncRequest {
	
	@Size(max = 5000)
	@NotNull
	private String message;

	@NotNull
	private Long user_receiver_id;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getUser_receiver_id() {
		return user_receiver_id;
	}

	public void setUser_receiver_id(Long user_receiver_id) {
		this.user_receiver_id = user_receiver_id;
	}



}
