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
	/**
	 * 插入一个产品类别数据
	 * @param pt
	 * @return
	 */
	public boolean addProductType(ProductType pt);
	
	/**
	 * 更新一个产品类别数据
	 * @param pt
	 * @return
	 */
	public boolean updateProductType(ProductType pt);
	
	/**
	 * 取得一个商品
	 * @param productType
	 * @return
	 */
	public ProductType getSingleProductType(Integer productType);
	/**
	 * 删除商品类别
	 * @param ProductTypes
	 * @return
	 */
	public boolean deleteProductTypes(int[] productTypes);
}
