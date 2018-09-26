package com.devglan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="User")
public class User {

	   @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    private long id;
	    @Column
	    private String username;
	    @Column
		private String email;
	    @Column
	    @JsonIgnore
	    private String password;
	    @Column
	    private String nom ;
	    @Column
		private String prenom;
	    
	    @Column
	    private String srcimg;
	    @Column
	    private String interest;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private List<Role> roles;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String email, String password, String nom, String prenom, String srcimg,
			String interest) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.srcimg = srcimg;
		this.interest = interest;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	public String getSrcimg() {
		return srcimg;
	}

	public void setSrcimg(String srcimg) {
		this.srcimg = srcimg;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

    


	
 
}
