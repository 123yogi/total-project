package com.controller;

import java.util.List;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ChairDao
{
	@Autowired
    private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void addChair(Chair chair){
		Session session=sessionFactory.openSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		session.saveOrUpdate(chair);
		tx.commit();		
	}
	@Transactional
	public int updateChair(Chair chair) 
	 {
		Session session=sessionFactory.openSession();
		System.out.println("hello");
		org.hibernate.Transaction tx=session.beginTransaction();
		System.out.println("hai");
		System.out.println(chair.chairId);
		System.out.println(chair.chairName);
		System.out.println(chair.chairPrice);
		session.update(chair);
		//session.flush();
		System.out.println("bi,,,,,,,,,,,,,,,,,,,,");
		//session.close();
		tx.commit();
		return 0;
		}
	@Transactional
	public List getAllChairs(){
	Session session=sessionFactory.openSession();
	List blist=session.createQuery("from Chair").list();
	session.close();
	return blist;
}
	@Transactional
public Chair getSingleChair(int id){
	Session session=sessionFactory.openSession();
	Chair chair=(Chair)session.load(Chair.class, id);
	return chair;
}

public int deleteChair(int id){
	Session session=sessionFactory.openSession();
	org.hibernate.Transaction tx=session.beginTransaction();
	Chair chair=(Chair)session.load(Chair.class, id);
	session.delete(chair);
	tx.commit();
	
	session.close();
	return id;
	
}

}

