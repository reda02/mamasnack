package com.mamasnack.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mamasnack.dao.CommandeRepository;
import com.mamasnack.dao.LigneCommandeRepository;
import com.mamasnack.entities.Commande;
import com.mamasnack.entities.LigneCommande;
import com.mamasnack.entities.Panier;
import com.mamasnack.entities.User;

@Service
public class CommandeMetierImpl implements CommandeMetier{
	@Autowired
	private CommandeRepository commandeRepository ;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository ;
	
	@Override
	public Commande enrigistrerCommande(Panier p, User u) {
		
		Commande c = new Commande();
		c.setUser(u);
		c.setItems(p.getCommandes());
		c.setDateCommnade(new Date());
		for(LigneCommande lc : p.getCommandes())
			ligneCommandeRepository.save(lc);
		return c;
	}

	@Override
	public List<Commande> listCommandes() {
		
		return commandeRepository.findAll();
	}


	@Override
	public List<Commande> listCommandesParProduit(Long idProduit) {
		
		return commandeRepository.findCommandesParProduit(idProduit);
	}

	@Override
	public List<Commande> listCommandesParUser(Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
