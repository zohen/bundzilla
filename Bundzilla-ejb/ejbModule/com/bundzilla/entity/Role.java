package com.bundzilla.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.validator.Length;

@Entity
@Table(name="APP_Role")
public class Role implements Serializable {
	
	private Long id;
	private Integer version;
	private String name;
	
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

}
