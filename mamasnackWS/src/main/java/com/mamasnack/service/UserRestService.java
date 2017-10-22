package com.mamasnack.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamasnack.entities.Role;
import com.mamasnack.entities.User;
import com.mamasnack.metier.UserMetier;

@RestController
public class UserRestService {
	
	@Autowired
	private UserMetier userMetier ;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public User addUser(@RequestBody User u) { //@RequestBody les donneés de la req  il va les recupere dans le corp de la requte et il sont supposé au format jeson 
		return userMetier.addUser(u);
	}
	
	@RequestMapping(value="/deleteuser/{idUser}",method=RequestMethod.GET)
    public void deleteUser(@PathVariable Long idUser) {
		 userMetier.supprimerUser(idUser);
	}
	
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	public String updateUser(@RequestBody User u) throws JSONException { 
		//return userMetier.modifierUser(u);
		
		String update = null;
		JSONObject resultat = new JSONObject();
		try {

			update =  userMetier.modifierUser(u);
	           
		    resultat.put("updateMess", update);
		    resultat.put("errMess", "");
		} catch (Exception e) {
			 resultat.put("errMess", e.getMessage());
			 logger.error(getClass().getName(),
					    "une erreur est produite lors de l'exécution du web service updateuser : " + e.getMessage());
		}
		return resultat.toString();
	}
	
	
	
	
	@RequestMapping(value="/getuser/{idUser}",method=RequestMethod.GET)
    public String getUser(@PathVariable Long idUser) throws JSONException {
		
		
		User user = null;
		JSONObject resultat = new JSONObject();
		try {

			user = userMetier.getUser(idUser);
			 ObjectMapper mapper = new ObjectMapper(); 
	           
		    resultat.put("user", new  JSONObject(mapper.writeValueAsString(user).toString()));
		    resultat.put("errMess", "");
		} catch (Exception e) {
			 resultat.put("errMess", e.getMessage());
			 logger.error(getClass().getName(),
					    "une erreur est produite lors de l'exécution du web service getuser : " + e.getMessage());
		}
		return resultat.toString();
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
