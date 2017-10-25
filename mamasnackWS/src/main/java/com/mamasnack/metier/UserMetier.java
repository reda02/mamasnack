package com.mamasnack.metier;

import java.util.List;

import com.mamasnack.entities.Role;
import com.mamasnack.entities.User;

public interface UserMetier {
	
	public String addUser(User u);
	public String supprimerUser(Long idUser) ;
	public String modifierUser(User u);
	public User getUser(Long idUser); 
	
	public List<User> listUsers();
	public List<User> findUserbyName(String nameUser);
	
	//   Gestion Role
	public String attribueRole(Long iduser, Long idrole);
	public Role getRole(Long idRole); 
	public String addRole(Role e);
	public List<User> findUsersbyRole(Long idRole);
	public List<Role> findRolebyUser(Long iduser);
	public String retirerRole(Long idUser, Long idRole);
	public String checkLogin(User u);
	public User findUsesbyEmail(String email);
	

}
