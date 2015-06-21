package com.lazyshan.oa.sms.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.lazyshan.oa.sms.models.ProductType;

@Repository
public class ProductTypeDao extends BaseDao<ProductType>{
	public List<ProductType> list(){
		return getHibernateTemplate().loadAll(entityClass);
	}
}
