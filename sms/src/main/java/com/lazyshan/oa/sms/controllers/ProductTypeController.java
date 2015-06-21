package com.lazyshan.oa.sms.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lazyshan.oa.sms.models.ProductType;
import com.lazyshan.oa.sms.service.ProductTypeService;

@Controller
@RequestMapping("/pt")
public class ProductTypeController extends BaseController {
	@Resource
	private ProductTypeService productTypeService;

	@RequestMapping("/list")
	public String toList() {
		List<ProductType> pts = productTypeService.listProductTypes();
		System.out.println("结果集为："+pts.size());
		return "/product/list";
	}
	@RequestMapping("/list2")
	public String toList2() {
		return "/product/list2";
	}

}
