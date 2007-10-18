package com.bundzilla.session;

import javax.ejb.Local;

@Local
public interface SimpleAction {
	
	String getValue();
	
	void setValue(String value);
	
	/**
	 * Says hello.
	 */
	void sayHello();

}
