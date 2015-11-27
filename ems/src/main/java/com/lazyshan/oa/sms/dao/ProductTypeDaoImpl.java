package com.lazyshan.oa.sms.dao;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lazyshan.oa.sms.models.ProductType;

@Repository
@SuppressWarnings("unchecked")
public class ProductTypeDaoImpl extends BaseDaoImpl<ProductType> implements ProductTypeDao {

	public List<ProductType> nestedListAllProductType() {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		dc.setFetchMode("subTypes", FetchMode.SELECT);
		dc.add(Restrictions.isNull("parentType"));
		dc.addOrder(Order.asc("orderValue"));
		List<ProductType> productTypes = (List<ProductType>) findByCriteria(dc);
		for(ProductType pt : productTypes){//init subtypes
			for(ProductType spt : pt.getSubTypes()){
				initialize(spt);
			}
		}
		return productTypes;
	}

}
