package com.ms.pkgs.service.fallback;

import org.springframework.stereotype.Component;

import com.ms.pkgs.service.FeignService;

/**
 * fallback
 * 
 * 
 *
 * <p>
 *
 * @author cs12110 2018年12月17日下午1:35:03
 * @see
 * @since 1.0
 */
@Component
public class FeginServiceFallbackImpl implements FeignService {

	@Override
	public String say(String soemthing) {
		return "fallback say: " + soemthing;
	}

}
