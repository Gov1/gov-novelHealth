package com.dotridge.beans;

import java.io.Serializable;

public class PermissionsBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int permId;
	private String permName;
	public int getPermId() {
		return permId;
	}
	public void setPermId(int permId) {
		this.permId = permId;
	}
	public String getPermName() {
		return permName;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}

}
