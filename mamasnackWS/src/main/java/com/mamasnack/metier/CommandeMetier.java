package com.mamasnack.metier;

import java.util.List;

import com.mamasnack.entities.Commande;
import com.mamasnack.entities.Panier;
import com.mamasnack.entities.User;


public interface CommandeMetier {
	
	   public Commande enrigistrerCommande(Panier p , User u);
	
	    // Recherche Multicritère 
		public List<Commande> listCommandes();
		public List<Commande> listCommandesParUser(Long idUser) ;
		public List<Commande> listCommandesParProduit(Long idProduit) ;
		
		
	

}
