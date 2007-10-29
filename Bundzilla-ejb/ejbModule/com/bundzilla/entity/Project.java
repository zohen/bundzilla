package com.bundzilla.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.hibernate.validator.Length;

@Entity
public class Project implements Serializable {
	
	private Long id;
	private Integer version;
	private String name;
	private String description;
	private Language baseLanguage;
	private Collection<ProjectUserRole> projectUserRoleCollection;
	
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
	
	@Length(max=20)
	public String getName() {
	     return name;
	}

	public void setName(String name) {
	     this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the baseLanguage
	 */
	@ManyToOne
	public Language getBaseLanguage() {
		return baseLanguage;
	}

	/**
	 * @param baseLanguage the baseLanguage to set
	 */
	public void setBaseLanguage(Language baseLanguage) {
		this.baseLanguage = baseLanguage;
	}

	/**
	 * @return the projectUserRoleCollection
	 */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="project")
	public Collection<ProjectUserRole> getProjectUserRoleCollection() {
		return projectUserRoleCollection;
	}

	/**
	 * @param projectUserRoleCollection the projectUserRoleCollection to set
	 */
	public void setProjectUserRoleCollection(
			Collection<ProjectUserRole> projectUserRoleCollection) {
		this.projectUserRoleCollection = projectUserRoleCollection;
	}

}
