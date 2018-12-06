package com.ms.pkgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Feign客户端
 * 
 *
 * <p>
 * 
 * feign继承了ribbon和hystrix,可以实现负载均衡+熔断
 *
 * @author cs12110 2018年12月6日
 * @see
 * @since 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignApp {

	public static void main(String[] args) {
		SpringApplication.run(FeignApp.class, args);
	}
}
