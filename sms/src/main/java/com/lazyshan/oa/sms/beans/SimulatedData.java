package com.lazyshan.oa.sms.beans;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

@Component("sd")
public class SimulatedData {
	private static final String location = "simulatedData.properties";
	Properties props;

	@PostConstruct
	public void init() throws IOException {
		Resource resource = new ClassPathResource(location);
		props = PropertiesLoaderUtils.loadProperties(resource);
	}

	public String getProp(String key) {
		return props.getProperty(key);
	}
}
