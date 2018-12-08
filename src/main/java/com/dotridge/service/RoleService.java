package com.dotridge.service;

import java.util.List;

import com.dotridge.beans.RolesBean;
import com.dotridge.domain.Roles;

public interface RoleService {

	public List<RolesBean> getAllRoles();
public Roles mapBeanToDomain(RolesBean rolesBean);
	
	public RolesBean mapDomainToBean(Roles roleDomain);
	

}
