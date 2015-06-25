package com.lazyshan.oa.sms.dao;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lazyshan.oa.sms.models.ProductType;

@Repository
public class ProductTypeDaoImpl extends BaseDao<ProductType> implements ProductTypeDao {

	public List<ProductType> nestedListAllProductType() {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		dc.add(Restrictions.eq("typeLevel", 1));
		dc.setFetchMode("productTypes", FetchMode.JOIN);
		return (List<ProductType>) getHibernateTemplate().findByCriteria(dc);
	}
}
