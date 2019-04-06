package com.ms.pkgs.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤器
 *
 *
 * <p>
 *
 * @author cs12110 2018年12月6日
 * @since 1.0
 */
@Component
@Slf4j
public class TokenFilter extends ZuulFilter {

    /**
     * 设置为true,才会拦截
     *
     * @see com.netflix.zuul.IZuulFilter#shouldFilter()
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        log.info(request.getRequestURI());

        // 校验请求token
        String token = request.getParameter("token");

        // 非法token
        if (null == token || "".equals(token.trim())) {
            // 不对请求进行路由
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(400);
            context.setResponseBody("token is empty");
        } else {
            // 对请求进行路由
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
        }

        return null;
    }

    /**
     * 过滤类型
     * <p>
     * <p>
     * pre: 可以在请求被路由之前调用 <br>
     * route: 在路由请求时候被调用<br>
     * post: 在route和error过滤器之后被调用<br>
     * error: 处理请求时发生错误时被调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤优先等级
     * <p>
     * 数字越大，优先级越低
     */
    @Override
    public int filterOrder() {
        return 0;
    }

}
