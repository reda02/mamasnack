package com.mamasnack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mamasnack.entities.Role;
import com.mamasnack.entities.User;
import com.mamasnack.metier.UserMetier;

@RestController
public class UserRestService {
	
	@Autowired
	private UserMetier userMetier ;
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public User addUser(@RequestBody User u) { //@RequestBody les donneés de la req  il va les recupere dans le corp de la requte et il sont supposé au format jeson 
		return userMetier.addUser(u);
	}
	
	@RequestMapping(value="/deleteuser/{idUser}",method=RequestMethod.GET)
    public void deleteUser(@PathVariable Long idUser) {
		 userMetier.supprimerUser(idUser);
	}
	
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	public User updateUser(@RequestBody User u) { 
		return userMetier.modifierUser(u);
	}
	
	@RequestMapping(value="/getuser/{idUser}",method=RequestMethod.GET)
    public User getUser(@PathVariable Long idUser) {
		return userMetier.getUser(idUser);
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> getUsers() {
		return userMetier.listUsers();
	}
	@RequestMapping(value="/userbyName/{nameUser}",method=RequestMethod.GET)
    public List<User> findUserbyName(@PathVariable String nameUser) {
		return userMetier.findUserbyName(nameUser);
	}
	
    //  Gestion Role
	
	@RequestMapping(value="/rolebyUserId/{iduser}",method=RequestMethod.GET)
    public List<Role> findRolebyUser(@PathVariable Long iduser) {
		return userMetier.findRolebyUser(iduser);
	}
	
	@RequestMapping(value="/attribueRole/{iduser}/{idrole}",method=RequestMethod.GET)
	public void attribueRole( @PathVariable  Long iduser, @PathVariable   Long idrole) {
		 userMetier.attribueRole(iduser, idrole);
	}
	@RequestMapping(value="/retirerRole/{iduser}/{idrole}",method=RequestMethod.GET)
	public void retirerRole( @PathVariable  Long iduser, @PathVariable   Long idrole) {
		 userMetier.retirerRole(iduser, idrole);
	}
	
	@RequestMapping(value="/addrole",method=RequestMethod.POST)
	public Role addRole(@RequestBody Role e) { 
		return userMetier.addRole(e);
	}
	@RequestMapping(value="/userbyRole/{idRole}",method=RequestMethod.GET)
    public List<User> findUserbyRole(@PathVariable Long idRole) {
		return userMetier.findUsersbyRole(idRole);
	}

	
	
	
}
