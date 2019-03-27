package com.cgy.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class MyFilter extends ZuulFilter {

	
	/**
	 * 是否启用此过滤器
	 */
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		
		String token = context.getRequest().getParameter("token");
		if(StringUtils.isEmpty(token)) {
			context.setSendZuulResponse(false);
			context.setResponseBody("token is null");
			context.setResponseStatusCode(401);
			System.out.println("我是到了这里返回了.....");
			return null;
		}
		
		System.out.println("我是走到了下一层.....");
		return null ;
	}

	/**
	 * 过滤器类型(pre  前置过来  post 后置过滤)
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤器执行顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
