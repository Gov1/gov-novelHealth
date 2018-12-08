package com.dotridge.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dotridge.domain.Hospital;
import com.dotridge.util.SessionFactoryUtil;

public class FirstLevelCache { 
	public static void main(String args[]){
		getHospitalById();
	}
	
	public static void getHospitalById(){
		// TODO Auto-generated method stub
		
		
		SessionFactory sessionFactory=SessionFactoryUtil.getfactory();
		Session session=sessionFactory.openSession();
		//Hospital hosp=(Hospital)session.get(Hospital.class, 2);
		Query createQuery = session.createQuery("from Hospital");
		createQuery.setCacheable(true);
		createQuery.list();
		
		session.close();
		Session session2=sessionFactory.openSession();
		//Hospital hosp1=(Hospital)session2.get(Hospital.class, 2);
		Query createQuery1 = session2.createQuery("from Hospital");
		createQuery1.setCacheable(true);
		createQuery1.list();

		session2.close();
		//System.out.println(hosp);
		//System.out.println(hosp1);

		
		
	}

}
