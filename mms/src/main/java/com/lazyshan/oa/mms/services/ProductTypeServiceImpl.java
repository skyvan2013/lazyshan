package com.lazyshan.oa.mms.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lazyshan.oa.mms.common.Pager;
import com.lazyshan.oa.mms.mapper.ProductTypeMapper;
import com.lazyshan.oa.mms.model.ProductType;

@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {
	@Resource
	private ProductTypeMapper productTypeMapper;

	public List<ProductType> listProductType(Pager<ProductType> pager) {
		return productTypeMapper.listProductTypes(pager);
	}
}
