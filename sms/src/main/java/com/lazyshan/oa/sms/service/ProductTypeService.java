package com.lazyshan.oa.sms.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lazyshan.oa.sms.dao.ProductTypeDao;
import com.lazyshan.oa.sms.models.ProductType;

/**
 * 商品类别的服务类
 * @author skyvan
 *
 */
@Service
public class ProductTypeService extends BaseService {
	@Resource
	private ProductTypeDao productTypeDao;
	@Transactional(Transactional.TxType.SUPPORTS)
	public List<ProductType> nestedListAllProductType(){
		return productTypeDao.nestedListAllProductType();
	}
}
