package com.ms.pkgs.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;

import com.alibaba.fastjson.JSON;
import com.ms.pkgs.util.JdbcUtil;

/**
 * 动态路由加载handler
 * 
 * <p>
 * 
 * 从数据里面加载数据
 *
 * @author cs12110 2018年12月17日下午2:57:10
 * @see
 * @since 1.0
 */
public class DynamicRouteHandler extends SimpleRouteLocator implements RefreshableRouteLocator {

	private static Logger logger = LoggerFactory.getLogger(DynamicRouteHandler.class);

	private static String beforeJsonStr = "";

	public DynamicRouteHandler(String servletPath, ZuulProperties properties) {
		super(servletPath, properties);
	}

	@Override
	protected Map<String, ZuulRoute> locateRoutes() {
		Map<String, ZuulRoute> routeMap = new HashMap<>();
		routeMap.putAll(super.locateRoutes());
		routeMap.putAll(loadFromDb());

		if (logger.isDebugEnabled()) {
			String json = JSON.toJSONString(routeMap, true);

			if (!json.equals(beforeJsonStr)) {
				logger.info("{}", json);
				beforeJsonStr = json;
			}
		}

		return routeMap;
	}

	/**
	 * 从数据库里面获取路由数据
	 * 
	 * @return Map
	 */
	private Map<String, ZuulRoute> loadFromDb() {
		Map<String, ZuulRoute> routeMap = new HashMap<>();
		Connection conn = JdbcUtil.getConnection();
		try {
			Statement stm = conn.createStatement();
			// 获取启用的api
			ResultSet result = stm.executeQuery("select * from gateway_api_t where enabled=1");
			while (result.next()) {
				ZuulRoute route = new ZuulRoute();
				route.setId(result.getString("id"));
				route.setPath(result.getString("path"));
				route.setServiceId(result.getString("service_id"));
				route.setRetryable(1 == result.getInt("retryable"));
				route.setStripPrefix(1 == result.getInt("strip_prefix"));

				routeMap.put(route.getPath(), route);
			}
			JdbcUtil.close(result);
			JdbcUtil.close(stm);
		} catch (Exception e) {
			logger.error("{}", e);
		} finally {
			JdbcUtil.close(conn);
		}
		return routeMap;
	}

	/**
	 * 刷新路由
	 */
	@Override
	public void refresh() {
		doRefresh();
	}
}
