package com.mamasnack.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Cuisine  implements Serializable{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6079773289698270780L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCuisine ;
	private String nameCuisine ;
	private String langue ;
	@OneToMany(mappedBy="categorie")
	private Collection<Produit>produit ;
	public Long getIdCuisine() {
		return idCuisine;
	}
	public void setIdCuisine(Long idCuisine) {
		this.idCuisine = idCuisine;
	}
	public String getNameCuisine() {
		return nameCuisine;
	}
	public void setNameCuisine(String nameCuisine) {
		this.nameCuisine = nameCuisine;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public Collection<Produit> getProduit() {
		return produit;
	}
	public void setProduit(Collection<Produit> produit) {
		this.produit = produit;
	}
	public Cuisine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cuisine(String nameCuisine, String langue) {
		super();
		this.nameCuisine = nameCuisine;
		this.langue = langue;
	}
	

}
