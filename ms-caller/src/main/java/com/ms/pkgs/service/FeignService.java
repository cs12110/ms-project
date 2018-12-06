package com.ms.pkgs.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 调用接口
 * 
 *
 * <p>
 * 
 * <pre>
 * 
 * `@FeignClient` 里面的name为服务项目的名称
 * 
 * `@RequestMapping` 为 服务的请求地址
 * </pre>
 *
 * @author cs12110 2018年12月6日
 * @see
 * @since 1.0
 */
@FeignClient(name = "ms-service")
public interface FeignService {

	@RequestMapping("/hello/say")
	public String say(String soemthing);
}
