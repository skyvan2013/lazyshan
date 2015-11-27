package com.lazyshan.oa.sms.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Filter;
import org.hibernate.LockMode;
import org.hibernate.ReplicationMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	private HibernateTemplate hibernateTemplate;

	@Override
	public <T> T execute(HibernateCallback<T> action) throws DataAccessException {
		return hibernateTemplate.execute(action);
	}

	@Override
	public <T> T get(Class<T> entityClass, Serializable id) throws DataAccessException {
		return hibernateTemplate.get(entityClass, id);
	}

	@Override
	public <T> T get(Class<T> entityClass, Serializable id, LockMode lockMode) throws DataAccessException {
		return hibernateTemplate.get(entityClass, id, lockMode);
	}

	@Override
	public Object get(String entityName, Serializable id) throws DataAccessException {
		return hibernateTemplate.get(entityName, id);
	}

	@Override
	public Object get(String entityName, Serializable id, LockMode lockMode) throws DataAccessException {
		return hibernateTemplate.get(entityName, id, lockMode);
	}

	@Override
	public <T> T load(Class<T> entityClass, Serializable id) throws DataAccessException {
		return hibernateTemplate.load(entityClass, id);
	}

	@Override
	public <T> T load(Class<T> entityClass, Serializable id, LockMode lockMode) throws DataAccessException {
		return hibernateTemplate.load(entityClass, id, lockMode);
	}

	@Override
	public Object load(String entityName, Serializable id) throws DataAccessException {
		return hibernateTemplate.load(entityName, id);
	}

	@Override
	public Object load(String entityName, Serializable id, LockMode lockMode) throws DataAccessException {
		return hibernateTemplate.load(entityName, id, lockMode);
	}

	@Override
	public <T> List<T> loadAll(Class<T> entityClass) throws DataAccessException {
		return hibernateTemplate.loadAll(entityClass);
	}

	@Override
	public void load(Object entity, Serializable id) throws DataAccessException {
		hibernateTemplate.load(entityClass, id);
	}

	@Override
	public void refresh(Object entity) throws DataAccessException {
		hibernateTemplate.refresh(entity);
	}

	@Override
	public void refresh(Object entity, LockMode lockMode) throws DataAccessException {
		hibernateTemplate.refresh(entity, lockMode);
	}

	@Override
	public boolean contains(Object entity) throws DataAccessException {
		hibernateTemplate.contains(entity);
		return false;
	}

	@Override
	public void evict(Object entity) throws DataAccessException {
		hibernateTemplate.evict(entity);
	}

	@Override
	public void initialize(Object proxy) throws DataAccessException {
		hibernateTemplate.initialize(proxy);
	}

	@Override
	public Filter enableFilter(String filterName) throws IllegalStateException {
		return hibernateTemplate.enableFilter(filterName);
	}

	@Override
	public void lock(Object entity, LockMode lockMode) throws DataAccessException {
		hibernateTemplate.lock(entity, lockMode);
	}

	@Override
	public void lock(String entityName, Object entity, LockMode lockMode) throws DataAccessException {
		hibernateTemplate.lock(entityName, entity, lockMode);
	}

	@Override
	public Serializable save(Object entity) throws DataAccessException {
		return hibernateTemplate.save(entity);
	}

	@Override
	public Serializable save(String entityName, Object entity) throws DataAccessException {
		return hibernateTemplate.save(entityName, entity);
	}

	@Override
	public void update(Object entity) throws DataAccessException {
		hibernateTemplate.update(entity);
	}

	@Override
	public void update(Object entity, LockMode lockMode) throws DataAccessException {
		hibernateTemplate.update(entity, lockMode);
	}

	@Override
	public void update(String entityName, Object entity) throws DataAccessException {
		hibernateTemplate.update(entityName, entity);
	}

	@Override
	public void update(String entityName, Object entity, LockMode lockMode) throws DataAccessException {
		hibernateTemplate.update(entityName, entity, lockMode);
	}

	@Override
	public void saveOrUpdate(Object entity) throws DataAccessException {
		hibernateTemplate.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdate(String entityName, Object entity) throws DataAccessException {
		hibernateTemplate.saveOrUpdate(entityName, entity);
	}

	@Override
	public void replicate(Object entity, ReplicationMode replicationMode) throws DataAccessException {
		hibernateTemplate.replicate(entity, replicationMode);
	}

	@Override
	public void replicate(String entityName, Object entity, ReplicationMode replicationMode) throws DataAccessException {
		hibernateTemplate.replicate(entityName, entity, replicationMode);
	}

	@Override
	public void persist(Object entity) throws DataAccessException {
		hibernateTemplate.persist(entity);
	}

	@Override
	public void persist(String entityName, Object entity) throws DataAccessException {
		hibernateTemplate.persist(entityName, entity);
	}

	@Override
	public <T> T merge(T entity) throws DataAccessException {
		return hibernateTemplate.merge(entity);
	}

	@Override
	public <T> T merge(String entityName, T entity) throws DataAccessException {
		return hibernateTemplate.merge(entityName, entity);
	}

	@Override
	public void delete(Object entity) throws DataAccessException {
		hibernateTemplate.delete(entity);
	}

	@Override
	public void delete(Object entity, LockMode lockMode) throws DataAccessException {
		hibernateTemplate.delete(entity, lockMode);
	}

	@Override
	public void delete(String entityName, Object entity) throws DataAccessException {
		hibernateTemplate.delete(entityName, entity);
	}

	@Override
	public void delete(String entityName, Object entity, LockMode lockMode) throws DataAccessException {
		hibernateTemplate.delete(entityName, entity, lockMode);
	}

	@Override
	public void deleteAll(Collection<?> entities) throws DataAccessException {
		hibernateTemplate.deleteAll(entities);
	}

	@Override
	public void flush() throws DataAccessException {
		hibernateTemplate.flush();
	}

	@Override
	public void clear() throws DataAccessException {
		hibernateTemplate.clear();
	}

	@Override
	public List<?> find(String queryString, Object... values) throws DataAccessException {
		return hibernateTemplate.find(queryString, values);
	}

	@Override
	public List<?> findByNamedParam(String queryString, String paramName, Object value) throws DataAccessException {
		return hibernateTemplate.findByNamedParam(queryString, paramName, value);
	}

	@Override
	public List<?> findByNamedParam(String queryString, String[] paramNames, Object[] values) throws DataAccessException {
		return hibernateTemplate.findByNamedParam(queryString, paramNames, values);
	}

	@Override
	public List<?> findByValueBean(String queryString, Object valueBean) throws DataAccessException {
		return hibernateTemplate.findByValueBean(queryString, valueBean);
	}

	@Override
	public List<?> findByNamedQuery(String queryName, Object... values) throws DataAccessException {
		return hibernateTemplate.findByNamedQuery(queryName, values);
	}

	@Override
	public List<?> findByNamedQueryAndNamedParam(String queryName, String paramName, Object value) throws DataAccessException {
		return hibernateTemplate.findByNamedQueryAndNamedParam(queryName, paramName, value);
	}

	@Override
	public List<?> findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values) throws DataAccessException {
		return hibernateTemplate.findByNamedQueryAndNamedParam(queryName, paramNames, values);
	}

	@Override
	public List<?> findByNamedQueryAndValueBean(String queryName, Object valueBean) throws DataAccessException {
		return hibernateTemplate.findByNamedQueryAndValueBean(queryName, valueBean);
	}

	@Override
	public List<?> findByCriteria(DetachedCriteria criteria) throws DataAccessException {
		return hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<?> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) throws DataAccessException {
		return hibernateTemplate.findByCriteria(criteria, firstResult, maxResults);
	}

	@Override
	public <T> List<T> findByExample(T exampleEntity) throws DataAccessException {
		return hibernateTemplate.findByExample(exampleEntity);
	}

	@Override
	public <T> List<T> findByExample(String entityName, T exampleEntity) throws DataAccessException {
		return hibernateTemplate.findByExample(entityName, exampleEntity);
	}

	@Override
	public <T> List<T> findByExample(T exampleEntity, int firstResult, int maxResults) throws DataAccessException {
		return hibernateTemplate.findByExample(exampleEntity, firstResult, maxResults);
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> List<T> findByExample(String entityName, T exampleEntity, int firstResult, int maxResults) throws DataAccessException {
		return hibernateTemplate.findByExample(entityName, exampleEntity, firstResult, maxResults);
	}

	@Override
	public Iterator<?> iterate(String queryString, Object... values) throws DataAccessException {
		return hibernateTemplate.iterate(queryString, values);
	}

	@Override
	public void closeIterator(Iterator<?> it) throws DataAccessException {
		hibernateTemplate.closeIterator(it);
	}

	@Override
	public int bulkUpdate(String queryString, Object... values) throws DataAccessException {
		return hibernateTemplate.bulkUpdate(queryString, values);
	}

	protected Class<T> entityClass;
	{
		entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
