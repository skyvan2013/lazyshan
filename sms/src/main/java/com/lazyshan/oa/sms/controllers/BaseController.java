package com.lazyshan.oa.sms.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lazyshan.oa.sms.beans.SimulatedData;

public class BaseController {
	@Resource
	private SimulatedData simulatedData;

	@ResponseBody
	@RequestMapping(value = "/sd/{sid}", produces = "application/json;charset=UTF-8")
	public String simulateData(@PathVariable("sid") String sid) {
		return simulatedData.getProp(sid);
	}
}
