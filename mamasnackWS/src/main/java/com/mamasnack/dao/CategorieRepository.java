package com.mamasnack.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mamasnack.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{ 
	
	
}
