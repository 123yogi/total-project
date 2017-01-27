package com.controller;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("userDAO")
public class UserDAOImpl implements UserDAO
{
	 
	@Autowired
	private SessionFactory sessionFactory;


	public UserDAOImpl(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) 
		{
						e.printStackTrace();
		}
	}

	@Transactional
	public void saveorUpdate(User user) 
	{
		Session session=sessionFactory.openSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		session.close();
				
	}
	

	}
