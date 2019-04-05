package com.ms.pkgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者启动入口
 *
 *
 * <p>
 * <p>
 * 使用springcloud config的时候,要把Application.properties文件命名为boostrap.properties
 * <p>
 * 优先使用git上面存在的数据
 *
 * <p>
 * <p>
 * springcloud config适用于配置数据库等公用资源.
 *
 * <pre>
 *
 * /{application}/{profile}[/{label}]
 *
 * /{application}-{profile}.yml
 *
 * /{label}/{application}-{profile}.yml
 *
 * /{application}-{profile}.properties
 *
 * /{label}/{application}-{profile}.properties
 *
 * </pre>
 *
 * @author cs12110 2018年12月6日
 * @since 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApp.class, args);
    }
}
