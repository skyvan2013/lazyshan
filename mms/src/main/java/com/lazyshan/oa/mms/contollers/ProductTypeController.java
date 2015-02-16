package com.lazyshan.oa.mms.contollers;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lazyshan.oa.mms.common.Pager;
import com.lazyshan.oa.mms.common.Pager.OutPager;
import com.lazyshan.oa.mms.model.ProductType;
import com.lazyshan.oa.mms.services.ProductTypeService;

/**
 * 商品类型增删改Controller
 * 
 * @author skyvan
 *
 */
@Controller
@RequestMapping("/pt")
public class ProductTypeController {
	private Log log = LogFactory.getLog(getClass());
	@Resource
	ProductTypeService productTypeService;

	/**
	 * 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "list")
	public ModelAndView toList() {
		log.info("执行ProductTypeController.list");
		return new ModelAndView("product/ptlist");
	}

	/**
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "ajax/listAllProductType")
	public OutPager<ProductType> list(Pager<ProductType> pager) {
		productTypeService.listProductType(pager);
		return pager.toOutPager();
	}
	/**
	 * 编辑或添加产品类型
	 * @param productType 产品类型ID，如果为空则是添加
	 * @return
	 */
	@RequestMapping("editpt")
	public String toEdit(String productType) {
		return "product/editProductType";
	}
	
	@RequestMapping("savept")
	@ResponseBody
	public Map<String,String> save(ProductType productType,Map<String,String> map){
		System.out.println(productType);
		map.put("result", "success");
		return  map;
	}
}
