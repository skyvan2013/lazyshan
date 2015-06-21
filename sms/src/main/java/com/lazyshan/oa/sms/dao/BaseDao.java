package com.lazyshan.oa.sms.dao;

import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class BaseDao<T> extends HibernateDaoSupport {
	protected Class<T> entityClass;
	{
		entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T get(String id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	@PostConstruct
	private void injectSessionFactory() {

	}

	@Resource
	private void injectSessionFactory(SessionFactory sesssionFactory) {
		super.setSessionFactory(sesssionFactory);
	}
}
