package com.cgy.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
public class MySwagger  implements SwaggerResourcesProvider{

	@Autowired
	private MyDoc doc;
	
	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> list =new ArrayList<>();
		for(String item: doc.getPack()) {
			String[] pp = item.split(",");
			if(pp.length>=3) {
				list.add(getSwaggerSource(pp[0], pp[1], pp[2]));
			}
		}
		return list;
	}
	
	public SwaggerResource getSwaggerSource(String name,String location,String version) {
		SwaggerResource resource= new SwaggerResource();
		resource.setLocation(location);
		resource.setName(name);
		resource.setSwaggerVersion(version);
		return resource;
	}

}
