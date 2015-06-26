package com.lazyshan.oa.sms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashBorad {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
