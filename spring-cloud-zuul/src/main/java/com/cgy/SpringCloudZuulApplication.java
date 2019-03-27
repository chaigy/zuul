package com.cgy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.cgy.config.MyDoc;
import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication
@EnableSwagger2Doc
@EnableEurekaClient
@EnableZuulProxy
public class SpringCloudZuulApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulApplication.class, args);
	}

	
	@Autowired
	private MyDoc dd;
	


}
