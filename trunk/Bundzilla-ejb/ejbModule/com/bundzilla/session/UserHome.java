package com.bundzilla.session;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.RequestParameter;
import org.jboss.seam.core.FacesMessages;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.log.Log;

import com.bundzilla.entity.Role;
import com.bundzilla.entity.User;
import com.bundzilla.entity.UserRole;

@Name("userHome")
public class UserHome extends EntityHome<User>
{

    @RequestParameter 
    Long userId;
    
    @Logger Log log;
    
    @In
    private FacesMessages facesMessages;
    
    private String passwordConfirmation;
    
    @Override
    public Object getId() 
    { 
        if (userId == null)
        {
            return super.getId();
        }
        else
        {
            return userId;
        }
    }
    
    @Override @Begin
    public void create() {
        super.create();
    }
    
    public String getPasswordConfirmation() {
    	return this.passwordConfirmation;
    }
    
    public void setPasswordConfirmation(String passwordConfirmation) {
    	this.passwordConfirmation = passwordConfirmation;
    }

	/* (non-Javadoc)
	 * @see org.jboss.seam.framework.EntityHome#persist()
	 */
	@Override
	public String persist() {
		User user = getInstance();
		if (user == null) {
			log.warn("Current UserHome has no instance", null);
		} else {
			if (!user.getPassword().equals(this.passwordConfirmation)) {
		        facesMessages.addToControl("passwordConfirmation", "Passwords don't match; please confirm your password again");
				this.passwordConfirmation = null;
				return null;
			}
			EntityManager entityManager = getEntityManager();
			Role role = 
				(Role) entityManager.createQuery("from Role r where r.name = :roleName")
				.setParameter("roleName", "user").getSingleResult();
			Collection<UserRole> userRoleCollection = user.getUserRoleCollection();
			if (userRoleCollection == null) {
				userRoleCollection = new HashSet<UserRole>(1);
				user.setUserRoleCollection(userRoleCollection);
			}
			UserRole userRole = new UserRole();
			userRole.setUser(user);
			userRole.setRole(role);
			userRoleCollection.add(userRole);
		}
		return super.persist();
	}
    
    
 	
}
