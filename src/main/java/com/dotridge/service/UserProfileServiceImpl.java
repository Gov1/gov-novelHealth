package com.dotridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.beans.UserProfileBean;
import com.dotridge.dao.RolesDao;
import com.dotridge.dao.UserProfileDao;
import com.dotridge.domain.Roles;
import com.dotridge.domain.UserProfile;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	@Autowired
	private UserProfileDao userProfileDao;
	@Autowired
	private RolesDao roleDao;

	@Override
	public UserProfile mapBeanToDomain(UserProfileBean userProfileBean) {
		// TODO Auto-generated method stub
		UserProfile userProfile = new UserProfile();
		userProfile.setFirstName(userProfileBean.getFirstName());
		userProfile.setLastName(userProfileBean.getLastName());
		userProfile.setUserId(userProfileBean.getUserId());
		userProfile.setPassword(userProfileBean.getPassword());
		userProfile.setConfirmPassword(userProfileBean.getConfirmPassword());
		userProfile.setEmail(userProfileBean.getEmail());
		userProfile.setPhoneno(userProfileBean.getPhoneno());
		userProfile.setRoles(roleDao.byName(userProfileBean.getRoleBean()));

		return userProfile;
	}

	@Override
	public UserProfileBean mapDomainToBean(UserProfile userProfile) {
		// TODO Auto-generated method stub
		UserProfileBean userProfileBean = new UserProfileBean();
		userProfileBean.setFirstName(userProfile.getFirstName());
		userProfileBean.setLastName(userProfile.getLastName());
		userProfileBean.setUserId(userProfile.getUserId());
		userProfileBean.setPassword(userProfile.getPassword());
		userProfileBean.setConfirmPassword(userProfile.getConfirmPassword());
		userProfileBean.setEmail(userProfile.getEmail());
		userProfileBean.setPhoneno(userProfile.getPhoneno());
		Roles role = userProfile.getRoles();
		userProfileBean.setRoleBean(role.getRoleName());
		return userProfileBean;
	}

	@Override
	public UserProfileBean createUserProfile(UserProfileBean userProfileBean) {
		System.out.println("service reached");
		// TODO Auto-generated method stub
		UserProfile userDomain = mapBeanToDomain(userProfileBean);
		userProfileBean = mapDomainToBean(userProfileDao
				.createUserProfile(userDomain));
		System.out.println("service user profile:"+userProfileBean);
		return userProfileBean;
	}

}
