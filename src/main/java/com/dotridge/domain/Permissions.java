package com.dotridge.domain;

import java.io.Serializable;

public class Permissions implements Serializable{
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
