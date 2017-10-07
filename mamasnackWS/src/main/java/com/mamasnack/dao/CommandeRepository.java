package com.mamasnack.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mamasnack.entities.Commande;

	public interface CommandeRepository extends JpaRepository<Commande, Long>{

	/*	@Query("SELECT o FROM user o INNER JOIN  o.commande  WHERE o.idUser like :x")
		public List<Commande> findCommandesParUser(@Param("x") Long idUser);
		
		// a modifier
		@Query("SELECT o FROM produit JOIN FETCH o.categorie c WHERE c.idCategorie like :x")
		public List<Commande> findCommandesParProduit(@Param("x")Long idProduit); */
		
		
	}