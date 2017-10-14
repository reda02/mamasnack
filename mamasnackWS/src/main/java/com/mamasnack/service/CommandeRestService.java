package com.mamasnack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mamasnack.entities.Commande;
import com.mamasnack.entities.Panier;
import com.mamasnack.entities.User;
import com.mamasnack.metier.CommandeMetier;

@RestController
public class CommandeRestService  {
	@Autowired
	private CommandeMetier commandeMetier ;

	
	public Commande enrigistrerCommande(Panier p, User u) {
		return commandeMetier.enrigistrerCommande(p, u);
	}

	@RequestMapping(value="/listCommandes",method=RequestMethod.GET)
	public List<Commande> listCommandes() {
		// TODO Auto-generated method stub
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

}
