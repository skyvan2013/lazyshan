package com.lazyshan.oa.sms.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lazyshan.oa.sms.common.AppHelper;
import com.lazyshan.oa.sms.models.ProductType;
import com.lazyshan.oa.sms.service.ProductTypeService;

@Controller
@RequestMapping("/pt")
public class ProductTypeController extends BaseController {
	Log log = LogFactory.getLog(ProductTypeController.class);
	@Resource
	private ProductTypeService productTypeService;

	@RequestMapping("/list")
	public String toList(Model model) {
		model.addAttribute("list", productTypeService.nestedListAllProductType());
		return "productType/list";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	@ResponseBody
	public String update(@RequestBody List<ProductTypeParam> p) {
		try {
			productTypeService.updateTypes(convertToTypeList(p));
		} catch (Exception e) {
			log.info("错误：", e);
			return AppHelper.ajaxError("保存失败!");
		}
		return AppHelper.ajaxSuccess("保存成功!");
	}

	private List<ProductType> convertToTypeList(List<ProductTypeParam> ptps) {
		List<ProductType> pts = new ArrayList<ProductType>(ptps.size());
		for (ProductTypeParam p : ptps) {
			ProductType pt = new ProductType();
			pt.setId(p.getId());
			pt.setTypeName(p.getTypeName());
			pt.setSubTypes(new LinkedHashSet<ProductType>());
			if (p.getChildren() != null) {
				for (ProductType pt2 : p.getChildren()) {
					pt2.setParentType(pt);
					pt.getSubTypes().add(pt2);
				}
			}
			pts.add(pt);
		}
		return pts;
	}
}

class ProductTypeParam {
	private Integer id;
	private String typeName;
	private LinkedHashSet<ProductType> children = new LinkedHashSet<ProductType>(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public LinkedHashSet<ProductType> getChildren() {
		return children;
	}

	public void setChildren(LinkedHashSet<ProductType> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "【id:" + id + ",typeName:" + typeName + "】";
	}

}
