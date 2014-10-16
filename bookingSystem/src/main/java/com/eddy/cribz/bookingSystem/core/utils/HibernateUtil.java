package com.eddy.cribz.bookingSystem.core.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.googlecode.genericdao.search.hibernate.HibernateMetadataUtil;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static HibernateMetadataUtil metadataUtil;

	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml)
			// config file.
			sessionFactory = new AnnotationConfiguration().configure()
					.buildSessionFactory();
			// metadataUtil =
			// HibernateMetadataUtil.getInstanceForSessionFactory(sessionFactory);
		} catch (Throwable ex) {
			// Log the exception.
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session beginTransaction() {
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();

		return hibernateSession;
	}

	public static void closeSession() {
		HibernateUtil.getSession().close();
	}

	public static void commitTransaction() {
		HibernateUtil.getSession().getTransaction().commit();
	}

	public static Session getSession() {
		Session hibernateSession = sessionFactory.getCurrentSession();
		return hibernateSession;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void rollbackTransaction() {
		HibernateUtil.getSession().getTransaction().rollback();
	}

	/**
	 * @return the metadataUtil
	 */
	public static HibernateMetadataUtil getMetadataUtil() {
		return metadataUtil;
	}

	/**
	 * @param metadataUtil
	 *            the metadataUtil to set
	 */
	public static void setMetadataUtil(HibernateMetadataUtil metadataUtil) {
		HibernateUtil.metadataUtil = metadataUtil;
	}
}