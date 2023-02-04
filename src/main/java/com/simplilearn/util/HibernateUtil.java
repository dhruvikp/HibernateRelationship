package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.JavaStudent;
import com.simplilearn.entity.PhoneNumbers;

public class HibernateUtil {

	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory buildSessionFactory() {
		if(sessionFactory==null) {
			Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(JavaStudent.class).addAnnotatedClass(PhoneNumbers.class);
			
			sessionFactory = config.buildSessionFactory();
			
		}
		return sessionFactory;
}
}