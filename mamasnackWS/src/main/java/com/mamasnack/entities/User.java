package com.mamasnack.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8014181077416730759L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	@NotNull
	@Size(min=1,max=4)
	private String nomUser;
	private String prenomUser;
	private String email;
	private String photo;
	private String adresse;
	private String tel;
	private String ville;
	private String codePostale;
	private Date dateNaissonce;
	private String password;
	private boolean actived;
	@OneToMany(mappedBy="user")
	private Collection<Commande>commande;
	@OneToMany
	@JoinColumn(name="idUser")
	private Collection<Role>role;
	
	
	public User(String nomUser, String prenomUser, String email, String photo, String adresse, String tel, String ville,
			String codePostale, Date dateNaissonce, String password, boolean actived) {
		super();
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.email = email;
		this.photo = photo;
		this.adresse = adresse;
		this.tel = tel;
		this.ville = ville;
		this.codePostale = codePostale;
		this.dateNaissonce = dateNaissonce;
		this.password = password;
		this.actived = actived;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getNomUser() {
		return nomUser;
	}
	public User(String nomUser, String prenomUser, String email, String photo, String adresse, String tel, String ville,
			String codePostale, Date dateNaissonce, String password) {
		super();
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.email = email;
		this.photo = photo;
		this.adresse = adresse;
		this.tel = tel;
		this.ville = ville;
		this.codePostale = codePostale;
		this.dateNaissonce = dateNaissonce;
		this.password = password;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getPrenomUser() {
		return prenomUser;
	}
	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	public Date getDateNaissonce() {
		return dateNaissonce;
	}
	public void setDateNaissonce(Date dateNaissonce) {
		this.dateNaissonce = dateNaissonce;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Commande> getCommande() {
		return commande;
	}
	public void setCommande(Collection<Commande> commande) {
		this.commande = commande;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}

}
