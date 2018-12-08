package com.dotridge.beans;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(c.equals(LoginBean.class)){
			flag=true;
		}

		return flag;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		LoginBean lb = (LoginBean) target;
		String userId=lb.getUserId();
		//String password=lb.getPassword();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId","field.required.loginBean.userId","UserId Required");
		if(userId!=null && userId.length()<4)

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","field.required.loginBean.password","password Required");
		//if(password!=null && password.length()<4)

		errors.rejectValue("userId", "field.minlength.loginBean.userId",new Object[] { lb.getUserId() }, "UserId should be minimum 4 characters");
		errors.rejectValue("userId", "field.maxlength.loginBean.userId",new Object[] { lb.getUserId() }, " UserId should be max 9 characters");

		//errors.rejectValue("password", "field.minlength.loginBean.password",new Object[] { lb.getUserId() }, "password Required");
		//errors.rejectValue("password", "field.maxlength.loginBean.password",new Object[] { lb.getUserId() }, "password Required");

	}

}
