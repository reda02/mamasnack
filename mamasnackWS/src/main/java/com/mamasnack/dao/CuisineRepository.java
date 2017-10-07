package com.mamasnack.dao;

 
import org.springframework.data.jpa.repository.JpaRepository;

import com.mamasnack.entities.Cuisine;

public interface CuisineRepository extends JpaRepository<Cuisine, Long>{ 
	
	
}