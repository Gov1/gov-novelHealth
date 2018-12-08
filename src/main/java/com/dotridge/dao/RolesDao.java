package com.dotridge.dao;

import java.util.List;

import com.dotridge.domain.Roles;

public interface RolesDao {

	public Roles createRoles(Roles roleDomain);
	public List<Roles> getAllRoles();
	public Roles byName(String name);
	}
