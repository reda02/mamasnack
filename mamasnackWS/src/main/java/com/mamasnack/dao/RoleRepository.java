 package com.mamasnack.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mamasnack.entities.Role;




public interface RoleRepository extends JpaRepository<Role, Long>{ 


}