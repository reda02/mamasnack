package com.mamasnack.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3335184341463928468L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idUser", nullable = false)
	private Long idUser;
	@NotNull
	@Size(min=1,max=10)
	private String nomUser;
	private String prenomUser;
	private String email;
	private String photo;
	private String adresse;
	private int tel;
	private String ville;
	private int codePostale;
	private Date dateNaissonce;
	private String password;
	private boolean actived;
	private boolean mamaActived;
	@OneToMany(mappedBy="user")
	private Collection<Commande>commande;
	@ManyToMany(targetEntity=Role.class)
	@JoinTable(name="UsersAndRoles",
	joinColumns=@JoinColumn(name="idUser"),
	inverseJoinColumns=@JoinColumn(name="idRole"))
	private Collection<Role> role;

	@ManyToMany
	@JoinTable(name="UsersAndMessage",
	joinColumns={
			@JoinColumn(name="idUserExp", referencedColumnName="idUser", nullable = false)},

	inverseJoinColumns=@JoinColumn( name="idMsg"))
	private Collection<Message>message;


	@ManyToMany
	@JoinTable(name="UsersAndMessage",
	joinColumns={
			@JoinColumn(name="idUserExp", referencedColumnName="idUser", nullable = false)},
	inverseJoinColumns = {
			@JoinColumn(name = "idUserDist", referencedColumnName = "idUser", nullable = false)})
	//	inverseJoinColumns=@JoinColumn( name="idMsg"))
	private Collection<User>users;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(@NotNull @Size(min = 1, max = 10) String nomUser, String prenomUser, String email, String photo,
			String adresse, int tel, String ville, int codePostale, Date dateNaissonce, String password,
			boolean actived, boolean mamaActived) {
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
		this.mamaActived = mamaActived;
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
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(int codePostale) {
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
	@JsonIgnore
	@XmlTransient
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
	public boolean isMamaActived() {
		return mamaActived;
	}
	public void setMamaActived(boolean mamaActived) {
		this.mamaActived = mamaActived;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Role> getRole() {
		return role;
	}
	public void setRole(Collection<Role> role) {
		this.role = role;
	}

}
