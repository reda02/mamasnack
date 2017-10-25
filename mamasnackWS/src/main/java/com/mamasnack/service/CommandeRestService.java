package com.mamasnack.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamasnack.entities.Commande;
import com.mamasnack.entities.LigneCommande;
import com.mamasnack.entities.Panier;
import com.mamasnack.entities.User;
import com.mamasnack.metier.CommandeMetier;

@RestController
public class CommandeRestService  {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CommandeMetier commandeMetier ;

	//to DO
	public Commande enrigistrerCommande(Panier p, User u) {
		return commandeMetier.enrigistrerCommande(p, u);
	}

	@RequestMapping(value="/listCommandes",method=RequestMethod.GET)
	public String listCommandes() throws JSONException {
		List<Commande> commandes = new ArrayList<>();
		JSONObject resultat = new JSONObject();
		JSONArray tab = new JSONArray();
		try { 
			commandes = commandeMetier.listCommandes();
			ObjectMapper mapper = new ObjectMapper(); 
			resultat.put("errMess", "");
			if (commandes != null && !commandes.isEmpty()) {
				tab = new JSONArray(mapper.writeValueAsString(commandes).toString());
				resultat.put("commandes", tab);
			}else{
				resultat.put("commandes", "tabVide");
			}  
		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service listCommandes() : " + e.getMessage());
		}
		return resultat.toString();
	}

	@RequestMapping(value="/listCommandesParUser/{idUser}",method=RequestMethod.GET)
	public List<Commande> listCommandesParUser(@PathVariable Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/listCommandesParProduit/{idProduit}",method=RequestMethod.GET)
	public String listCommandesParProduit(@PathVariable Long idProduit) throws JSONException {
	
		
		List<Commande> commandes = new ArrayList<>();
		JSONObject resultat = new JSONObject();
		JSONArray tab = new JSONArray();
		try { 
			commandes = commandeMetier.listCommandesParProduit(idProduit);
			ObjectMapper mapper = new ObjectMapper(); 
			resultat.put("errMess", "");
			if (commandes != null && !commandes.isEmpty()) {
				tab = new JSONArray(mapper.writeValueAsString(commandes).toString());
				resultat.put("commandes", tab);
			}else{
				resultat.put("commandes", "tabVide");
			}  
		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service listCommandes() : " + e.getMessage());
		}
		return resultat.toString();
		
	}
	@RequestMapping(value="/addCommande",method=RequestMethod.POST, consumes = "application/json")
	public String addCommande(Commande commande) {
		return null;
		
		
		
	}
	
 /////////////////////////////////////// ligne de commande ////////////////////////////////////
	
	@RequestMapping(value="/getAllLigneDeCommande/{commandeId}",method=RequestMethod.GET)
	public String getAllLigneDeCommande(@PathVariable  long commandeId) throws JSONException {
		logger.info("getAllLigneDeCommande message");

		List<LigneCommande> ligneCommandes = new ArrayList<>();
		JSONObject resultat = new JSONObject();
		JSONArray tab = new JSONArray();
		try { 
			ligneCommandes = commandeMetier.getAllLigneDeCommande(commandeId);
			ObjectMapper mapper = new ObjectMapper(); 
			resultat.put("errMess", "");
			if (ligneCommandes != null && !ligneCommandes.isEmpty()) {
				tab = new JSONArray(mapper.writeValueAsString(ligneCommandes).toString());
				resultat.put("LigneCommande", tab);
			}else{
				resultat.put("LigneCommande", "tabVide");
			}  
		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service getAllLigneDeCommande() : " + e.getMessage());
		}
		return resultat.toString();
	}
	
	@RequestMapping(value="/getLigneDeCommandeById/{commandeId}/{ligneDeCommandeId}",method=RequestMethod.GET)
	public String getLigneDeCommandeById(@PathVariable long commandeId, @PathVariable long ligneDeCommandeId) throws JSONException {
	
		
		LigneCommande ligneCommande = null;
		JSONObject resultat = new JSONObject();
		try {
			ligneCommande = commandeMetier.getLigneDeCommandeById(commandeId,ligneDeCommandeId);
			ObjectMapper mapper = new ObjectMapper(); 

			resultat.put("ligneCommande", new  JSONObject(mapper.writeValueAsString(ligneCommande).toString()));
			resultat.put("errMess", "");
		} catch (Exception e) {
			resultat.put("errMess", e.getMessage());
			logger.error(getClass().getName()+
					"une erreur est produite lors de l'exécution du web service getLigneDeCommandeById : " + e.getMessage());
		}
		return resultat.toString();
	}
	
	@RequestMapping(value="/addLigneDeCommande",method=RequestMethod.POST)
	public String addLigneDeCommande(@RequestBody LigneCommande ligneDeCommande) throws JSONException {
		
		 String Add = null;
			JSONObject resultat = new JSONObject();
			try {

				Add =  commandeMetier.addLigneDeCommande( ligneDeCommande);
				resultat.put("errMess", Add);
			} catch (Exception e) {
				resultat.put("errMess", e.getMessage());
				logger.error(getClass().getName()+
						"une erreur est produite lors de l'exécution du web service addLigneDeCommande : " + e.getMessage());
			}
			return resultat.toString();
		
		
	}
}
