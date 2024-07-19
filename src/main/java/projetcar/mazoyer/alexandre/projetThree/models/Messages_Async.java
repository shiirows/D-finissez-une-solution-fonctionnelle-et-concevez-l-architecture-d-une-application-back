package projetcar.mazoyer.alexandre.projetThree.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "MESSAGES_ASYNC")
public class Messages_Async {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_sender_id")
	private User userSender;
	
	@ManyToOne
	@JoinColumn(name = "user_receiver_id")
	private User userReceiver;

	@NotBlank(message = "Le contenu du message est obligatoire")
	@NotNull
	private String message;

	@Column(name = "created_at")
	private Date createdAt;

	@NotBlank(message = "Le statut est obligatoire")
	@NotNull
	private boolean statut;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public User getUserSender() {
		return userSender;
	}

	public void setUserSender(User userSender) {
		this.userSender = userSender;
	}

	public User getUserReceiver() {
		return userReceiver;
	}

	public void setUserReceiver(User userReceiver) {
		this.userReceiver = userReceiver;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

}
