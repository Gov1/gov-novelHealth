package com.dotridge.config;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	@Autowired
	private SessionFactory sessionFactory;
	 private static final String QUARY="select up.userid,up.password,r.rolename,m.modulename from dotridge.userprofile up,dotridge.roles r,dotridge.module m where m.moduleid=r.moduleid and r.roleid=up.roleid and up.userid=";
	 
	 
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		String username=authentication.getName();
		String password=(String) authentication.getCredentials();
		Session session=sessionFactory.openSession(); 
		SQLQuery qry=session.createSQLQuery(QUARY+"\'"+username+"\' ");
		List<Object[]> list = qry.list();
		  Object[] array = list.get(0);
		  String role = (String) array[2];
		  String permission = (String)array[3];
		   GrantedAuthority roleauth = new SimpleGrantedAuthority(role);
		   GrantedAuthority permauth = new SimpleGrantedAuthority(permission);
		  List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		  authorities.add(roleauth);
		  authorities.add(permauth);
		  return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
