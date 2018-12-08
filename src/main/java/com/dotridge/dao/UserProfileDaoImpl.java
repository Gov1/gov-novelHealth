package com.dotridge.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.UserProfile;
import com.dotridge.util.SessionFactoryUtil;
@Repository
public class UserProfileDaoImpl implements UserProfileDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public UserProfile createUserProfile(UserProfile userProfile) {
		// TODO Auto-generated method stub
		System.out.println("dao reached");
		//SessionFactory sessionFactory = SessionFactoryUtil.getfactory();
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(userProfile);
		tx.commit();
		session.close();
		return userProfile;
	}

}
