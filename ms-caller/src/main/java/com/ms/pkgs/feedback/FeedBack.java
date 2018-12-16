package com.ms.pkgs.feedback;

import org.springframework.stereotype.Component;

import com.ms.pkgs.service.FeignService;

/**
 * 熔断机制
 *
 * 
 * @author cs12110 at 2018年12月16日下午6:51:16
 *
 */
@Component
public class FeedBack implements FeignService {

	@Override
	public String say(String something) {

		return "feign feedback say: " + something;
	}

}
