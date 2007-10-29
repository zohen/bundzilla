package com.bundzilla.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

@Name("userRoleList")
public class UserRoleList extends EntityQuery
{
    @Override
    public String getEjbql() 
    { 
        return "select userRole from UserRole userRole";
    }
}
