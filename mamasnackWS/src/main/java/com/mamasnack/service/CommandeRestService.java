package com.mamasnack.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mamasnack.entities.Commande;
import com.mamasnack.entities.LigneCommande;
import com.mamasnack.entities.Panier;
import com.mamasnack.entities.User;
import com.mamasnack.metier.CommandeMetier;

@RestController
public class CommandeRestService  {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/")
    String hello(){
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warn message");
        logger.error("Error message");
        return "Done";
    }
	
	@Autowired
	private CommandeMetier commandeMetier ;

	
	public Commande enrigistrerCommande(Panier p, User u) {
		return commandeMetier.enrigistrerCommande(p, u);
	}

	@RequestMapping(value="/listCommandes",method=RequestMethod.GET)
	public List<Commande> listCommandes() {
		return commandeMetier.listCommandes();
	}

	@RequestMapping(value="/listCommandesParUser/{idUser}",method=RequestMethod.GET)
	public List<Commande> listCommandesParUser(@PathVariable Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/listCommandesParProduit/{idProduit}",method=RequestMethod.GET)
	public List<Commande> listCommandesParProduit(@PathVariable Long idProduit) {
		return commandeMetier.listCommandesParProduit(idProduit);
	}
	@RequestMapping(value="/addCommande",method=RequestMethod.POST, consumes = "application/json")
	public String addCommande(Commande commande) {
		return null;
		
		
		
	}
	
 /////////////////////////////////////// ligne de commande ////////////////////////////////////
	
	@RequestMapping(value="/getAllLigneDeCommande/{commandeId}",method=RequestMethod.GET)
	public List<LigneCommande> getAllLigneDeCommande(@PathVariable  long commandeId) {
		logger.info("getAllLigneDeCommande message");
		return commandeMetier.getAllLigneDeCommande(commandeId);
	}
	
	@RequestMapping(value="/getLigneDeCommandeById/{commandeId}/{ligneDeCommandeId}",method=RequestMethod.GET)
	public LigneCommande getLigneDeCommandeById(@PathVariable long commandeId, @PathVariable long ligneDeCommandeId) {
		return commandeMetier.getLigneDeCommandeById(commandeId,ligneDeCommandeId);
	}
	
	@RequestMapping(value="/addLigneDeCommande",method=RequestMethod.POST)
	public void addLigneDeCommande(@RequestBody LigneCommande ligneDeCommande) {
		 commandeMetier.addLigneDeCommande( ligneDeCommande);
		
		
		
	}
}
