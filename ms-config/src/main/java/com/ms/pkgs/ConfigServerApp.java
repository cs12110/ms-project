package com.ms.pkgs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心
 * 
 *
 * <p>
 *
 * @author cs12110 2018年12月6日
 * @see
 * @since 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigServerApp {

	private static Logger logger = LoggerFactory.getLogger(ConfigServerApp.class);

	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApp.class, args);

		logger.info("Using port is:{}");
	}
}
