package com.lazyshan.oa.sms.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lazyshan.oa.sms.common.GsonUtils;
import com.lazyshan.oa.sms.models.ProductType;
import com.lazyshan.oa.sms.service.ProductTypeService;

@Controller
@RequestMapping("/pt")
public class ProductTypeController extends BaseController {
	@Resource
	private ProductTypeService productTypeService;

	@RequestMapping("/list")
	public String toList(Model model) {
		return "product/list";
	}

	@RequestMapping("/list.json")
	@ResponseBody
	public String ajaxListData() {
		List<ProductType> pts = productTypeService.nestedListAllProductType();
		return GsonUtils.toJson(pts, "productType");
	}

}
