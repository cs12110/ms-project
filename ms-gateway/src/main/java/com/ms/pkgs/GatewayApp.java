package com.ms.pkgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 统一网关路由入口
 * 
 *
 * <p>
 *
 * @author cs12110 2018年12月6日
 * @since 1.0
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class GatewayApp {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApp.class, args);
	}

}
