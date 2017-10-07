package com.mamasnack.metier;

import java.util.List;

import com.mamasnack.entities.Role;
import com.mamasnack.entities.User;

public interface UserMetier {
	
	public User addUser(User u);
	public void supprimerUser(Long idUser) ;
	public User modifierUser(User u);
	public User getUser(Long idUser); 
	
	public List<User> listUsers();
	public User findUserbyName(String nameUser);
	
	//   Gestion Role
	public void attribueRole(User u, Role e);
	public Role addRole(Role e);
	public List<User> findUsersbyRole(Long idRole);
	

}
