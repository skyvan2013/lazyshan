package com.lazyshan.oa.sms.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
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
		Gson gson =  new GsonBuilder()
		.registerTypeAdapter(ProductType.class, new JsonSerializer<ProductType>() {
			@Override
			public JsonElement serialize(ProductType src, Type typeOfSrc,
					JsonSerializationContext context) {
				System.out.println("哈哈哈哈哈哈啊"+src.getTypeId());
				return new JsonPrimitive(src.getTypeId());
			}
		}).create();
		return gson.toJson(pts);
	}

}
