package com.bundzilla.session;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.core.FacesMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Identity;

import com.bundzilla.entity.User;
import com.bundzilla.entity.UserRole;


/**
 * Authentication module - verifies the given username/password combination is valid.
 */
@Name("authenticator")
public class Authenticator
{
    @Logger 
    private Log log;
    
    @In 
    private Identity identity;
   
	@In
	private FacesMessages facesMessages;
	
	@In
	private EntityManager entityManager;
	
    /**
     * Authenticates the injected {@link #identity}.
     * @return <code>true</code> for a successful authentication, <code>false</code> otherwise.
     */
    public boolean authenticate()
    {
        String username = identity.getUsername();
		log.info("authenticating #0/#1", username, identity.getPassword());
        Query query = this.entityManager.createQuery("from User u where u.name = :username and u.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", identity.getPassword());
        User user = (User) query.getSingleResult();
        if (user == null) {
        	return false;
        }
        for (UserRole userRole : user.getUserRoleCollection()) {
			String roleName = userRole.getRole().getName();
			log.info("Empowering user #0 with role #1", username, roleName);
			identity.addRole(roleName);
		}
        
        return true;
    }
}
