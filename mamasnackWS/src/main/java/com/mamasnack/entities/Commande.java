package com.mamasnack.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Commande  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4351232433456277747L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCommande;
	private String etatCommande;
	private Date dateCommnade;
	@OneToMany(mappedBy="commande")
	private Collection<LigneCommande> items ;
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user ;
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public String getEtatCommande() {
		return etatCommande;
	}
	public void setEtatCommande(String etatCommande) {
		this.etatCommande = etatCommande;
	}
	public Date getDateCommnade() {
		return dateCommnade;
	}
	public void setDateCommnade(Date dateCommnade) {
		this.dateCommnade = dateCommnade;
	}
	public Collection<LigneCommande> getItems() {
		return items;
	}
	public void setItems(Collection<LigneCommande> items) {
		this.items = items;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
