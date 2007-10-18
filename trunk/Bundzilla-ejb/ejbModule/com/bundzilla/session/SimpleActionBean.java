package com.bundzilla.session;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.core.FacesMessages;
import org.jboss.seam.log.Log;

@Stateless
@Name("simpleAction")
public class SimpleActionBean implements SimpleAction {

	@Logger 
	private Log log;
	
	@In
	FacesMessages facesMessages;
	
	private String value;
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void sayHello() {
		String helloString = "Hey, #{simpleAction.value} dude!";
		log.info(helloString);
		facesMessages.add(helloString);
	}

}
