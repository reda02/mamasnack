package com.mamasnack.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
public class LigneCommande   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4361472859438166128L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLigneCommande;
	private Double prix;
	private int quantite;
	
	//@JsonBackReference("produit")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idProduit")
	private Produit produit ;
	
	//@JsonBackReference("commande")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idCommande")
	private Commande commande ;
	
	public Long getIdLigneCommande() {
		return idLigneCommande;
	}
	public void setIdLigneCommande(Long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@JsonIgnore
	public Produit getProduit() {
		return produit;
	}
	@JsonSetter
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	@JsonIgnore
	public Commande getCommande() {
		return commande;
	}
	@JsonSetter
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneCommande(Double prix, int quantite, Commande commande) {
		super();
		this.prix = prix;
		this.quantite = quantite;
		this.commande = commande;
	}
	
	
}
