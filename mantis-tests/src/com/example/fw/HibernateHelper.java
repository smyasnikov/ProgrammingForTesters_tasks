package com.example.fw;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateHelper extends HelperBase {

	public HibernateHelper(ApplicationManager manager) {
	  super(manager);
	}

	public String getUserId(String login) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		return session.createQuery("select id from User where login=?")
				.setParameter(0, login).uniqueResult().toString();
	}

}
