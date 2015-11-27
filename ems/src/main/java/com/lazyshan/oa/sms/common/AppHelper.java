package com.lazyshan.oa.sms.common;

import com.google.gson.JsonObject;

public class AppHelper {

	public static String ajaxSuccess(String message) {
		JsonObject jo = new JsonObject();
		jo.addProperty("result", "success");
		jo.addProperty("message", message);
		return jo.toString();
	}
	public static String ajaxError(String message) {
		JsonObject jo = new JsonObject();
		jo.addProperty("result", "fail");
		jo.addProperty("message", message);
		return jo.toString();
	}
}
