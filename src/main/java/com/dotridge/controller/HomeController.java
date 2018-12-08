/**
 * 
 */
package com.dotridge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dotridge.beans.LoginBean;
import com.dotridge.beans.LoginValidator;
import com.dotridge.beans.RolesBean;
import com.dotridge.beans.UserProfileBean;
import com.dotridge.service.RoleService;
import com.dotridge.service.UserProfileService;

/**
 * @author ALWAR
 *
 */
@Controller
public class HomeController {
	@Autowired
	public LoginValidator loginValidator;
	@Autowired
	private UserProfileService userService;
	@Autowired
	private RoleService roleService;
	
	
	/*@InitBinder
	 public void initBinder(WebDataBinder binder) {
	  binder.setValidator(loginValidator);
	 }*/
	
	@RequestMapping(value = "/home")
	public String getHomePage() {
		return "home";
	}
	@RequestMapping(value="/windowLogin")
	 public String windowLogin(HttpServletRequest request){
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		  String userName=authentication.getName();
	  System.out.println(userName);
	  if (userName != null & !userName.isEmpty()) {
	   if (userName.equalsIgnoreCase("superadmin@gmail.com")) {
	    return "getSuperAdminBoard";
	   } else if (userName.equalsIgnoreCase("admin@email.com")) {
	    System.out.println("enter into admin");
	    return "getAdminPatientBoard";
	   }
	  }
	  return "home"; 
	 }
	@RequestMapping(value="/formLogin")
	 public String formLogin(HttpServletRequest request){
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		  String userName=authentication.getName();
	  System.out.println(userName);
	  if (userName != null & !userName.isEmpty()) {
	   if (userName.equalsIgnoreCase("Hema")) {
	    return "getSuperAdminBoard";
	   } else if (userName.equalsIgnoreCase("admin@email.com")) {
	    System.out.println("enter into admin");
	    return "getAdminPatientBoard";
	   }
	  }
	  return "home"; 
	 }

	@RequestMapping("/getLoginPage")
	public String getLoginPage(Model model) {
		model.addAttribute("loginBean", new LoginBean());
		return "login";

	}
	@RequestMapping(value = "/login")
	public String doLoginPage(@Valid @ModelAttribute("loginBean") LoginBean loginBean,BindingResult result) {
		String username = loginBean.getUserId();
		  if(result.hasErrors()){
		   List<FieldError> errorList = result.getFieldErrors();
		   for(FieldError fieldError : errorList){
				System.out.println("error\t"+fieldError);
			   
		   }
		   return "login";
		  }
		boolean result1 = (username != null && username
				.equalsIgnoreCase("superadmin@gmail.com")) ? true : false;
	
		if (result1) {
			return "getSuperAdminBoard";
		}
		else 
			return "login";
	}

	@RequestMapping(value = "/getSignUpPage")
	public String getSignupPage(Model model) {
		model.addAttribute("UserProfileBean", new UserProfileBean());
		List<RolesBean> roles=roleService.getAllRoles();
		List<String> rBeans=new ArrayList<String>();
		for(RolesBean roleBeans: roles){
			if(roleBeans.getRoleName().equalsIgnoreCase("superadmin")){
				continue;
				
			}
			rBeans.add(roleBeans.getRoleName());
		}
	
		model.addAttribute("roleBeans", rBeans);
		return "register";
	}

	@RequestMapping(value = "/register")
	public String doSignUpPage(
			@ModelAttribute("UserProfileBean") UserProfileBean userProfileBean) {
		System.out.println("User profile Controller");
		UserProfileBean userbean=userService.createUserProfile(userProfileBean);
		System.out.println(userbean.toString());
		return "home";
	}
}
