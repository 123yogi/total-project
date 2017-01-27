package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO1")
public class UserDAOImplOne implements UserDAO1
{
	@Autowired
	private SessionFactory sessionFactory;


	public UserDAOImplOne(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) 
		{
						e.printStackTrace();
		}
	}
@Transactional
	public void save(UserRoles userRoles) 
	{
	Session session=sessionFactory.openSession();
	org.hibernate.Transaction tx=session.beginTransaction();
	session.save(userRoles);
	tx.commit();
	session.close();
			
		
		
	}

}
