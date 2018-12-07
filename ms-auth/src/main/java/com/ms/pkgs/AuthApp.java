package com.ms.pkgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 校验入口类
 * 
 *
 * <p>
 *
 * @author cs12110 2018年12月7日
 * @see
 * @since 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class AuthApp {

	public static void main(String[] args) {
		SpringApplication.run(AuthApp.class, args);
	}
}
