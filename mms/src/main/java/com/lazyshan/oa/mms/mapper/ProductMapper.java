package com.lazyshan.oa.mms.mapper;

import com.lazyshan.oa.mms.model.Product;

public interface ProductMapper {
	/**
	 * 添加一个产品
	 * 
	 * @param product
	 */
	public void addProduct(Product product);

	/**
	 * 删除一个产品
	 * 
	 * @param productModel
	 */
	public void removeProduct(String productModel);

	/**
	 * 更新一个产品
	 * 
	 * @param product
	 */
	public void updateProduct(Product product);
}
