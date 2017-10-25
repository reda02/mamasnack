package com.mamasnack.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamasnack.entities.Categorie;
import com.mamasnack.entities.Cuisine;
import com.mamasnack.entities.Produit;
import com.mamasnack.metier.ProduitMetier;

@RestController
public class ProduitRestService {
	@Autowired
	private ProduitMetier produitMetier ;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value="/addProduit",method=RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String ajouterProduit(@RequestBody Produit p, Long IdCat) throws JSONException {
		String Add = null;
		JSONObject resultat = new JSONObject();
		try {
			Add =  produitMetier.ajouterProduit(p, IdCat);
			resultat.put("errMess", Add);
		    } catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service ajouterProduit : " + e.getMessage());
		}
		return resultat.toString();
	}
	

	@RequestMapping(value="/getProduit/{idPro}",method=RequestMethod.GET)
	public String getProduit(@PathVariable Long idPro) throws JSONException {
		

		Produit produit = null;
		JSONObject resultat = new JSONObject();
		try {
			produit = produitMetier.getProduit(idPro);
			ObjectMapper mapper = new ObjectMapper(); 

			resultat.put("produit", new  JSONObject(mapper.writeValueAsString(produit).toString()));
			resultat.put("errMess", "");
		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service getProduit : " + e.getMessage());
		}
		return resultat.toString();
	}

	@RequestMapping(value="/deleteProduit/{idPro}",method=RequestMethod.GET)
	public String supprimerProduit(@PathVariable Long idPro) throws JSONException {
		String supp=null;
		JSONObject resultat = new JSONObject();
		try {
			supp =  produitMetier.supprimerProduit(idPro);
			resultat.put("errMess", supp);
		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service ajouterProduit : " + e.getMessage());
		}
		return resultat.toString();
	}

	
	@RequestMapping(value="/updateProduit",method=RequestMethod.POST)
	public String modifierProduit(@RequestBody Produit p) throws JSONException {
		String update = null;
		JSONObject resultat = new JSONObject();
		try {
			update = produitMetier.modifierProduit(p);
			resultat.put("updateMess", update);
			resultat.put("errMess", "");
		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service updateuser : " + e.getMessage());
		}
		return resultat.toString();
	}

	@RequestMapping(value="/getProduits",method=RequestMethod.GET)
	public String listProduits() throws JSONException {

		List<Produit> produits = new ArrayList<>();
		JSONObject resultat = new JSONObject();
		JSONArray tab = new JSONArray();
		try { 
			produits = produitMetier.listProduits();
			ObjectMapper mapper = new ObjectMapper(); 
			resultat.put("errMess", "");
			if (produits != null && !produits.isEmpty()) {
				tab = new JSONArray(mapper.writeValueAsString(produits).toString());
				resultat.put("produits", tab);
			}else{
				resultat.put("produits", "tabVide");
			}
			
			  

		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service getProduits() : " + e.getMessage());
		}
		return resultat.toString();

	}
    //toDo
	@RequestMapping(value="/getProduitsParCat/{idCat}",method=RequestMethod.GET)
	public String listProduitsParCategorie(@PathVariable Long idCat) throws JSONException {
	
		
		List<Produit> produits = new ArrayList<>();
		JSONObject resultat = new JSONObject();
		JSONArray tab = new JSONArray();
		try { 
			produits = produitMetier.listProduitsParCategorie(idCat);
			ObjectMapper mapper = new ObjectMapper(); 
			resultat.put("errMess", "");
			if (produits != null && !produits.isEmpty()) {
				tab = new JSONArray(mapper.writeValueAsString(produits).toString());
				resultat.put("produits", tab);
			}else{
				resultat.put("produits", "tabVide");
			}  

		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service getProduitsParCat() : " + e.getMessage());
		}
		return resultat.toString();
	}
	
	@RequestMapping(value="/getProduitsBykeyword/{keyword}",method=RequestMethod.GET )
        public String produitsParMotCle(@PathVariable String keyword) throws JSONException {

		List<Produit> produits = new ArrayList<>();
		JSONObject resultat = new JSONObject();
		JSONArray tab = new JSONArray();
		try { 
			produits = produitMetier.produitsParMotCle(keyword);
			ObjectMapper mapper = new ObjectMapper(); 
			resultat.put("errMess", "");
			if (produits != null && !produits.isEmpty()) {
				tab = new JSONArray(mapper.writeValueAsString(produits).toString());
				resultat.put("produits", tab);
			}else{
				resultat.put("produits", "tabVide");
			}  

		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service getProduitsBykeyword() : " + e.getMessage());
		}
		return resultat.toString();
	}
	
	
	
