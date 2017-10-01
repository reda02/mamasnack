package com.mamasnack.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Produit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7247905930264412099L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	@NotNull
	@Size(min=1,max=4)
	private String designation;
	private String description;
	private Double prix;
	private boolean steleted;
	private String photo;
	private int quantite ;
	private Date dateAjout;
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie ;
	
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public boolean isSteleted() {
		return steleted;
	}
	public void setSteleted(boolean steleted) {
		this.steleted = steleted;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}
	public Produit(String designation, String description, Double prix, boolean steleted, String photo, int quantite,
			Date dateAjout) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.steleted = steleted;
		this.photo = photo;
		this.quantite = quantite;
		this.dateAjout = dateAjout;
	}

	
}
