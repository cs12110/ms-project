package com.ms.pkgs.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ms.pkgs.conf.RedisConf;

@RestController
@RequestMapping("/auth")
public class AuthCtrl {

	@Autowired
	private RedisConf redis;

	@RequestMapping("/info/")
	public String getInfos(/*@PathVariable("id")*/ String id) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			map.put("redis", redis.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("timestamp", System.currentTimeMillis());
		map.put("id", id);

		return JSON.toJSONString(map);
	}

}
