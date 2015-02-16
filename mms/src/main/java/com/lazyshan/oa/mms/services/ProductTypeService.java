package com.lazyshan.oa.mms.services;

import java.util.List;

import com.lazyshan.oa.mms.common.Pager;
import com.lazyshan.oa.mms.model.ProductType;

public interface ProductTypeService {

	/**
	 * 列出所有产品类别
	 * @return
	 */
	public List<ProductType> listProductType(Pager<ProductType> pager);

}