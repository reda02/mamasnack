package com.mamasnack.metier;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mamasnack.dao.RoleRepository;
import com.mamasnack.dao.UserRepository;
import com.mamasnack.entities.Role;
import com.mamasnack.entities.User;


@Service
public class UserMetierImpl implements UserMetier{

	@Autowired
	private UserRepository userRepository ;
	@Autowired
	private RoleRepository roleRepository ;

	@Override
	public User addUser(User u) {
		if (u.getIdUser() != null && userRepository.existsById(u.getIdUser())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return userRepository.save(u);
	}

	@Override
	public void supprimerUser(Long idUser) {
		userRepository.deleteById(idUser);

	}

	@Override
	public User modifierUser(User u) {
		if (u.getIdUser() != null && !userRepository.existsById(u.getIdUser())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return userRepository.save(u);
	}



	@Override
	public User getUser(Long idUser) {
	
		User user= userRepository.getOne(idUser) ;
		if (user==null)throw new RuntimeException("User inexistant !");
		return user;
	}

	@Override
	public List<User> listUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User findUserbyName(String nameUser) {
	
		return userRepository.findUserByName(nameUser);
	}

	@Override
	public void attribueRole(User u, Role e) {
		
		u.getRole().add(e) ;
		userRepository.save(u);

	}

	@Override
	public Role addRole(Role e) {
	
		return roleRepository.save(e);
	}

	@Override
	public List<User> findUsersbyRole(Long idRole) {

		return userRepository.findUserbyRole(idRole);
	}

}
