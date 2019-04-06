package com.ms.pkgs.conf;

import com.ms.pkgs.handler.DynamicRouteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 动态路由配置类
 * 
 * 
 *
 * <p>
 *
 * @author cs12110 2018年12月17日下午3:24:24
 * @since 1.0
 */
@Component
public class DynamicRouteConfig {

	@Autowired
	private ServerProperties server;

	@Autowired
	private ZuulProperties zuulProperties;

	/**
	 * 创建handler
	 * 
	 * @return {@link DynamicRouteHandler}
	 */
	@Bean
	public DynamicRouteHandler buildDynamicRouteHandler() {
		return new DynamicRouteHandler(server.getServletPrefix(), zuulProperties);
	}
}
