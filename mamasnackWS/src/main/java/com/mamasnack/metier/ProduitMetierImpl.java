package com.mamasnack.metier;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mamasnack.dao.CategorieRepository;
import com.mamasnack.dao.CuisineRepository;
import com.mamasnack.dao.ProduitRepository;
import com.mamasnack.entities.Categorie;
import com.mamasnack.entities.Cuisine;
import com.mamasnack.entities.Produit;

@Service
public class ProduitMetierImpl implements ProduitMetier {

	
	@Autowired
	private ProduitRepository produitRepository ;
	@Autowired
	private CategorieRepository categorieRepository ;
	@Autowired
	private CuisineRepository cuisineRepository ;
	
	@Override
	public Long ajouterProduit(Produit p, Long IdCat) {
		
	
		produitRepository.save(p);
		return p.getIdProduit();
	}
	@Override
	public List<Produit> produitsParMotCle(String mc) {
		
		return produitRepository.findproduitParMotCle( mc);
	}

	@Override
	public Produit getProduit(Long idPro) {
		
		Produit produit= produitRepository.findOne(idPro) ;
		//if (produit==null)throw new RuntimeException("produit inexistant !");
		return produit;
	}

	@Override
	public void supprimerProduit(Long idPro) {
		produitRepository.deleteById(idPro);	
	}

	@Override
	public void modifierProduit(Produit p) {
		if (p.getIdProduit() != null && !produitRepository.existsById(p.getIdProduit())) {
			throw new EntityExistsException("There isn't already existing entity with such ID in the database.");
		}
		produitRepository.save(p);
		
	}

	@Override
	public List<Produit> listProduits() {
		
		return produitRepository.findAll();
	}

	@Override
	public List<Produit> listProduitsParCategorie(Long idCat) {
		
		return produitRepository.findProduitsParCategorie(idCat);
	}

	@Override
	public List<Produit> listProduitsParCuisine(Long idCuisine) {
		
		return produitRepository.findProduitsParCuisine(idCuisine);
	}

	@Override
	public List<Produit> listProduitsSelectionne() {
		
		return produitRepository.findProduitsSelectionne();
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		
		if (c.getIdCategorie() != null && categorieRepository.existsById(c.getIdCategorie())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		categorieRepository.save(c);
		return c.getIdCategorie();
	}

	@Override
	public Categorie getCategorie(Long idC) {
		Categorie categorie= categorieRepository.findOne(idC) ;
		if (categorie==null)throw new RuntimeException("User inexistant !");
		return categorie;
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		categorieRepository.deleteById(idCat);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		if (c.getIdCategorie()!= null && !categorieRepository.existsById(c.getIdCategorie())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		categorieRepository.save(c);
	}

	@Override
	public List<Categorie> listCategories() {
		return categorieRepository.findAll();
	}

	@Override
	public Long ajouterCuisine(Cuisine c) {
		if (c.getIdCuisine() != null && cuisineRepository.existsById(c.getIdCuisine())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		cuisineRepository.save(c);
		return c.getIdCuisine();
	}

	@Override
	public Cuisine getCuisine(Long idC) {
		Cuisine cuisine= cuisineRepository.getfinOne(idC) ;
		if (cuisine==null)throw new RuntimeException("cuisine inexistant !");
		return cuisine;
	}

	@Override
	public void supprimerCuisine(Long idCat) {
		cuisineRepository.deleteById(idCat);
		
	}

	@Override
	public void modifierCuisine(Cuisine c) {
		if (c.getIdCuisine()!= null && !cuisineRepository.existsById(c.getIdCuisine())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		cuisineRepository.save(c);
		
	}

	@Override
	public List<Cuisine> listCuisines() {
		return cuisineRepository.findAll();
	}

	

}
