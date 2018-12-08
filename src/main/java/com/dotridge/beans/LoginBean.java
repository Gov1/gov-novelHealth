package com.dotridge.beans;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



public class LoginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3474374178412947681L;
	/*@NotEmpty(message="please enter userId")
	@Min(value=4,message="userId should be minimun of 4 characters")*/
	@NotEmpty(message="please enter userId")
	@Size(min=4,max=20)
	private String userId;
	@Override
	public String toString() {
		return "LoginBean [userId=" + userId + ", password=" + password + "]";
	}
	@NotEmpty(message="Password can not be null")
	@Size(min=4,max=20)
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
