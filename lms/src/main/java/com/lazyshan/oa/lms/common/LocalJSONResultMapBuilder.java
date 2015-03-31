package com.lazyshan.oa.lms.common;

import java.util.HashMap;
import java.util.Map;

public class LocalJSONResultMapBuilder {
	public static Map<String,Object> getResultMap(boolean result, String message) {
		Map<String,Object> map = new HashMap<>();
		map.put("success", result);
		map.put("message", message);
		return map;
	}
}
