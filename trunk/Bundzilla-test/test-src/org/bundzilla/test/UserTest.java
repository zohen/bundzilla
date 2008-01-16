/**
 * Copyright BoomZiK, 2007-2008
 */
package org.bundzilla.test;

import org.jboss.seam.mock.SeamTest;
import org.testng.annotations.Test;

/**
 * @author mihai
 */
public class UserTest extends SeamTest {
	
	@Test
	public void testRegistration() throws Exception {
		FacesRequest faceReq = new FacesRequest("/login.xhtml") {
			
			/* (non-Javadoc)
			 * @see org.jboss.seam.mock.SeamTest.Request#invokeApplication()
			 */
			@Override
			protected void invokeApplication() throws Exception {
	            Object invocationResult = invokeMethod("#{identity.login}");
	            System.out.println("Invocation result is: " + invocationResult);
				assert "loggedIn".equals(invocationResult);
	            setOutcome("/home.xhtml");
				
			}

			/* (non-Javadoc)
			 * @see org.jboss.seam.mock.SeamTest.Request#updateModelValues()
			 */
			@Override
			protected void updateModelValues() throws Exception {
				setValue("#{identity.username}", "admin");
				setValue("#{identity.password}", "admin");
			}

			/* (non-Javadoc)
			 * @see org.jboss.seam.mock.SeamTest.Request#processValidations()
			 */
			@Override
			protected void processValidations() throws Exception {
				validateValue("#{identity.username}", "admin");
				validateValue("#{identity.password}", "admin");
			}
			
		};
		faceReq.run();
				
	}

}
