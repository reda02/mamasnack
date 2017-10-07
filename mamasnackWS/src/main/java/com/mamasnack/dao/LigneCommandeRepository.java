package com.mamasnack.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mamasnack.entities.LigneCommande;

 public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long>{ 
	
	
}