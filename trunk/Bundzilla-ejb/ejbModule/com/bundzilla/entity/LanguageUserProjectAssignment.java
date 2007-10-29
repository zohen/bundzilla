package com.bundzilla.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import org.hibernate.validator.Length;

@Entity
public class LanguageUserProjectAssignment implements Serializable {
	
	private Long id;
	private Integer version;
	private ProjectUserRole projectUserRole;
	private Language language;
	
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
	
	@ManyToOne
	public ProjectUserRole getProjectUserRole() {
	     return projectUserRole;
	}

	public void setProjectUserRole(ProjectUserRole projectUserRole) {
	     this.projectUserRole = projectUserRole;
	}

	/**
	 * @return the language
	 */
	@ManyToOne
	public Language getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

}
