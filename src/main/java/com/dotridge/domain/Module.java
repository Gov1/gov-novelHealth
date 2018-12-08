package com.dotridge.domain;

import java.io.Serializable;
import java.util.List;


public class Module implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int moduleId;
	private String moduleName;
	private List<Permissions> permissionlist;
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
	public List<Permissions> getPermissionlist() {
		return permissionlist;
	}
	public void setPermissionlist(List<Permissions> permissionlist) {
		this.permissionlist = permissionlist;
	}
}
