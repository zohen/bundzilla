package com.bundzilla.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

@Name("projectList")
public class ProjectList extends EntityQuery
{
    @Override
    public String getEjbql() 
    { 
        return "select project, role from ProjectUserRole pur, ProjectRole role, Project proj, User user " 
        	+ "where user.name=#{identity.username} and pur.user = user.name" 
        	+ " and role.projectUserRole = pur.id and project.id = pur.project";
    }

}
