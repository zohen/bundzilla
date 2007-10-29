package com.bundzilla.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
public class User implements Serializable {
	
	private Long id;
	private Integer version;
	private String name;
	private String password;
	private String email;
	private String passwordConfirmation;
	private Collection<UserRole> userRoleCollection;
	
	@Id @GeneratedValue
	public Long getId() {
	     return id;
	}

	public void setId(Long id) {
	     this.id = id;
	}
	
	@Version
	public Integer getVersion() {
	     return version;
	}

	private void setVersion(Integer version) {
	     this.version = version;
	}   	
	
	@Length(max=20) @NotNull
	public String getName() {
	     return name;
	}

	public void setName(String name) {
	     this.name = name;
	}

	@NotNull
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   	

	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	public Collection<UserRole> getUserRoleCollection() {
		return userRoleCollection;
	}

	public void setUserRoleCollection(Collection<UserRole> userRoleCollection) {
		this.userRoleCollection = userRoleCollection;
	}

}
