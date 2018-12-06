package com.ms.pkgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册中心
 * 
 *
 * <p>
 *
 * @author cs12110 2018年12月6日
 * @see
 * @since 1.0
 */
@Configuration
@EnableAutoConfiguration
@EnableEurekaServer
@RestController
public class RegApp {

	public static void main(String[] args) {
		SpringApplication.run(RegApp.class, args);
	}
}
