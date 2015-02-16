package com.lazyshan.oa.mms.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lazyshan.oa.mms.mapper.ProductMapper;
import com.lazyshan.oa.mms.model.Product;

/**
 * 产品控制类
 * 
 * @author skyvan
 *
 */

@Controller
public class ProductController {
	public ProductMapper productMapper;

	
	
	
	/**
	 * 添加一个产品
	 * 
	 * @return
	 */
	@RequestMapping("/product/add")
	public String addProduct() {
		Product product = new Product();

		productMapper.addProduct(product);
		return "index";
	}

	/**
	 * 列出产品列表
	 * 
	 * @return
	 */
	public ModelAndView listProducts() {
		return null;
	}
}
