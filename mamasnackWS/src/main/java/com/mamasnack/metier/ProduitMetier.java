package com.mamasnack.metier;

import java.util.List;

import com.mamasnack.entities.Categorie;
import com.mamasnack.entities.Cuisine;
import com.mamasnack.entities.Produit;

public interface ProduitMetier {
	// CRUD Produit
	public Long ajouterProduit(Produit p, Long IdCat) ;
	public Produit getProduit(Long idPro);
	public void supprimerProduit(Long idPro) ;
	public void modifierProduit(Produit p);
	
	// Recherche Multicritère 
	public List<Produit> listProduits();
	public List<Produit> listProduitsParCategorie(Long idCat) ;
	public List<Produit> listProduitsParCuisine(Long idCuisine) ;
	public List<Produit> listProduitsSelectionne() ;
	
	// CRUD Categorie
	public Long ajouterCategorie(Categorie c);
	public Categorie getCategorie(Long idC);
	public void supprimerCategorie(Long idCat) ;
	public void modifierCategorie(Categorie c);
	public List<Categorie> listCategories();
	
	// CRUD Cuisine
	public Long ajouterCuisine(Cuisine c);
	public Cuisine getCuisine(Long idC);
	public void supprimerCuisine(Long idCat) ;
	public void modifierCuisine(Cuisine c);
	public List<Cuisine> listCuisines();
	
	
	
	
	

}
