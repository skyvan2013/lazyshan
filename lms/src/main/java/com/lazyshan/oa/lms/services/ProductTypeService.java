package com.lazyshan.oa.lms.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lazyshan.oa.lms.common.Pager;
import com.lazyshan.oa.lms.dao.ProductTypeDAO;
import com.lazyshan.oa.lms.model.ProductType;

@Service
public class ProductTypeService {
	@Resource
	ProductTypeDAO productTypeDAO;

	public void listProductType(Pager<ProductType> pager) {
		pager.setPage(1);
		pager.setTotal(100);
		pager.setResult(productTypeDAO.findAll());
	}

	public ProductType getSingleProductType(Short productTypeId) {
		return null;
	}

	public void saveOrUpdateProductType(ProductType productType) {

	}

	public boolean deleteProductTypes(int[] pts) {
		return true;
	}
}
