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

	@Override
	public ProductType getSingleProductType(Integer productType) {
		return productTypeMapper.getSingleProductType(productType);
	}

	@Override
	public boolean saveOrUpdateProductType(ProductType pt) {
		if(pt.getProductType() != null &&  pt.getProductType()>0){
			return productTypeMapper.updateProductType(pt);
		}else {
			return productTypeMapper.addProductType(pt);
		}
	}

	@Override
	public boolean deleteProductTypes(int[] productTypes) {
		return productTypeMapper.deleteProductTypes(productTypes);
	}
}
