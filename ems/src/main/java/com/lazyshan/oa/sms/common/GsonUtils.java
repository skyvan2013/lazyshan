package com.lazyshan.oa.sms.common;

import antlr.StringUtils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lazyshan.oa.sms.models.ProductType;

public class GsonUtils {

	public static GsonBuilder getDefaultGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();
		// 自定义序列化，当被序列化的对象上有注解 是，自定义齐下属性的序列化规则
		return builder;
	}

	public static String toJson(Object obj , String... excludeField) {
		return getDefaultGsonBuilder().addSerializationExclusionStrategy(
				new PropertyExclusionStrategy(excludeField)).create().toJson(obj);
	}
	

	public static void main(String[] args) {
		ProductType p = new ProductType();
		p.setTypeId(1);
		p.setPosition(1);
		p.setProductType(p);
		p.setTypeLevel(1);
		p.setTypeName("测速");
		p.setDesc("测试第三方刷单发斯蒂芬|");
		System.out.println(GsonUtils.toJson(p,"productType"));
	}
}

class PropertyExclusionStrategy implements ExclusionStrategy {
	private String[] properties = {};

	public PropertyExclusionStrategy(String[] excludeField) {
		this.properties = excludeField;
	}

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		if (properties == null)
			return false;
		for (String property : properties) {
			if (property.equals(f.getName()))
				return true;
		}
		return false;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
}
