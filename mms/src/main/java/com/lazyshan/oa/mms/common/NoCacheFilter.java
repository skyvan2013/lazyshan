package com.lazyshan.oa.mms.common;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.datetime.DateFormatter;

public class NoCacheFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;  
        res.setDateHeader("Expires", 0);  
        res.setHeader("Cache-Control", "no-cache");  
        res.setHeader("Pragma", "no-cache");  
        res.setHeader("Last-Modified", new Date().toGMTString());
//        res.setHeader("Etag", new Random().toString());
        chain.doFilter(request,res);
	}

	@Override
	public void destroy() {
		
	}

}
