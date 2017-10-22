package com.mamasnack.metier;

import java.util.List;

import com.mamasnack.entities.Role;
import com.mamasnack.entities.User;

public interface UserMetier {
	
	public User addUser(User u);
	public void supprimerUser(Long idUser) ;
	public String modifierUser(User u);
	public User getUser(Long idUser); 
	
	public List<User> listUsers();
	public List<User> findUserbyName(String nameUser);
	
	//   Gestion Role
	public void attribueRole(Long iduser, Long idrole);
	public Role getRole(Long idRole); 
	public Role addRole(Role e);
	public List<User> findUsersbyRole(Long idRole);
	public List<Role> findRolebyUser(Long iduser);
	public void retirerRole(Long idUser, Long idRole);
	

}
