package com.lazyshan.oa.sms.controllers;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.LastModified;
import org.springframework.web.servlet.support.WebContentGenerator;

import com.lazyshan.oa.sms.beans.SimulatedData;

public class BaseController{

	@Resource
	public SimulatedData simulatedData;
	
	@Resource
	protected HttpServletRequest request;
	@Resource
	protected HttpServletResponse response;

	@ResponseBody
	@RequestMapping(value = "/sd/{sid}", produces = "application/json;charset=UTF-8")
	public String simulateData(@PathVariable("sid") String sid) {
		return simulatedData.getProp(sid);
	}
	
	@ModelAttribute
	public void doNotCache(){
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
	}
}
