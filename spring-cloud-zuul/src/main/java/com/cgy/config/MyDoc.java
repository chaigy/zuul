package com.cgy.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="cgy")
public class MyDoc {
	
	private List<String> pack;

	public List<String> getPack() {
		return pack;
	}

	public void setPack(List<String> pack) {
		this.pack = pack;
	}
	
}
