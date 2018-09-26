package com.devglan.model;

import javax.persistence.Column;

public class UserDto {

	 private String username;   	 
	 private String email;
	 private String password;
	 private String nom ;
	 private String prenom;
	 private String srcimg;
	 private String interest;
	 
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

   
}
