package com.ms.pkgs.handler;

import com.alibaba.fastjson.JSON;
import com.ms.pkgs.util.JdbcUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态路由加载handler
 *
 * <p>
 * <p>
 * 从数据里面加载数据
 *
 * @author cs12110 2018年12月17日下午2:57:10
 * @since 1.0
 */
@Slf4j
public class DynamicRouteHandler extends SimpleRouteLocator implements RefreshableRouteLocator {

    private static String routeMapJsonStr = "";

    public DynamicRouteHandler(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    @Override
    protected Map<String, ZuulRoute> locateRoutes() {
        Map<String, ZuulRoute> routeMap = new HashMap<>();
        routeMap.putAll(super.locateRoutes());
        routeMap.putAll(loadFromDb());

        if (log.isDebugEnabled()) {
            String json = JSON.toJSONString(routeMap, true);
            if (!json.equals(routeMapJsonStr)) {
                log.info("{}", json);
                routeMapJsonStr = json;
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
        Connection conn = JdbcUtil.getConnection();
        Statement stm = null;
        ResultSet result = null;
        Map<String, ZuulRoute> routeMap = new HashMap<>();
        try {
            // 获取启用的api
            stm = conn.createStatement();
            result = stm.executeQuery("select * from gateway_api_t where enabled=1");

            while (result.next()) {
                ZuulRoute route = new ZuulRoute();
                route.setId(result.getString("id"));
                route.setPath(result.getString("path"));
                route.setServiceId(result.getString("service_id"));
                route.setRetryable(1 == result.getInt("retryable"));
                route.setStripPrefix(1 == result.getInt("strip_prefix"));

                routeMap.put(route.getPath(), route);
            }
        } catch (Exception e) {
            log.error("{}", e.getMessage());
        } finally {
            JdbcUtil.close(result);
            JdbcUtil.close(stm);
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
