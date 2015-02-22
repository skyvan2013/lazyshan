package com.lazyshan.oa.mms.services;

import java.util.List;

import com.lazyshan.oa.mms.common.Pager;
import com.lazyshan.oa.mms.model.Product;
import com.lazyshan.oa.mms.model.ProductType;

public interface ProductTypeService {

	/**
	 * 列出所有产品类别
	 * 
	 * @return
	 */
	public List<ProductType> listProductType(Pager<ProductType> pager);

	/**
	 * 添加一个产品类别
	 * 
	 * @param pt
	 * @return
	 */
	public boolean saveOrUpdateProductType(ProductType pt);

	/**
	 * 取得一个产品类别
	 * 
	 * @param productType
	 * @return
	 */
	public ProductType getSingleProductType(Integer productType);

	/**
	 * 删除产品类别
	 * 
	 * @param productTypes
	 * @return
	 */
	public boolean deleteProductTypes(int[] productTypes);
}