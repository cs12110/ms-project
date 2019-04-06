package com.ms.pkgs.ctrl;

import com.ms.pkgs.handler.DynamicRouteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 刷新路由
 *
 *
 *
 * <p>
 *
 * @author cs12110 2018年12月17日下午3:32:32
 * @since 1.0
 */
@Controller
@RequestMapping("/route")
@Slf4j
public class RouteCtrl {


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
        log.info("refresh route by web req");
        dynamicRouteHandler.refresh();
        return "{status:1,msg:\"ok\"}";
    }
}