//toDo
	@RequestMapping(value="/getProduitsParCuisine/{idCuisine}",method=RequestMethod.GET)
	public String listProduitsParCuisine(@PathVariable Long idCuisine) throws JSONException {

		List<Produit> produits = new ArrayList<>();
		JSONObject resultat = new JSONObject();
		JSONArray tab = new JSONArray();
		try { 
			produits = produitMetier.listProduitsParCuisine(idCuisine);
			ObjectMapper mapper = new ObjectMapper(); 
			resultat.put("errMess", "");
			if (produits != null && !produits.isEmpty()) {
				tab = new JSONArray(mapper.writeValueAsString(produits).toString());
				resultat.put("produits", tab);
			}else{
				resultat.put("produits", "tabVide");
			}  

		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service getProduitsParCuisine() : " + e.getMessage());
		}
		return resultat.toString();
	}

	@RequestMapping(value="/listProduitsSelectionne",method=RequestMethod.GET)
	public String listProduitsSelectionne() throws JSONException {
	
		List<Produit> produits = new ArrayList<>();
		JSONObject resultat = new JSONObject();
		JSONArray tab = new JSONArray();
		try { 
			produits = produitMetier.listProduitsSelectionne();
			ObjectMapper mapper = new ObjectMapper(); 
			resultat.put("errMess", "");
			if (produits != null && !produits.isEmpty()) {
				tab = new JSONArray(mapper.writeValueAsString(produits).toString());
				resultat.put("produits", tab);
			}else{
				resultat.put("produits", "tabVide");
			}  

		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service listProduitsSelectionne() : " + e.getMessage());
		}
		return resultat.toString();
		
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
	public String ajouterCuisine(@RequestBody Cuisine c) throws JSONException {
	
		String Addc = null;
		JSONObject resultat = new JSONObject();
		try {
			Addc =   produitMetier.ajouterCuisine(c);
			resultat.put("errMess", Addc);
		    } catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service ajouterProduit : " + e.getMessage());
		}
		return resultat.toString();
	}

	
	// not working 
	@RequestMapping(value="/getCuisine/{idC}",method=RequestMethod.GET)
	public String getCuisine(@PathVariable Long idC) throws JSONException {
		
		Cuisine cuisine = null;
		JSONObject resultat = new JSONObject();
		try {
			cuisine = produitMetier.getCuisine(idC);
			ObjectMapper mapper = new ObjectMapper(); 

			resultat.put("cuisine", new  JSONObject(mapper.writeValueAsString(cuisine).toString()));
			resultat.put("errMess", "");
		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service getCuisine : " + e.getMessage());
		}
		return resultat.toString();
	}

	@RequestMapping(value="/deleteCuisine",method=RequestMethod.POST)
	public String supprimerCuisine(@PathVariable Long idCat) throws JSONException {
		
		String supp=null;
		JSONObject resultat = new JSONObject();
		try {
			supp =  produitMetier.supprimerCategorie(idCat);
			resultat.put("errMess", supp);
		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service supprimerCuisine : " + e.getMessage());
		}
		return resultat.toString();
		
	}

	@RequestMapping(value="/updateCuisine",method=RequestMethod.POST)
	public String modifierCuisine(@RequestBody Cuisine c) throws JSONException {
		
		String update = null;
		JSONObject resultat = new JSONObject();
		try {
			update = produitMetier.modifierCuisine(c);
			resultat.put("updateMess", update);
			resultat.put("errMess", "");
		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service modifierCuisine : " + e.getMessage());
		}
		return resultat.toString();
		
	}

	@RequestMapping(value="/getAllCuisines",method=RequestMethod.GET)
	public String listCuisines() {
		return toJSON(produitMetier.listCuisines());
	}

	
	public static String toJSON(Object object) 
    { 
        if ( object == null ){
        return "l'objet n'existe pas"; 
        } 
        try { 
           ObjectMapper mapper = new ObjectMapper(); 
           return mapper.writeValueAsString(object); 
           } 
        catch (Exception e) { 
         e.printStackTrace(); 
        } 
      return "{}"; 
      
}
}