package com.dotridge.beans;

import java.util.List;

import javax.persistence.OneToMany;

public class ModuleBean {

	private int moduleId;
	private String moduleName;
	
	private PermissionsBean permissionBean;
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public PermissionsBean getPermissionBean() {
		return permissionBean;
	}
	public void setPermissionBean(PermissionsBean permissionBean) {
		this.permissionBean = permissionBean;
	}
	
}
