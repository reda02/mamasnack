package com.mamasnack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.mamasnack.entities.Categorie;
import com.mamasnack.entities.Cuisine;
import com.mamasnack.entities.Produit;
import com.mamasnack.metier.ProduitMetier;
@RestController
public class ProduitRestService {
	@Autowired
	private ProduitMetier produitMetier ;
	
	@RequestMapping(value="/addProduit",method=RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Long ajouterProduit(@RequestBody Produit p, Long IdCat) {
		
		return produitMetier.ajouterProduit(p, IdCat);
	}

	@RequestMapping(value="/getProduit/{idPro}",method=RequestMethod.GET)
	public Produit getProduit(@PathVariable Long idPro) {
		
		return produitMetier.getProduit(idPro);
	}

	@RequestMapping(value="/deleteProduit/{idPro}",method=RequestMethod.GET)
	public void supprimerProduit(@PathVariable Long idPro) {
		produitMetier.supprimerProduit(idPro);
		
	}

	@RequestMapping(value="/updateProduit",method=RequestMethod.POST)
	public void modifierProduit(@RequestBody Produit p) {
		produitMetier.modifierProduit(p);
	}

	@RequestMapping(value="/getProduits",method=RequestMethod.GET)
	public List<Produit> listProduits() {
		return produitMetier.listProduits();
	}
//toDo
	@RequestMapping(value="/getProduitsParCat/{idCat}",method=RequestMethod.GET)
	public List<Produit> listProduitsParCategorie(@PathVariable Long idCat) {
		
		return produitMetier.listProduitsParCategorie(idCat);
		
		
	}
	
	
	
//toDo
	@RequestMapping(value="/getProduitsParCuisine/{idCuisine}",method=RequestMethod.GET)
	public List<Produit> listProduitsParCuisine(@PathVariable Long idCuisine) {

		return produitMetier.listProduitsParCuisine(idCuisine);
	}

	@RequestMapping(value="/listProduitsSelectionne",method=RequestMethod.GET)
	public List<Produit> listProduitsSelectionne() {
	
		return produitMetier.listProduitsSelectionne();
	}

	@RequestMapping(value="/addCat",method=RequestMethod.POST)
	public Long ajouterCategorie(@RequestBody Categorie c) {
	
		return produitMetier.ajouterCategorie(c);
	}

	@RequestMapping(value="/getCat/{idC}",method=RequestMethod.GET)
    @JsonView(Produit.class)
	public Categorie getCategorie(@PathVariable Long idC) {
		
		return produitMetier.getCategorie(idC);
	}

	@RequestMapping(value="/deleteCat",method=RequestMethod.POST)
	public void supprimerCategorie(@PathVariable Long idCat) {
		produitMetier.supprimerCategorie(idCat);
		
	}

	@RequestMapping(value="/updateCat",method=RequestMethod.POST)
	public void modifierCategorie(@RequestBody Categorie c) {
		produitMetier.modifierCategorie(c);
		
	}

	@RequestMapping(value="/getCats",method=RequestMethod.GET)
	public List<Categorie> listCategories() {
		
		return produitMetier.listCategories();
	}

	@RequestMapping(value="/addCuisines",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Long ajouterCuisine(@RequestBody Cuisine c) {
	
		return produitMetier.ajouterCuisine(c);
	}

	
	// not working 
	@RequestMapping(value="/getCuisine/{idC}",method=RequestMethod.GET)
	public Cuisine getCuisine(@PathVariable Long idC) {
		
		return produitMetier.getCuisine(idC);
	}

	@RequestMapping(value="/deleteCuisine",method=RequestMethod.POST)
	public void supprimerCuisine(@PathVariable Long idCat) {
		produitMetier.supprimerCategorie(idCat);
		
	}

	@RequestMapping(value="/updateCuisine",method=RequestMethod.POST)
	public void modifierCuisine(@RequestBody Cuisine c) {
		produitMetier.modifierCuisine(c);
		
	}

	@RequestMapping(value="/getAllCuisines",method=RequestMethod.GET)
	public List<Cuisine> listCuisines() {
		return produitMetier.listCuisines();
	}

}
