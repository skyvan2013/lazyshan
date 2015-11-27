package com.lazyshan.oa.sms.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.lazyshan.oa.sms.dao.ProductTypeDao;
import com.lazyshan.oa.sms.models.ProductType;

/**
 * 商品类别的服务类
 * 
 * @author skyvan 存在自身1对多的情况，必须在这里直接转化成字符串
 */
@Service
public class ProductTypeService extends BaseService {
	Log log = LogFactory.getLog(ProductTypeService.class);
	@Resource
	private ProductTypeDao productTypeDao;

	@Transactional(Transactional.TxType.SUPPORTS)
	public List<ProductType> nestedListAllProductType() {
		return productTypeDao.nestedListAllProductType();
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void updateTypes(List<ProductType> pts) {
		List<ProductType> persistedProductTypes = productTypeDao.loadAll(ProductType.class);
		Timestamp currentTime = new Timestamp(new Date().getTime());
		int order1 = 1;
		for (ProductType unpersisted : pts) {
			if (unpersisted.getId() == null) {
				unpersisted.setCreateTime(currentTime);
				unpersisted.setOrderValue(order1++);
				unpersisted.setParentType(null);
				Set<ProductType> set = new LinkedHashSet<ProductType>();
				if (unpersisted.getSubTypes().size() > 0) {
					Integer order = 1;
					for (ProductType subType : unpersisted.getSubTypes()) {
						ProductType hitProductType;
						if ((hitProductType=containProductType(persistedProductTypes, subType)) == null) {//子类别也是新增
							subType.setCreateTime(currentTime);
							subType.setOrderValue(order++);
							subType.setParentType(unpersisted);
							subType.setSubTypes(new HashSet<ProductType>());
							set.add(subType);
						}else{ //子类别已存在,更新对象
							hitProductType.setParentType(unpersisted);
							hitProductType.setTypeName(subType.getTypeName());
							hitProductType.setSubTypes(new HashSet<ProductType>());
							hitProductType.setOrderValue(order++);
							set.add(hitProductType);
						}
					}
				}
				unpersisted.setSubTypes(set);
				productTypeDao.save(unpersisted);
				log.info("类别【" + unpersisted.getTypeName() + "】是新类目，执行插入操作");				
			}else{ // 有id 有可能已经存在于数据库中
				ProductType persistedProductType = containProductType(persistedProductTypes, unpersisted);
				if(persistedProductType !=null){
					persistedProductType.setOrderValue(order1++);
					persistedProductType.setTypeName(unpersisted.getTypeName());
					persistedProductType.setParentType(null);
					Set<ProductType> set = new LinkedHashSet<ProductType>();
					if(unpersisted.getSubTypes().size()>0){
						Integer order = 1;
						for(ProductType subType : unpersisted.getSubTypes()){
							ProductType hitProductType;
							subType.setParentType(persistedProductType);
							if ((hitProductType=containProductType(persistedProductTypes, subType)) == null) {//子类别是新增
								subType.setCreateTime(currentTime);
								subType.setOrderValue(order++);
								subType.setSubTypes(new HashSet<ProductType>());
								set.add(subType);
							}else{ //子类别已存在,更新对象
								hitProductType.setParentType(persistedProductType);
								hitProductType.setTypeName(subType.getTypeName());
								hitProductType.setSubTypes(new HashSet<ProductType>());
								hitProductType.setOrderValue(order++);
								set.add(hitProductType);
							}
						}
					}
					persistedProductType.setSubTypes(set);
				}
			}
		}
System.out.println(1);
	}

	/**
	 * 
	 * @param pts
	 * @param pt
	 * @return pts中匹配的ProductType对象，null表示不存在pts中id相同的ProductType
	 */
	private ProductType containProductType(List<ProductType> pts, ProductType pt) {
		if (pt.getId() == null)
			return null;
		for (ProductType pt1 : pts) {
			if (pt.getId().equals(pt1.getId())) {
				return pt1;
			}
		}
		return null;
	}
}
