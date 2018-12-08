package com.dotridge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dotridge.beans.RolesBean;
import com.dotridge.dao.RolesDao;
import com.dotridge.domain.Roles;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RolesDao rolesDao;

	@Override
	public List<RolesBean> getAllRoles() {
		// TODO Auto-generated method stub
		List<Roles> roles=rolesDao.getAllRoles();
		List<RolesBean> rolesBean = null;
		if (roles != null && !roles.isEmpty()) 
		{
			rolesBean = new ArrayList<RolesBean>();
			for (Roles role : roles) 
			{

				
				
				rolesBean.add(mapDomainToBean(role));
			}
		}

		return rolesBean;
	}

	@Override
	public Roles mapBeanToDomain(RolesBean rolesBean) {
		// TODO Auto-generated method stub
		Roles roles=new Roles();
		roles.setRoleId(rolesBean.getRoleId());
		roles.setRoleName(rolesBean.getRoleName());
		
		return roles;
	}

	@Override
	public RolesBean mapDomainToBean(Roles roleDomain) {
		// TODO Auto-generated method stub
		
		RolesBean rolesBean=new RolesBean();
		rolesBean.setRoleId(roleDomain.getRoleId());
		rolesBean.setRoleName(roleDomain.getRoleName());
		return rolesBean;
	}

}
