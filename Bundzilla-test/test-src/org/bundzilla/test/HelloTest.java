/**
 * Copyright BoomZiK, 2007-2008
 */
package org.bundzilla.test;

import org.jboss.seam.mock.SeamTest;
import org.testng.annotations.Test;

/**
 * @author mihai
 */
public class HelloTest extends SeamTest {
	
	@Test
	public void testHello() throws Exception {
		FacesRequest faceReq = new FacesRequest("/hello.xhtml") {
			
			@Override
			protected void invokeApplication() throws Exception {
	            assert null == invokeMethod("#{simpleAction.sayHello}");
				
			}

			@Override
			protected void updateModelValues() throws Exception {
				setValue("#{simpleAction.value}", "Bundzilla");
			}

			@Override
			protected void processValidations() throws Exception {
				validateValue("#{simpleAction.value}", "Bundzilla");
			}
			
		};
		faceReq.run();
				
	}

}
