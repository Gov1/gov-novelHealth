package com.dotridge.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.Roles;
@Repository
public class RolesDaoImpl implements RolesDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Roles createRoles(Roles roleDomain) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Roles roles=new Roles();
		roles.setRoleId(1);
		roles.setRoleName("superadmin");
		session.save(roles);
		session.getTransaction().commit();
		
		return roleDomain;
	}

	@Override
	public List<Roles> getAllRoles() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String hql="from Roles ";
		Query qry=session.createQuery(hql);
		List<Roles> roles = qry.list();
		return roles;
	}

	@Override
	public Roles byName(String name) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String hql="from Roles r where r.roleName=:rolename";
		Query query=session.createQuery(hql);
		query.setParameter("rolename", name);
		Roles roleName=(Roles) query.uniqueResult();

		return roleName;
	}

}
