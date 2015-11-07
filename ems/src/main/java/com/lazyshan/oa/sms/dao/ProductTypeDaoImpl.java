package com.lazyshan.oa.sms.dao;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.lazyshan.oa.sms.models.ProductType;

@Repository
@SuppressWarnings("unchecked")
public class ProductTypeDaoImpl extends BaseDao<ProductType> implements ProductTypeDao {

	public List<ProductType> nestedListAllProductType() {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		dc.add(Restrictions.eq("typeLevel", 1));
		dc.setFetchMode("productType", FetchMode.DEFAULT);
		List<ProductType> productTypes = (List<ProductType>) getHibernateTemplate().findByCriteria(dc);
		return productTypes;
	}
}
