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

@Entity
public class ProjectUserRole implements Serializable {
	
	private Long id;
	private Integer version;
	private Project project;
	private ProjectRole projectRole;
	private User user;
	private Collection<LanguageUserProjectAssignment> languageUserProjectAssignmentCollection;
	
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
	public ProjectRole getProjectRole() {
	     return projectRole;
	}

	public void setProjectRole(ProjectRole role) {
	     this.projectRole = role;
	}

	/**
	 * @return the user
	 */
	@ManyToOne
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the project
	 */
	@ManyToOne
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the languageUserProjectAssignmentCollection
	 */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="projectUserRole")
	public Collection<LanguageUserProjectAssignment> getLanguageUserProjectAssignmentCollection() {
		return languageUserProjectAssignmentCollection;
	}

	/**
	 * @param languageUserProjectAssignmentCollection the languageUserProjectAssignmentCollection to set
	 */
	public void setLanguageUserProjectAssignmentCollection(
			Collection<LanguageUserProjectAssignment> languageUserProjectAssignmentCollection) {
		this.languageUserProjectAssignmentCollection = languageUserProjectAssignmentCollection;
	}
	
}
