package com.mamasnack.metier;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityExistsException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
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
	public Commande getCommandeById(Long idCmd) {
		Commande commande= commandeRepository.findOne(idCmd) ;
		if (commande==null)throw new RuntimeException("Commande inexistant !");
		    logger.debug("Debug message");
	        logger.info("Info message");
	        logger.warn("Warn message");
	        logger.error("Error message");
		return commande;
	}

	@Override
	public List<Commande> listCommandes() {
		  logger.info("Info message");
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

	// Gerer Lignes de Commandes
	
	@Override
	public List<LigneCommande> getAllLigneDeCommande(long commandeId) {
		
		
		return ligneCommandeRepository.findAllLigneDeCommande(commandeId) ;
	}

	@Override
	public LigneCommande getLigneDeCommandeById(long commandeId, long ligneDeCommandeId) {
	
		 Commande commande = getCommandeById(commandeId);

	        Collection<LigneCommande> ligneDeCommandes = commande.getItems();

	        for(LigneCommande ligneCommande : ligneDeCommandes){
	        	
	        	
	        	 if(ligneCommande.getIdLigneCommande().equals(ligneDeCommandeId) ){
	        		 
	        		 return ligneCommande;
	        	 }
	        	
	        }
			return null;
	      
	        
	        
	        

	       
	}

	@Override
	public String addLigneDeCommande(LigneCommande ligneDeCommande) {

     
		if (ligneDeCommande.getIdLigneCommande() != null && !ligneCommandeRepository.existsById(ligneDeCommande.getIdLigneCommande())) {
			logger.error(getClass().getName()+
				    "idUser est null de l'exécution du web service addLigneDeCommande : ");

			return "NOK";
	}
		ligneCommandeRepository.save(ligneDeCommande);
	    return "OK";
	}

	@Override
	public LigneCommande modifyLigneDeCommande(long commandeId, LigneCommande ligneDeCommandeToSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneCommande removeLigneDeCommande(long commandeId, long ligneDeCommandeId) {
		    
		Commande commande = getCommandeById(commandeId);


            Collection<LigneCommande> ligneDeCommandes =  commande.getItems();
            LigneCommande ligneCmdExiste = getLigneDeCommandeById(commandeId, ligneDeCommandeId);
            
           for(LigneCommande ligneCommande : ligneDeCommandes){
        	   
        	   
        	   if(ligneDeCommandes.contains(ligneCmdExiste) ){
        		   
	           commande.setTotal(commande.getTotal() - (ligneCommande.getPrix() * ligneCommande.getQuantite()));
	           ligneDeCommandes.remove(ligneDeCommandeId);
	           commandeRepository.save(commande);
        	   }
        	   
        	   System.out.println("le ligneCommande n'existe pas ");
        	   }	
	        return ligneCmdExiste;
	}



	@Override
	public String addCommande(Commande commande) {
		//p.setCategorie(getCategorie(IdCat));
				if (commande.getIdCommande() != null && commandeRepository.existsById(commande.getIdCommande())) {
					throw new EntityExistsException("There is already existing entity with such ID in the database.");
				}
				commandeRepository.save(commande);
				return "OK";
		
	}



}
