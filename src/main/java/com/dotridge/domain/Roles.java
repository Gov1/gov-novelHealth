package com.dotridge.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="roles")
public class Roles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleId;
	@Column
	private String roleName;
	/*@OneToMany
	private List<Module> moduleList;*/
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/*public List<Module> getModuleList() {
		return moduleList;
	}
	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}*/

}
