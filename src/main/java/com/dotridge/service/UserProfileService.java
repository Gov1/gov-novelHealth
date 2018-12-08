package com.dotridge.service;

import org.springframework.stereotype.Service;

import com.dotridge.beans.UserProfileBean;
import com.dotridge.domain.UserProfile;
public interface UserProfileService {
public UserProfile mapBeanToDomain(UserProfileBean userProfileBean);
	
	public UserProfileBean mapDomainToBean(UserProfile userProfile);
	
	public UserProfileBean createUserProfile(UserProfileBean userProfileBean);
}
