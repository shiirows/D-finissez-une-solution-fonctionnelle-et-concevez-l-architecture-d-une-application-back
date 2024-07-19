package projetcar.mazoyer.alexandre.projetThree.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATIONS")
public class Reservations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "vehicule_id")
	private vehicules vehicules;
	
	@ManyToOne
	@JoinColumn(name = "agence_depart_id")
	private Agences agence_depart_id;
	
	@ManyToOne
	@JoinColumn(name = "agence_retour_id")
	private Agences agence_retour_id;
	
	@Column(name = "date_debut")
	private Date date_debut;
	
	@Column(name = "date_fin")
	private Date date_fin;
	
	private boolean statut;
	
	@Column(precision = 15, scale = 2)
	private BigDecimal price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public vehicules getVehicules() {
		return vehicules;
	}

	public void setVehicules(vehicules vehicules) {
		this.vehicules = vehicules;
	}

	public Agences getAgence_depart_id() {
		return agence_depart_id;
	}

	public void setAgence_depart_id(Agences agence_depart_id) {
		this.agence_depart_id = agence_depart_id;
	}

	public Agences getAgence_retour_id() {
		return agence_retour_id;
	}

	public void setAgence_retour_id(Agences agence_retour_id) {
		this.agence_retour_id = agence_retour_id;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	} 

}
