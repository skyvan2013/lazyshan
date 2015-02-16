package com.lazyshan.oa.mms.mapper;

import java.util.List;

import com.lazyshan.oa.mms.common.Pager;
import com.lazyshan.oa.mms.model.ProductType;

public interface ProductTypeMapper {
	/**
	 * 列出所有产品分类
	 * 
	 * @return
	 */
	public List<ProductType> listProductTypes(Pager<ProductType> pager );
}
