package com.ms.pkgs.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms.pkgs.handler.DynamicRouteHandler;

/**
 * 刷新路由
 * 
 * 
 *
 * <p>
 *
 * @author cs12110 2018年12月17日下午3:32:32
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/route")
public class RouteCtrl {

	private static Logger logger = LoggerFactory.getLogger(RouteCtrl.class);

	@Autowired
	private DynamicRouteHandler dynamicRouteHandler;

	/**
	 * 刷新route
	 * 
	 * @return String
	 */
	@RequestMapping("/refresh")
	@ResponseBody
	public String refresh() {
		logger.info("refresh route by web req");
		dynamicRouteHandler.refresh();
		return "{status:1,msg:\"ok\"}";
	}
}
