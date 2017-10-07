package com.mamasnack.dao;
  


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mamasnack.entities.User;




public interface UserRepository extends JpaRepository<User, Long>{ 
	  @Query("SELECT o FROM User o  WHERE  o.nomUser like :x")
		public User findUserByName(@Param("x") String nom);
	 
	 
	   @Query("SELECT o FROM User o INNER JOIN  o.role c  WHERE  c.idRole like :x")
		public List<User>  findUserbyRole(@Param("x") Long idRole);
}