package com.lazyshan.oa.sms.dao;

import java.util.List;

import com.lazyshan.oa.sms.models.ProductType;

public interface ProductTypeDao {
	/**
	 * 嵌套独处所有产品类别
	 * 
	 * @return
	 */
	public List<ProductType> nestedListAllProductType();
}
