package com.ms.pkgs.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.pkgs.service.FeignService;

@RestController
public class FeignCtrl {

	@Autowired
	private FeignService feignService;

	@RequestMapping("/feign/say")
	public String feignSay(String str) {
		return this + "->" + feignService.say(str);
	}
}
